package Lab6;

public class Komponent {
    private double cena;
    private String nazwa;
    private double waga;

    public String getNazwa() {
        return this.nazwa;
    }

    public double getWaga() {
        return this.waga;
    }

    public double getCena() {
        return this.cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public void setWaga(double waga) {
        this.waga = waga;
    }
    public void setCena(double cena) {
        this.cena = cena;
    }
    public Komponent(String nazwa, double waga, double cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }
}
