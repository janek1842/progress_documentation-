package poczta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wydarzenie {
    private String wartosc1 = null;
    private String wartosc2 = null;

    public void przerwijGdy(String warunekKonca){
        while(true){
            if(warunekKonca.equals(wartosc1)) break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wartosc1 = null;
    }
    public void przerwijGdyWpisano(String napis){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String p = null;
            try {
                p = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (p.equals(napis)) break;
        }
    }


    // ------ gettery/settery -------

    public String getWartosc1() {
        return wartosc1;
    }

    public void setWartosc1(String wartosc1) {
        this.wartosc1 = wartosc1;
    }

    public String getWartosc2() {
        return wartosc2;
    }

    public void setWartosc2(String wartosc2) {
        this.wartosc2 = wartosc2;
    }
}
