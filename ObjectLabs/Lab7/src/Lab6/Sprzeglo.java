package Lab6;

class Sprzeglo extends Komponent {

    void wcisnij() {
        if(!this.stanSprzegla)
            this.stanSprzegla = true;
    }

    void zwolnij() {
        if(this.stanSprzegla)
            this.stanSprzegla = false;
    }

    public Sprzeglo(String nazwa, float waga, float cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }


    boolean stanSprzegla;
}
