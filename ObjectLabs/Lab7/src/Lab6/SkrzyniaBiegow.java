package Lab6;

class SkrzyniaBiegow extends Komponent {






    public int getIloscBiegow() {
        return iloscBiegow;
    }

    public void setIloscBiegow(int iloscBiegow) {
        this.iloscBiegow = iloscBiegow;
    }


    public int getAktualnyBieg() {
        return this.aktualnyBieg;
    }


    public void setAktualnyBieg(int aktualnyBieg) {
        this.aktualnyBieg = aktualnyBieg;
    }

    public double getAktPrzelozenie() {

        this.aktualnePrzelozenie = 1 + 0.1*this.aktualnyBieg;

        return this.aktualnePrzelozenie;
    }

    public void setAktualnePrzelozenie() {
        this.aktualnePrzelozenie = aktualnePrzelozenie;
    }

    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }

    public void zwiekszBieg() {
        this.sprzeglo.wcisnij();
        if(this.aktualnyBieg<this.iloscBiegow) {
            this.aktualnyBieg += 1;
        }
        this.sprzeglo.zwolnij();
    }

    public void zmniejszBieg() {
        this.sprzeglo.wcisnij();
        if(this.aktualnyBieg>1)
            this.aktualnyBieg -=1;
        this.sprzeglo.zwolnij();
    }


    int aktualnyBieg;
    int iloscBiegow;
    double aktualnePrzelozenie;
    Sprzeglo sprzeglo;
}
