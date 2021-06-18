package poczta;

import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Klient {
    private Socket gniazdo = null;
    private ObjectOutputStream output;
    private BazaDanych bazaDanych;
    private ObslugaStrumieni strumien;
    private Wydarzenie wydarzenie = new Wydarzenie();
    private boolean czyWlaczony = false;
   // private poczta.Konto aktualneKonto;
    private String sciezka = "C:\\Users\\Dell\\po2020\\DaneKlienta";

    public Klient(String nazwaHosta, int port){
        try {

            gniazdo = new Socket(nazwaHosta, port);
            czyWlaczony = true;
            wczytajBaze();
            strumien = new ObslugaStrumieni(gniazdo,bazaDanych,wydarzenie); // moze do funkcji zaloguj / zaloz konto

            if (!Files.isDirectory(Paths.get(sciezka)))
                Files.createDirectory(Paths.get(sciezka));

            //zaloguj();
           // System.out.println(bazaDanych.get("mk@o.pl").getListaId());

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    public void zamknijKlienta(){
        try {
            czyWlaczony = false;
            gniazdo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void wyslij(Wiadomosc wiadomosc){
        if (wiadomosc.getPolecenie().equals("mail")){
            String aktEmail = bazaDanych.getAktualneKonto().getEmail();
            wiadomosc.setId(bazaDanych.get(aktEmail).kolejneId());
            //wiadomosc.setNoweId(0);
        }
        System.out.println("\npoczta.Klient: Wysylam wiadomosc: polecenie: " + wiadomosc.getPolecenie()+ ", id: "+ wiadomosc.getId() + ", noweId: " + wiadomosc.getNoweId());
        strumien.wyslij(wiadomosc);
    }
    public void wyslij(Konto konto,String polecenie){
        konto.setPolecenie(polecenie);
        System.out.println("\npoczta.Klient: Wysylam obiekt typu poczta.Konto o poleceniu: " + konto.getPolecenie());
        strumien.wyslij(konto);
    }
    public void wyslij(Object obj){
        strumien.wyslij(obj);
    }
    public void synchronizuj(){
        ListaInt lista = new ListaInt(bazaDanych.getAktFolderKonta().getListaBrakId(),"synchronizuj");
        if(lista.getLista().isEmpty()){
            int maxId = bazaDanych.getAktFolderKonta().kolejneId() - 1;
            System.out.println("\npoczta.Klient: Wysylam wiadomosc maxId o wartosci: " + maxId);
            strumien.wyslij(new Wiadomosc("maxId",maxId));
        }
        else {
            System.out.println("\npoczta.Klient: Wysylam obiekt typu poczta.ListaInt o zawartosci:");
            System.out.println(lista.getLista());
            strumien.wyslij(lista);
        }
    }

    public void wczytajBaze() {
        //String sciezka = bazaDanych.getSciezka();
        if(Files.exists(Paths.get(sciezka+File.separator+"bazaDanych"))) {
            try {
                System.out.println("Wykryto istniejaca baze danych");
                FileInputStream fileInputStream = new FileInputStream(sciezka+File.separator+"bazaDanych");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                bazaDanych = ((BazaDanych) objectInputStream.readObject());
                objectInputStream.close();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else {
            System.out.println("Tworze nowa baze danych");
            bazaDanych = new BazaDanych(sciezka);
            Konto guest = new Konto("Guest","Guest","guest@o.pl","guest",null);
            bazaDanych.stworzKonto(guest,true);
            System.out.println(bazaDanych);
        }
    }

    public void zapiszBaze() {
        System.out.print("Zapisuje baze danych ... ");
        try {
            FileOutputStream file = new FileOutputStream(sciezka+File.separator+"bazaDanych");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(bazaDanych);
            output.close();

            System.out.println("Zapisano");
        } catch (Exception e) {
            System.out.println("Wystapil blad: "+ e.getMessage());
        }
    }

    public void zaloguj(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(bazaDanych.getAktualneKonto() == null) {
            try {
                System.out.println("Email:");
                String email = reader.readLine();
                System.out.println("Haslo:");
                String haslo = reader.readLine();

                System.out.println("Wysylam do serwera prosbe o autoryzacje");
                wyslij(new Wiadomosc("autoryzuj", email, haslo));
                wydarzenie.przerwijGdy("logowanieResponse");
            } catch (IOException e) {
                System.out.println("Logowanie: " + e.getMessage());
            }
        }

        // po poprawnym zalogowaniu poczta.Interpreter ustawi w bazaDanych zmienną aktualneKonto
        //TODO: synchronizacja
    }
    // logowanie z GUI
    public boolean zaloguj(String email, String haslo){
            //System.out.println("Wysylam do serwera prosbe o autoryzacje");
            wyslij(new Wiadomosc("autoryzuj", email, haslo));
            wydarzenie.przerwijGdy("logowanieResponse");
            if (bazaDanych.getAktualneKonto() == null)
                return false;
            else
                return true;
    }
    public void wyloguj(){
        bazaDanych.setAktualneKonto(null);
    }

    public Wydarzenie getWydarzenie() {
        return wydarzenie;
    }

    public void setWydarzenie(Wydarzenie wydarzenie) {
        this.wydarzenie = wydarzenie;
    }

    public BazaDanych getBazaDanych() {
        return bazaDanych;
    }

    public void setBazaDanych(BazaDanych bazaDanych) {
        this.bazaDanych = bazaDanych;
    }

}
