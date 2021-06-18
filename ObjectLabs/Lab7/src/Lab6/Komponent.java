package Lab6;

public class Komponent {

    public String getNazwa() {
        return this.nazwa;
    }

    public float getWaga() {
        return this.waga;
    }

    public float getCena() {
        return this.cena;
    }

    public Komponent(String nazwa, float waga, float cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }


    private String nazwa;
    float waga;
    float cena;

}
