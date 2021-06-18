package Lab6;

class SkrzyniaBiegow extends Komponent {
    public:

    void zwiekszBieg()

    void zmniejszBieg();

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

    public int getAktPrzelozenie() {
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

    public void zwiększBieg() {
        this.sprzeglo.wcisnij();
        if(this.aktualnyBieg<this.iloscBiegow) {
            this.aktualnyBieg += 1;
        }
    }

    public void zmniejszBieg(int wart) {
        this.sprzeglo.wcisnij();
        if(this.aktualnyBieg>1)
            this.aktualnyBieg -=1;
    }

    private:
    int aktualnyBieg;
    int iloscBiegow;
    float aktualnePrzelozenie;
    Sprzeglo sprzeglo;
}
