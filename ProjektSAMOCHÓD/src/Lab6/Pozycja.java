package Lab6;
import java.lang.Math.*;
import static java.lang.StrictMath.*;

public class Pozycja {

    public double getX() {
        return x;
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
        if(x == cel.x && y == cel.y )
        {
            return;
        }

        dt = dt/1000 ;
        double odleglosc = sqrt(pow((cel.x-x),2)+pow((cel.y-y),2));

        double dx = V * dt *(cel.x-this.x)/odleglosc;
        double dy = V * dt * (cel.y-this.y)/odleglosc;

        this.x += dx;
        this.y += dy;

        if(abs(x - cel.x) < 10 && abs(y - cel.y) < 10 )  {
            x = cel.x;
            y = cel.y;
        }
    }

    public Pozycja(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    /*
    public Pozycja()
    {
        x=0;
        y=0;
    }

     */

    private double x;
    private double y;
}
