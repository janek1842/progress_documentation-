package poczta;

import java.io.Serializable;
public class Konto implements Serializable {

    private String nazwa;
    private String nazwisko = null; //opcjonalne
    private String haslo;
    private String kluczSzyfrowania;
    private String emailZapasowy = null; //opcjonalne
    private String email;
    private String polecenie = null;

    public Konto(String nazwa , String nazwisko, String bazaMaila, String domena, String haslo, String kluczSzyfrowania, boolean czyPowiadamiac, String emailZapasowy) {
        setNazwa(nazwa);
        setNazwisko(nazwisko);
        setHaslo(haslo);
        setKluczSzyfrowania(kluczSzyfrowania);
        setEmailZapasowy(emailZapasowy);
        this.email = this.getEmail();
    }

    public Konto(String nazwa, String nazwisko, String email, String haslo, String emailZapasowy) {
        this.nazwa = nazwa;
        if (nazwisko != null) this.nazwisko = nazwisko;
        this.haslo = haslo;
        this.email = email;
        if(emailZapasowy != null) this.emailZapasowy = emailZapasowy;
    }
    public Konto(String nazwa, String nazwisko, String email, String haslo, String emailZapasowy,String kluczSzyfrowania) {
        this.nazwa = nazwa;
        if (nazwisko != null) this.nazwisko = nazwisko;
        this.haslo = haslo;
        this.email = email;
        if(emailZapasowy != null) this.emailZapasowy = emailZapasowy;
        if(kluczSzyfrowania != null) this.kluczSzyfrowania = kluczSzyfrowania;
    }
    public Konto(Konto konto){
        this.nazwa = konto.nazwa;
        if (nazwisko != null) this.nazwisko = konto.nazwisko;
        this.haslo = konto.haslo;
        this.email = konto.email;
        if(emailZapasowy != null) this.emailZapasowy = konto.emailZapasowy;
        this.kluczSzyfrowania = konto.kluczSzyfrowania;
    }
    public Konto(){}

    public boolean zmienHaslo(String stare_haslo, String nowe_haslo){
        if(stare_haslo.equals(getHaslo())){
            setHaslo(nowe_haslo);
            return true;
        }
        else
            //System.out.println("Niepoprawne stare hasło");
            return false;
    }
    public boolean resetujHaslo(String email){
        if(email.equals(getEmailZapasowy())){
            //System.out.println("Sprawdź swój email zapasowy");
            return true;
        }
        else {
            //System.out.println("Podano zły email zapasowy");
            return false;
        }

    }
    // TODO: moze czesc klasy Admin
    public void wyswietlInformacje(){
        System.out.println("Imie/Nazwa: " + nazwa);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Email: " + email);
        System.out.println("Haslo: " + haslo);
    }

    // --------- gettery/settery ---------

    public String getEmail(){
        return email;
    }

    public String getEmailZapasowy() {
        return emailZapasowy;
    }

    public void setEmailZapasowy(String emailZapasowy) {
        this.emailZapasowy = emailZapasowy;
    }

    public String getKluczSzyfrowania() {
        return kluczSzyfrowania;
    }

    public void setKluczSzyfrowania(String kluczSzyfrowania) {
        this.kluczSzyfrowania = kluczSzyfrowania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getPolecenie() {
        return polecenie;
    }

    public void setPolecenie(String polecenie) {
        this.polecenie = polecenie;
    }

    public void setEmail(String email) { this.email = email; }
}