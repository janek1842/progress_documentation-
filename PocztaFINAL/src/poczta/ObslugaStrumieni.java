package poczta;

import java.io.*;
import java.net.*;

public class ObslugaStrumieni extends Thread {
    private Socket gniazdo = null;
    private ObjectOutputStream output;
    private Interpreter interpreter;
    private boolean czyAktywny = true;

    public ObslugaStrumieni(Socket gniazdoKlienta, BazaDanych bazaDanych, Wydarzenie wydarzenie) {
        this.gniazdo = gniazdoKlienta;
        this.interpreter = new Interpreter(bazaDanych,wydarzenie);
        start();
    }

    public void run() {

        try {
            Object obj;
            Object odpowiedz;
            ObjectInputStream input;

            while (true) {
                input = new ObjectInputStream(gniazdo.getInputStream());
                obj = input.readObject();

                if (obj instanceof Wiadomosc || obj instanceof Konto || obj instanceof ListaInt || obj instanceof ListaWiadomosci) {

                    System.out.println("\npoczta.ObslugaStrumieni: Odebrano wiadomosc");
                    odpowiedz = interpreter.wykonaj(obj);

                    if (odpowiedz instanceof Wiadomosc) {
                        Wiadomosc wiadomosc = (Wiadomosc) odpowiedz;
                        if (wiadomosc.getPolecenie() == "wyswietl") {
                            System.out.println("\npoczta.ObslugaStrumieni: Wyswietlam odebrana wiadomosc");
                            wiadomosc.wyswietl();
                        }
                        else {
                            System.out.println("\npoczta.ObslugaStrumieni: Wysylam wiadomosc: polecenie: " + wiadomosc.getPolecenie()+ ", id: "+ wiadomosc.getId() + ", noweId: " + wiadomosc.getNoweId());
                            wyslij(wiadomosc);
                        }
                        if(wiadomosc.getPolecenie() == "zakoncz") break;
                    }
                    else if (odpowiedz instanceof Konto){
                        Konto konto = (Konto) odpowiedz;
                        System.out.println("\npoczta.ObslugaStrumieni: Wysylam konto z poleceniem: " + konto.getPolecenie());
                        wyslij(konto);
                    }
                    else if (odpowiedz instanceof ListaWiadomosci) {
                        System.out.println("\npoczta.ObslugaStrumieni: Wysylam obiekt typu poczta.ListaWiadomosci: ");
                        ListaWiadomosci listaWiadomosci = (ListaWiadomosci) odpowiedz;
                        wyslij(odpowiedz);
                    }
                }
            }

            System.out.println("Koncze sesje");

            input.close();
            output.close();
            gniazdo.close();
        } catch (EOFException e) {
            System.out.println("Koniec sesji: gniazdo zamkniete");
        } catch (SocketException e){
            System.out.println("Polaczenie zostalo zerwane");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Blad w ObslugaStrumienia run(): " + e.getMessage());
            e.printStackTrace();
        }

    }
    public void wyslij(Object obj){
        interpreter.szyfruj(obj);
        try {
            output = new ObjectOutputStream(gniazdo.getOutputStream());
            output.writeObject(obj);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

