package Lab6;
import java.lang.Math.*;

import static java.lang.Math.abs;

public class Samochod extends Thread{


    float xd,yd;

    public void wlacz(){
        stanWlaczenia = true;
        silnik.uruchom();
    }

    void wylacz(){
        stanWlaczenia = false;
        silnik.zatrzymaj();
    }

    void jedzDo(Pozycja cel)  {                     //nowy cel
        this.cel = cel;
    }

    void wyniki(){
        for(int j =0 ;j<2;j++) {
            System.out.println("Miejsce nr " +j+1 + miejsca[j]);
        }
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            double dt = 0.2;
            aktualnaPozycja.przemiesc(this.getAktPredkosc(), dt, cel);
            System.out.println("Pozycja: " + this.nrRejest + ": " + aktualnaPozycja.x + " " + aktualnaPozycja.y);
            if(abs(aktualnaPozycja.x - cel.x) < 0.01 && abs(aktualnaPozycja.y - cel.y) < 0.01 ) {
                System.out.println(this.nrRejest+" JEST U CELU");
                miejsca[f] = this.model;
                f++;
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }


    public double getAktPredkosc(){
        this.V += this.silnik.obroty*obwod;
        return V;
    }

    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }

    public Samochod(String nrRejest, String model, float predkoscmax, Silnik silnik, double obwod, SkrzyniaBiegow skrzynia) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscmax = predkoscmax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.aktualnaPozycja = new Pozycja(0,0);
        this.obwod = obwod;
        start();
        wyniki();

    }

    public static void main (String[] args) {
        Sprzeglo spr = new Sprzeglo("spr",70,60,true);
        SkrzyniaBiegow skr = new SkrzyniaBiegow("skrz1",50,50,5,spr);
        Silnik sil = new Silnik("S1",12,60,100);
        Samochod Sam = new Samochod("KR01","Audi",900,sil,0.1,skr);

        Sprzeglo spr2 = new Sprzeglo("spra",70,60,true);
        SkrzyniaBiegow skr2 = new SkrzyniaBiegow("skrz2",50,50,5,spr2);
        Silnik sil2 = new Silnik("S1",12,60,100);
        Samochod Sam2 = new Samochod("KR02","BMW",900,sil,10,skr2);

        Pozycja cel = new Pozycja(0.1,0.1);
        Sam.jedzDo(cel);
        Sam2.jedzDo(cel);

        Sam.wlacz();
        Sam.silnik.uruchom();
        Sam.skrzynia.zwiekszBieg();
        Sam.skrzynia.zwiekszBieg();

        Sam2.wlacz();
        Sam2.silnik.uruchom();
        Sam2.skrzynia.zwiekszBieg();
        Sam2.skrzynia.zwiekszBieg();


    }

    boolean stanWlaczenia;
    String nrRejest;
    String model;
    double waga;
    float predkoscmax;
    double obwod;
    SkrzyniaBiegow skrzynia;
    Silnik silnik;
    int f =0;
    Pozycja aktualnaPozycja;
    double V;
    Sprzeglo sprzeglo;
    String[] miejsca;
    private Pozycja cel = new Pozycja(100,100);
}
