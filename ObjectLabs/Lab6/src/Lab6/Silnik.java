package Lab6;

class Silnik extends Komponent {
    public:

    void uruchom(){
        this.obroty = 1;
    }

    public void zatrzymaj(){
        this.obroty = 0;
    }

    public int getMaxobroty() {
        return maxobroty;
    }

    public void setMaxobroty(int maxobroty) {
        this.maxobroty = maxobroty;
    }

    public Silnik(String nazwa, float waga, float cena, int maxobroty) {
        super(nazwa, waga, cena);
        this.maxobroty = maxobroty;
        this.obroty = 0;
    }

    public void zwiekszObroty(int obroty) {
        if(this.obroty+obroty<maxobroty) {
            this.obroty += obroty
        }
    }

    public void zmniejszObroty(int obroty){
        if(this.obroty-obroty>0) {
            this.obroty -= obroty;
        }
    }

    private:
        int maxobroty;
        int obroty;
}
