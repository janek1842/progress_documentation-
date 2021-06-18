package poczta;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.*;


public class FolderKonta extends Konto{
    private String sciezka;
    private HashMap <Integer,String> listaId = new HashMap<Integer, String>(); //id,nazwaFolderu

    public FolderKonta (Konto konto,String sciezka){
        super(konto);
        this.sciezka = sciezka;
        stworzFoldery();
        listaId.put(0,"info o koncie");
        zapiszKonto(konto);
    }


    public void stworzFoldery(){

        try {
            ArrayList <String> tab = new ArrayList<String>(Arrays.asList("Odebrane","Wyslane","Kosz","Szkice","Spam"));
            for (String folder : tab){
                Files.createDirectories(Paths.get(sciezka+File.separator+getEmail()+File.separator+folder));
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
    public int kolejneId(){

        int tmp=0;
        int wynik = 0;
        for(Map.Entry m : listaId.entrySet()){
            tmp = ((Integer) m.getKey()).intValue();
            if(Math.abs(tmp)>=Math.abs(wynik))
            {
                wynik = tmp;
            }
        }
        return (Math.abs(wynik)+1);
    }
    public int dodajWiadomosc(Wiadomosc wiadomosc1,String nazwaFolderu){
        Wiadomosc wiadomosc = new Wiadomosc(wiadomosc1);
        int id;
        if (wiadomosc.getNoweId() != 0)
            id = wiadomosc.getNoweId();
        else
            id = kolejneId();

        wiadomosc.setId(id);
        listaId.put(wiadomosc.getId(),nazwaFolderu);
        //try {
       //     Files.createFile(Paths.get(sciezka+File.separator+getEmail()+File.separator+nazwaFolderu + File.separator +File.separator+ String.valueOf(wiadomosc.getId())));
       // }
       // catch (IOException e)
        //{
       //     System.out.print("poczta.FolderKonta,dodajWiadomosc,Files.create.. " + e.getMessage());
       // }

        try {
            FileOutputStream file = new FileOutputStream(sciezka+File.separator+getEmail()+File.separator+nazwaFolderu + File.separator + String.valueOf(wiadomosc.getId()));
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(wiadomosc);
            output.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.print(e);
        }
        catch (IOException f)
        {
            System.out.print(f);
        }
        return id;
    }
    public void usunWiadomosc(int id, boolean czyPerm){
        /*
        - czyPerm (czyPermamentnie): jeżeli false to przenosi do folderu Kosz, jak true to usuwa z pamieci
        przenosi do kosza:
        - przenosi do Kosz
        - zmienia nazwe folderu z listaId na "Kosz"
        usuwa z pamieci:
        - usuwa wiadomosc
        - zmienia id z listaId na wartość przeciwną (ujemną)
         */
        if(czyPerm){
            try {
                Files.deleteIfExists(Paths.get(sciezka +File.separator+getEmail()+ File.separator + listaId.get(id) +File.separator+ id));
                //listaId.put(id, String.valueOf((-1) * id));
                listaId.remove(id);
                listaId.put(-id,"Usuniete");
            }catch(IOException e) {
                System.out.print(e);
            }
        }
        else
        {
            try {
                Files.move(Paths.get(sciezka + File.separator + getEmail() + File.separator + listaId.get(id) + File.separator+id), Paths.get(sciezka + File.separator + getEmail() + File.separator + "Kosz" + File.separator + id));
            }
            catch (IOException e)
            {
                System.out.print("Blad przenoszenia pliku: " + e.getMessage());
            }
            listaId.put(id,"Kosz");
        }
    }

    public Wiadomosc czytajwiadomosc(int id){

        try {
            FileInputStream fileStream = new FileInputStream(sciezka+File.separator + getEmail() + File.separator+listaId.get(id) + File.separator + id);
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            Wiadomosc wiadomosc = (Wiadomosc) objStream.readObject();
            objStream.close();
            return wiadomosc;
        }
        catch (Exception e)
        {
            System.out.println("poczta.FolderKonta: blad wczytywania wiadomosci" + e.getMessage());
            return null;
        }

    }

    public void zapiszKonto (Konto konto){
        // zapisz do pliku obiekt typu konto (nazwa pliku: 0, Folder: Główny (email))
        setNazwa(konto.getNazwa());
        setNazwisko(konto.getNazwisko());
        setHaslo(konto.getHaslo());
        setEmailZapasowy(konto.getEmailZapasowy());
        try {
            FileOutputStream fileStream = new FileOutputStream(sciezka + File.separator + getEmail() + File.separator + "0");
            ObjectOutputStream output = new ObjectOutputStream(fileStream);
            output.writeObject(konto);
            output.close();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
    public Konto getKonto(){
        // zwraca poczta.Konto zapisane w pliku "0"
        try {
            FileInputStream fileStream = new FileInputStream(sciezka + File.separator + getEmail() + File.separator + "0");
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            Konto konto = (Konto) objStream.readObject();
            objStream.close();
            return konto;
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
    }




    public void zmienId (int stareId, int noweId){
        /*
        zamienia stareId na noweId
        zatem trzeba:
                - odczytać wiadomosc o nazwie "stareId" (czytajWiadomosc)
                - zapemietaj se nazwe folderu, w ktorym była wiadomosc (zmienna String)
                - usunąć wiadomość (w sensie plik) (usunWiadomosc)
                - dodajWiadomosc(wiadomosc, String nazwaFolderu)
         */
        //listaId.put(noweId,listaId.get(stareId));
        Wiadomosc wiadomosc = czytajwiadomosc(stareId);
        wiadomosc.setId(noweId);
        listaId.put(noweId,listaId.get(stareId));
        String tmp = listaId.get(stareId);
        listaId.remove(stareId,listaId.get(stareId));
        try {
            //Path source = Paths.get(sciezka + File.separator + getEmail() + File.separator + tmp + File.separator + stareId);
            //Path target = Paths.get(sciezka + File.separator + getEmail() + File.separator + tmp + File.separator + noweId);
            //Files.move(source, target);
            Files.createFile(Paths.get(sciezka + File.separator + getEmail() + File.separator + tmp + File.separator + noweId));
            FileOutputStream file = new FileOutputStream(sciezka + File.separator + getEmail() + File.separator + tmp + File.separator + noweId);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(wiadomosc);
            output.close();

            Files.deleteIfExists(Paths.get(sciezka + File.separator + getEmail() + File.separator +tmp + File.separator + stareId));

        }

        catch (Exception e)
        {
            System.out.println("zmienId: "+ e.getMessage());
        }


    }

    public ArrayList <Wiadomosc> synchronizuj (int id){
        ArrayList <Wiadomosc> lista = new ArrayList<Wiadomosc>();
        int tmp;
        for(Map.Entry m : listaId.entrySet()){
            tmp = ((Integer) m.getKey()).intValue();
            if(tmp>0 && tmp>id) //TODO: moze zamiast sprawdzac tmp > 0 to new poczta.Wiadomosc("wiadomoscUsunieta") ??
            {
                lista.add(czytajwiadomosc(tmp));
            }
        }
        return lista;
    }


    public ArrayList <Integer> getListaBrakId (){
        ArrayList <Integer> lista = new ArrayList<Integer>(); //lista brakujących elementów
        for (int i = 1; i < kolejneId(); i++){
            if(!listaId.containsKey(i)){
                if (!listaId.containsKey(-i))
                     lista.add(i);
            }
        }
        return lista;
    }

    // ------------- gettery/settery -----------------

    public HashMap<Integer, String> getListaId() {
        return listaId;
    }
}