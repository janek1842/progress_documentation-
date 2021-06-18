package Lab6;

class Silnik extends Komponent {

    private double maxobroty;
    private double obroty;

    void uruchom(){
        this.obroty = 1;
    }

    public void zatrzymaj(){
        this.obroty = 0;

    }

    public double getMaxobroty() {
        return maxobroty;
    }

    public void setMaxobroty(double maxobroty) {
        this.maxobroty = maxobroty;
    }

    public double getobroty(){
        return obroty;
    }

    public Silnik(String nazwa, double waga, double cena, double maxobroty) {
        super(nazwa, waga, cena);
        this.maxobroty = maxobroty;
        this.obroty = 0;
    }

    public void zwiekszObroty(double obroty) {
        if(this.obroty+obroty<maxobroty) {
            this.obroty += obroty;
        }
    }
    
    public void zmniejszObroty(double obroty){
        if(this.obroty-obroty>0) {
            this.obroty -= obroty;
        }
    }
}
