package poczta;

import java.util.ArrayList;
public class Interpreter {
    private final BazaDanych bazaDanych;
    private Wydarzenie wydarzenie;
    private Konto aktualneKonto; // konto na jakie jest zalogowany klient na tym gniezdzie
    private String domyslnyKlucz = "qwe1234qeq";
    private Szyfrator szyfrator = new Szyfrator(domyslnyKlucz);

    public Interpreter(BazaDanych bazaDanych, Wydarzenie wydarzenie) {
        this.bazaDanych = bazaDanych;
        this.wydarzenie = wydarzenie;
    }

    public Object wykonaj(Object obj) {
        odszyfruj(obj);
        switch (obj.getClass().getName()){
            case "poczta.Wiadomosc": {
                ((Wiadomosc) obj).wyswietl();
                return wykonaj((Wiadomosc) obj);
            }
            case "poczta.Konto": {
                ((Konto) obj).wyswietlInformacje();
                return wykonaj((Konto) obj);
            }
            case "poczta.ListaInt":{
                System.out.println("Interprter: " + ((ListaInt) obj).getLista());
                return wykonaj((ListaInt) obj);
            }
            case "poczta.ListaWiadomosci": {
                System.out.println("Interpreter: Odebrano ListaWiadomosci o ilosci wiadomosci: " + ((ListaWiadomosci) obj).getLista().size());
                return wykonaj((ListaWiadomosci) obj);
            }
            default: return new Wiadomosc("nieznanyTyp",null);
        }
    }
    public Object wykonaj(Wiadomosc wiadomosc){
        switch (wiadomosc.getPolecenie()) {
            case "zakoncz":
                return new Wiadomosc("zakoncz", null);
            case "dodajKontoTrue":
                wydarzenie.setWartosc1("dodawanieKonta_response");
                wydarzenie.setWartosc2("dodajKontoTrue");
                return new Wiadomosc("wyswietl", "poczta.Konto zostalo pomyslnie utworzone : " + wiadomosc.getOdbiorca());
            case "dodajKontoFalse":
                wydarzenie.setWartosc1("dodawanieKonta_response");
                wydarzenie.setWartosc2("dodajKontoFalse");
                return new Wiadomosc("wyswietl", "poczta.Konto nie zostalo utworzone: " + wiadomosc.getOdbiorca());
            case "wyswietl":
                return wiadomosc;
            case "mail": {
                int noweid = bazaDanych.dodajWiadomosc(wiadomosc);
                if (noweid == 0){
                    return new Wiadomosc("nieznanyEmail", "Nieznany email w wiadomosci (id: " + wiadomosc.getId() + ")");
                }
                else {
                    wiadomosc.setNoweId(noweid);
                    wiadomosc.setPolecenie("mailWyslany");

                    return wiadomosc;
                }


            }
            case "mailWyslany": {
                bazaDanych.dodajWiadomoscKlient(wiadomosc);
                if (wiadomosc.getId() != wiadomosc.getNoweId()){
                    return new Wiadomosc("wyswietl","poczta.Wiadomosc o id = " + wiadomosc.getId()+ " zostala wyslana. Dostepne sa nowe wiadomosci: noweId = "+wiadomosc.getNoweId());
                }
                return new Wiadomosc("wyswietl","poczta.Wiadomosc o id = " + wiadomosc.getId()+ " zostala wyslana (noweId = "+ wiadomosc.getNoweId()+")");
            }
            case "nieznanyEmail":
                return new Wiadomosc("wyswietl", "Nieznany email w wiadomosci (id: " + wiadomosc.getId() + ")");
            case "nieznanePolecenie":
                System.out.println("Interpreter: nieznane polecenie");
                return null;
            case "autoryzuj":{
                String email = wiadomosc.getNadawca();
                String haslo = wiadomosc.getOdbiorca();

                if (bazaDanych.containsKey(email)){
                    if (bazaDanych.get(email).getHaslo().equals(haslo)) {
                        //logowanie poprawne
                        System.out.println("Interpreter: autoryzuj True dla konta: " + email);
                        Konto konto = bazaDanych.get(email).getKonto();
                        konto.setPolecenie("logowanieTrue");
                        aktualneKonto = new Konto (konto); ////zeby nie zaszyfrowac aktualneKonto

                        System.out.println("Zalogowano na konto:" + aktualneKonto.getEmail());
                        szyfrator.setKlucz(konto.getKluczSzyfrowania());
                        return konto;
                    }

                    return new Wiadomosc("logowanieFalse",email,haslo);
                }
                else{
                    //blad logowania
                    return new Wiadomosc("logowanieFalse",email,haslo);
                }
            }
            case "logowanieFalse":{
                System.out.println("Interpreter: Nie udalo sie zalogowac na konto: " + wiadomosc.getNadawca()+ " za pomoca hasla: " + wiadomosc.getOdbiorca());
                wydarzenie.setWartosc1("logowanieResponse");
                return null;
            }
            case "maxId":{
                int maxId = wiadomosc.getId();
                System.out.println("Odebrano wiadomosc maxId o id: " + maxId);
                ArrayList <Wiadomosc> listaWiad = bazaDanych.get(aktualneKonto.getEmail()).synchronizuj(maxId);
                return new ListaWiadomosci(listaWiad);
            }
            case "nieznanyTyp": return new Wiadomosc("wyswietl","serwer dostal wiadomosc o nieznanym typie");
            default:
                return new Wiadomosc("nieznanePolecenie", null);
        }

    }
    public Object wykonaj(Konto konto){
        switch (konto.getPolecenie()){
            case "zalozKonto":{
                if (bazaDanych.containsKey(konto.getEmail())) {
                    return new Wiadomosc("dodajKontoFalse", konto.getEmail());
                } else {
                    bazaDanych.stworzKonto(konto,true);
                    return new Wiadomosc("dodajKontoTrue", konto.getEmail());
                }
            }
            case "logowanieTrue":{
                System.out.println("Interpreter: zalogowano poprawnie na konto: " + konto.getEmail() );

                if (bazaDanych.containsKey((konto.getEmail())) && bazaDanych.get(konto.getEmail()) == null)
                    bazaDanych.remove(konto.getEmail()); // powod: patrz nizej wykonaj (poczta.ListaWiadomosci)

                if (bazaDanych.containsKey(konto.getEmail())) {
                    // aktualizuje dane konta
                    System.out.println("Interpreter: aktualizuje konto");
                    bazaDanych.get(konto.getEmail()).zapiszKonto(konto);
                    bazaDanych.setAktualneKonto(konto); // logowanie na konto
                } else {
                    System.out.println("Interpreter: Dodaje konto do bazaDanych");
                    bazaDanych.stworzKonto(konto,false);
                    bazaDanych.setAktualneKonto(konto); // logowanie na konto

                }
                wydarzenie.setWartosc1("logowanieResponse");
                szyfrator.setKlucz(konto.getKluczSzyfrowania());
                return null;
            }
            case "zmienInfo":{
                if (konto == null) return null;
                bazaDanych.get(aktualneKonto.getEmail()).zapiszKonto(konto);
                return null;
            }
            default: return new Wiadomosc("nieznanePolecenie", null);
        }

    }
    public Object wykonaj(ListaInt lista){
        switch (lista.getPolecenie()) {
            case "synchronizuj": {
                if (lista.getLista().isEmpty()) return null;

                System.out.println("Interpreter: odebrano prosbe o synchronizacje");
                ArrayList<Wiadomosc> listaWiad = new ArrayList<>();
                Wiadomosc wiadomosc;
                for (Integer id : lista.getLista()) {
                    wiadomosc = bazaDanych.get(aktualneKonto.getEmail()).czytajwiadomosc(id);
                    if (wiadomosc != null) {
                        wiadomosc.setNoweId(wiadomosc.getId()); //wtedy zapisze wiadomosc na kliencie z wartoscia noweId
                        listaWiad.add(wiadomosc);
                    } else if (bazaDanych.get(aktualneKonto.getEmail()).getListaId().containsKey(-id)) {
                        //wiadomosc została usunięta
                        listaWiad.add(new Wiadomosc("wiadomoscUsunieta", id));
                    }
                }
                return new ListaWiadomosci(listaWiad);
            }
            case "usunWiadomosci":{
                System.out.println("Interpreter: odebrano prosbe o usuniecie wiadomosci:" + lista.getLista());
                if (lista.getLista().isEmpty()) return null;

                for (int id: lista.getLista()){
                    if (id > 0)
                        bazaDanych.get(aktualneKonto.getEmail()).usunWiadomosc(id,false);
                    else if (id < 0)
                        bazaDanych.get(aktualneKonto.getEmail()).usunWiadomosc(-id,true);
                }
                return null;
            }
        }
        return null;
    }
    public Object wykonaj(ListaWiadomosci lista){
        if (lista.getLista().isEmpty()) return null;

        System.out.println("Interpreter: Odebrano nowe wiadomosci z synchronizacji");
        for(Wiadomosc wiadomosc: lista.getLista()){
            if (wiadomosc.getPolecenie().equals("wiadomoscUsunieta"))
                bazaDanych.getAktFolderKonta().getListaId().put(wiadomosc.getId(),"Usunieta");
            else
                if (!bazaDanych.containsKey(wiadomosc.getOdbiorca()))
                    bazaDanych.put(wiadomosc.getOdbiorca(),null); //otrzymalismy wiadomosc, a w bazie danych nie ma tego emaila...
                bazaDanych.dodajWiadomoscKlient(wiadomosc);
        }
        return null;
    }
    public void szyfruj(Object obj){
        String staryKlucz = szyfrator.getKlucz();
        if (obj instanceof Wiadomosc){
            String polecenie = ((Wiadomosc) obj).getPolecenie();
            if(polecenie.equals("autoryzuj") || polecenie.equals("logowanieFalse")) {
                szyfrator.setKlucz(domyslnyKlucz);
            }
        }
        else if (obj instanceof Konto){
            String polecenie = ((Konto) obj).getPolecenie();
            if(polecenie.equals("logowanieTrue") || polecenie.equals("zalogowano")) {
                szyfrator.setKlucz(domyslnyKlucz);
            }
        }

        switch (obj.getClass().getName()){
            case "poczta.Wiadomosc": szyfrator.szyfruj((Wiadomosc) obj);
                break;
            case "poczta.Konto": szyfrator.szyfruj((Konto) obj);
                break;
            case "poczta.ListaWiadomosci": szyfrator.szyfruj((ListaWiadomosci) obj);
                break;
        }
        szyfrator.setKlucz(staryKlucz);
    }
    public void odszyfruj(Object obj){
        String staryKlucz = szyfrator.getKlucz();
        if (obj instanceof Wiadomosc){
            String polecenie = ((Wiadomosc) obj).getPolecenie();

            szyfrator.setKlucz(domyslnyKlucz);
            szyfrator.odszyfruj(polecenie);
            szyfrator.setKlucz(staryKlucz);

            if(polecenie.equals("autoryzuj") || polecenie.equals("logowanieFalse")) {
                szyfrator.setKlucz(domyslnyKlucz);
            }
        }
        else if (obj instanceof Konto){
            String polecenie = ((Konto) obj).getPolecenie();

            szyfrator.setKlucz(domyslnyKlucz);
            szyfrator.odszyfruj(polecenie);
            szyfrator.setKlucz(staryKlucz);

            if(polecenie.equals("logowanieTrue") || polecenie.equals("zalogowano")) {
                szyfrator.setKlucz(domyslnyKlucz);
            }
        }

        switch (obj.getClass().getName()){
            case "poczta.Wiadomosc": szyfrator.odszyfruj((Wiadomosc) obj);
                break;
            case "poczta.Konto": szyfrator.odszyfruj((Konto) obj);
                break;
            case "poczta.ListaWiadomosci": szyfrator.odszyfruj((ListaWiadomosci) obj);
                break;
        }
        szyfrator.setKlucz(staryKlucz);
    }
}
