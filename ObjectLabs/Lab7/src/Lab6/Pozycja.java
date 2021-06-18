package Lab6;
import java.lang.Math.*;

import static java.lang.StrictMath.sqrt;
import static java.lang.StrictMath.pow;

public class Pozycja {

   public double x;
   public double y;

    public double getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void przemiesc(double V,double dt,Pozycja cel)
    {
        dt = dt/1000 ;
        double odleglosc = sqrt(pow((cel.x-x),2)+pow((cel.y-y),2));

        double dx = V * dt *(cel.x-this.x)/odleglosc;
        double dy = V * dt * (cel.y-this.y)/odleglosc;

        this.x += dx;
        this.y += dy;
    }

    public Pozycja(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}
