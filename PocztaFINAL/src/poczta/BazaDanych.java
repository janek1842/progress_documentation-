package poczta;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class BazaDanych extends HashMap <String,FolderKonta> implements Serializable {
    private String sciezka;
    private Konto aktualneKonto = null;

    public BazaDanych(String sciezka) {
        this.sciezka = sciezka;
    }

    public Konto getKonto(String email) {
        return get(email);
    }

    public boolean stworzKontoKlient(Konto konto) {
        if (containsKey(konto.getEmail())) {
            return false;
        } else {
            konto.setKluczSzyfrowania(generujKlucz(16));
            put(konto.getEmail(), new FolderKonta(konto, sciezka));
            zapiszBaze();
        }
        return true;
    }
    public boolean stworzKonto(Konto konto,boolean czyGenKlucz) {
        if (containsKey(konto.getEmail())) {
            return false;
        } else {
            if (czyGenKlucz) {
                konto.setKluczSzyfrowania(generujKlucz(16));
            }
            put(konto.getEmail(), new FolderKonta(konto, sciezka));
            zapiszBaze();
        }
        return true;
    }

    public boolean usunKonto(Konto konto) {
        //TODO : ...
        if (containsKey(konto.getEmail())) {
            remove(konto.getEmail(), konto);
            return true;
        }
        return false;
    }

    public int dodajWiadomosc(Wiadomosc wiadomosc) { // dla serwera

        if (!containsKey(wiadomosc.getNadawca())) {
            System.out.println("poczta.Konto nadawcy nie istnieje: " + wiadomosc.getNadawca());
            return 0;
        }
        if (!containsKey(wiadomosc.getOdbiorca())) {
            System.out.println("poczta.Konto odbiorcy nie istnieje: " + wiadomosc.getOdbiorca());
            return 0;
        }

        if (wiadomosc.getOdbiorca().equals(wiadomosc.getNadawca())) { //wysyłanie wiadomosci do samego siebie
            return get(wiadomosc.getNadawca()).dodajWiadomosc(wiadomosc, "Wyslane");
        } else {
            if (get(wiadomosc.getOdbiorca()) != null) // powód: patrz interpreter (ListaWiad)
                get(wiadomosc.getOdbiorca()).dodajWiadomosc(wiadomosc, "Odebrane");
            return get(wiadomosc.getNadawca()).dodajWiadomosc(wiadomosc, "Wyslane");
        }
    }
    public void dodajWiadomoscKlient(Wiadomosc wiadomosc){
        //dodaje wiadomosci tylko do nadawcy
        String aktEmail = aktualneKonto.getEmail();
        if (wiadomosc.getOdbiorca().equals(aktEmail) && wiadomosc.getNadawca().equals(aktEmail)){
            get(wiadomosc.getNadawca()).dodajWiadomosc(wiadomosc, "Wyslane");
        }
        else if (wiadomosc.getNadawca().equals(aktEmail)){
            get(wiadomosc.getNadawca()).dodajWiadomosc(wiadomosc, "Wyslane");
        }
        else if (wiadomosc.getOdbiorca().equals(aktEmail)){
            get(wiadomosc.getOdbiorca()).dodajWiadomosc(wiadomosc, "Odebrane");
        }
    }

    public void zapiszBaze() {
        System.out.print("Zapisuje baze danych ... ");
        try {
            FileOutputStream file = new FileOutputStream(sciezka+File.separator+"bazaDanych");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(this);
            output.close();

            System.out.println("Zapisano");
        } catch (Exception e) {
            System.out.println("Wystapil blad: "+ e.getMessage());
        }
    }

    public String generujKlucz(int rozmiar){
        //TODO: moze niech bedzie unikalny?
        Random generator = new Random();
        char [] klucz = new char[rozmiar];
        for (int i = 0; i < rozmiar; i++){
            int kod = generator.nextInt(58) + 65;
            klucz[i] = (char) kod;
        }
        return new String(klucz);
    }

    public HashMap<Integer,String> getAktListaId(){
        return get(aktualneKonto.getEmail()).getListaId();
    }
    public FolderKonta getAktFolderKonta(){
        return get(aktualneKonto.getEmail());
    }
    public void setAktualneKonto(Konto konto){
        aktualneKonto = konto;
    }
    public Konto getAktualneKonto() {
        return aktualneKonto;
    }
    public String getSciezka() {
        return sciezka;
    }
}