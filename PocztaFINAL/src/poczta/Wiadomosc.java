package poczta;

import java.io.Serializable;
public class Wiadomosc implements Serializable{
    private String polecenie = null;
    private String odbiorca = null;
    private String nadawca = null;
    private String temat = null;
    private String tekst = null;
    private int id = 0;
    private int noweId = 0; // do wysyłania wiadomosci z dwoma id


    public Wiadomosc(String polecenie, String odbiorca, String nadawca, String temat, String tekst) {
        this.polecenie = polecenie;
        this.odbiorca = odbiorca;
        this.nadawca = nadawca;
        this.temat = temat;
        this.tekst = tekst;
    }

    // odpowiedz (kod odpowiedzi, informacje)
    public Wiadomosc(String polecenie, String informacje) {
        this.polecenie = polecenie;
        this.odbiorca = informacje;
    }
    // odpowiedz (kod odpowiedzi, informacje,extraInfo)
    public Wiadomosc(String polecenie, String informacje,int id) {
        this.polecenie = polecenie;
        this.odbiorca = informacje;
        this.id = id;
    }
    // wysyłanie potwierdzeń mailów
    public Wiadomosc (String polecenie, int stareId, int noweId){
        this.polecenie = polecenie;
        this.id = stareId;
        this.noweId = noweId;
    }
    // autoryzacja logowania
    public Wiadomosc(String polecenie, String email, String haslo){
        this.polecenie = polecenie;
        this.nadawca = email;
        this.odbiorca = haslo;
    }
    // tworzy kopie wiadomosci np. w poczta.FolderKonta funkcja dodajWiadomosc
    public Wiadomosc(Wiadomosc wiadomosc1){
        polecenie = wiadomosc1.polecenie;
        odbiorca = wiadomosc1.odbiorca;
        nadawca = wiadomosc1.nadawca;
        temat = wiadomosc1.temat;
        tekst = wiadomosc1.tekst;
        id = wiadomosc1.id;
        noweId = wiadomosc1.noweId;
    }
    //poczta.Interpreter: wysyłanie wiadomoscUsunieta
    public Wiadomosc(String polecenie, int id){
        this.polecenie = polecenie;
        this.id = id;
    };
    public Wiadomosc(){};

    public void wyswietl() {
        System.out.println("-------------------------");
        System.out.println("Polecenie: " + polecenie);
        System.out.println("Odbiorca: " + odbiorca);
        System.out.println("Nadawca: " + nadawca);
        System.out.println("Temat: " + temat);
        System.out.println("Tekst: " + tekst);
        System.out.println("Id: " + id);
        System.out.println("NoweId: " + noweId);
        System.out.println("-------------------------\n");
    }

    @Override
    public String toString() {
        String tematShort = temat;
        if (temat.length() > 12){
            tematShort = temat.substring(0,12) + "...";
        }
        return "Nadawca: "+ nadawca + ", Odbiorca: "+ odbiorca + ", Temat: " + tematShort + ", id: " + id;
    }

    // -------- gettery/settery --------

    public String getPolecenie() {
        return polecenie;
    }

    public String getOdbiorca() {
        return odbiorca;
    }

    public String getNadawca() {
        return nadawca;
    }

    public String getTemat() {
        return temat;
    }

    public String getTekst() {
        return tekst;
    }

    public void setPolecenie(String polecenie) {
        this.polecenie = polecenie;
    }

    public void setOdbiorca(String odbiorca) {
        this.odbiorca = odbiorca;
    }

    public void setNadawca(String nadawca) {
        this.nadawca = nadawca;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getId() {  return id; }
    public void setId(int id) { this.id = id; }
    public int getNoweId() {  return noweId; }
    public void setNoweId(int id1) { this.noweId = id1; }
}