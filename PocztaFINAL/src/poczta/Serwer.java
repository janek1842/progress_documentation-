package poczta;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serwer extends Thread{

    private String adres;
    private int port;
    private boolean czyWlaczony = false; //serwer wyłączony
    private BazaDanych bazaDanych;
    private Wydarzenie wydarzenie = new Wydarzenie();
    private String sciezka = "C:\\Users\\Dell\\po2020\\DaneSerwera";

    public Serwer(String adres, int port) {
        this.adres = adres;
        this.port = port;
        wczytajBaze();
    }

    public Serwer (String adres, int port, BazaDanych bazaDanych){
        this.adres = adres;
        this.port = port;
        this.bazaDanych = bazaDanych;
    }

    public void uruchomSerwer(){
        Runnable nasluchiwacz = new Runnable() {
            public void run() {
                try {
                    ServerSocket gniazdoSerwera = new ServerSocket(port);
                    System.out.println("poczta.Serwer nasluchuje na porcie " + port);
                    czyWlaczony = true;

                    while(czyWlaczony){
                        Socket gniazdoKlienta = gniazdoSerwera.accept();
                        System.out.println("Polaczono z nowym klientem");
                        new ObslugaStrumieni(gniazdoKlienta,bazaDanych,wydarzenie);
                    }
                } catch (IOException e) {
                    System.out.println("Blad tworzenia gniazdoSerwera: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };

        new Thread(nasluchiwacz).start();
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
            bazaDanych = new BazaDanych(sciezka);
            System.out.println("Tworze nowa baze danych");
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



    public static void main(String args[]){
        if (args.length < 2) return;

        String nazwaHosta = args[0];
        int port = Integer.parseInt(args[1]);

        Serwer s = new Serwer(nazwaHosta,port);

        // TODO: do konstruktora serwera
        Konto admin = new Konto("admin",null,"admin@admin","admin",null);
        s.bazaDanych.stworzKonto(admin,true);

        Konto konto = new Konto("Michal","Kurdziel","mk@o.pl","1234",null);
        s.bazaDanych.stworzKonto(konto,true);

        s.uruchomSerwer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String p = null;
            try {
                p = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (p.equals("x")) break;
            if(p.equals("z")) s.zapiszBaze();
            if(p.equals("d")) s.bazaDanych.dodajWiadomosc(new Wiadomosc("mail","mk@o.pl","mk@o.pl","proba","sfs"));
            if(p.equals("konto")) s.bazaDanych.get("mk@o.pl").wyswietlInformacje();
        }
        s.zapiszBaze();
    }
}
