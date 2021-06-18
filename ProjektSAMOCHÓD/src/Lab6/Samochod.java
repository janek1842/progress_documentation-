package Lab6;

import static java.lang.StrictMath.abs;

public class Samochod extends Thread{
    private Pozycja aktualnaPozycja;
    private double V;
    Pozycja cel = null;
    Sprzeglo sprzeglo;
    SkrzyniaBiegow skrzynia;
    Silnik silnik;
    private String model;
    private double waga;
    private String nrRejest;
    private double predkoscmax;
    private boolean stanWlaczenia;

    public void wlacz(){
        stanWlaczenia = true;
        silnik.uruchom();
    }

    public void wylacz(){
        stanWlaczenia = false;
        V = 0;
        silnik.zatrzymaj();
    }

    public void jedzDo(Pozycja cel)  {
        try {
            start();
            this.cel = cel;
        }
        catch(IllegalThreadStateException f)
        {
        }
    }

    public double getWaga(){
        return waga;
    }


    public void setWaga() {
        this.waga = silnik.getWaga() + skrzynia.getWaga();
    }

    @Override
    public void run() {

            super.run();
            while (true) {
                double dt = 0.2;
                aktualnaPozycja.przemiesc(getAktPredkosc(), dt, cel);
                if(stanWlaczenia) {
                    System.out.println("Pozycja: " + nrRejest + ": " + aktualnaPozycja.getX() + " " + aktualnaPozycja.getY());

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException f) {
                        System.out.println();
                    } catch (IllegalThreadStateException f) {
                        System.out.println();
                    }
                    if (getAktualnaPozycja().getX() == cel.getX() && getAktualnaPozycja().getY() == cel.getY()) {
                        V = 0;
                        skrzynia.setAktualnyBieg(1);
                    }
                }

            }
        }


    public double getAktPredkosc(){
        return V;
    }

    public void zwAktPredkosc(){
        if(predkoscmax>getAktPredkosc()) {
            V += silnik.getobroty() * skrzynia.getObwod() * skrzynia.getAktPrzelozenie();
        }
    }

    public void zmAktPredkosc(){
        if(getAktPredkosc()>0) {
            V -= silnik.getobroty() * skrzynia.getObwod() * skrzynia.getAktPrzelozenie();
        }
    }


    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }

    public Samochod(String nrRejest, String model, double predkoscmax, Silnik silnik, SkrzyniaBiegow skrzynia,Sprzeglo sprzeglo) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscmax = predkoscmax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.aktualnaPozycja = new Pozycja(0,0);
        this.sprzeglo = sprzeglo;
        setStanWlaczenia(false);
    }

    @Override
    public String toString() {
        return
                " nrRejest='" + nrRejest + '\'' +
                ", model='" + model + '\'' ;
    }

    public static void main (String[] args) {
    }
//---------------------Gettery/Settery--------------------------------------------------
    public boolean isStanWlaczenia() {
        return stanWlaczenia;
    }

    public void setStanWlaczenia(boolean stanWlaczenia) {
        this.stanWlaczenia = stanWlaczenia;
    }

    public String getNrRejest() {
        return nrRejest;
    }

    public void setNrRejest(String nrRejest) {
        this.nrRejest = nrRejest;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPredkoscmax() {
        return predkoscmax;
    }

    public void setPredkoscmax(double predkoscmax) {
        this.predkoscmax = predkoscmax;
    }

    public void setAktualnaPozycja(Pozycja aktualnaPozycja) {
        this.aktualnaPozycja = aktualnaPozycja;
    }
}