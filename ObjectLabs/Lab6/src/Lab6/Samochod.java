package Lab6;

public class Samochod {

    public:

    public void wlacz(){
        stanWlaczenia = true;
        silnik.uruchom();
    }

    void wylacz(){
        stanWlaczenia = false;
        silnik.zatrzymaj();
    }

    void jedzDo(Pozycja cel) {
    }

    public float getWaga();

    public float getAktPredkosc();

    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }

    public Samochod(String nrRejest, String model, float predkoscmax, Silnik silnik, Pozycja aktualnaPozycja, SkrzyniaBiegow skrzynia) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscmax = predkoscmax;
        this.silnik = silnik;
        this.aktualnaPozycja = aktualnaPozycja;
        this.skrzynia = skrzynia;

    }


    private:
    boolean stanWlaczenia;
    String nrRejest;
    String model;
    float predkoscmax;
    SkrzyniaBiegow skrzynia;
    Silnik silnik;
    Pozycja aktualnaPozycja;
}
