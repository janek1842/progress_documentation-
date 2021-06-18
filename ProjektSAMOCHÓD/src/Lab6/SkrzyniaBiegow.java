package Lab6;

import java.util.HashMap;
import java.util.Map;

class SkrzyniaBiegow extends Komponent {

    private double aktualnyBieg;
    private double iloscBiegow;
    private double obwod;
    private Sprzeglo sprzeglo;
    private Map<Double,Double> mapa = new HashMap<Double,Double>();

    //---------------------Gettery/Settery--------------------------------------------------

    public double getIloscBiegow() {
        return iloscBiegow;
    }

    public void setIloscBiegow(double iloscBiegow) {
        this.iloscBiegow = iloscBiegow;
    }

    public double getAktualnyBieg() {
        return aktualnyBieg;
    }

    public void setAktualnyBieg(double aktualnyBieg) {
        this.aktualnyBieg = aktualnyBieg;
    }

    public double getAktPrzelozenie(){
            return mapa.get(getAktualnyBieg());
    }

    public double getObwod(){
        return obwod;
    }
    public void setObwod(double obwod){
        this.obwod = obwod;
    }
    //-------------------------------------------------------------------------------------

    public void setAktualnePrzelozenie() {
        mapa.put(0.0,0.0);
        mapa.put(1.0,1.1);
        mapa.put(2.0,1.3);
        mapa.put(3.0,1.5);
        mapa.put(4.0,1.7);
        mapa.put(5.0,1.9);
        mapa.put(6.0,2.1);
    }
    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo,double obwod) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
        this.obwod = obwod;
        setAktualnePrzelozenie();
    }
    public void zwiekszBieg() {
        if(aktualnyBieg<iloscBiegow && sprzeglo.getStanSprzegla()) {
            aktualnyBieg += 1;
        }
    }
    public void zmniejszBieg() {
        if(this.aktualnyBieg>1 && sprzeglo.getStanSprzegla() ){
            this.aktualnyBieg -= 1;
        }
    }
}
