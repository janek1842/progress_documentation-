package Lab6;
import Lab6.Komponent;
import Lab6.Samochod;

import java.util.ArrayList;

public class Zawody{

    void rozegrajZawody();
    public String nazwa;
    public String data;
    private Samochod uczestnicy;

    public void Zawody(String nazwa, String data, Samochod uczestnik){
        this.nazwa = nazwa;
        this.data = data;
    }

}

