import package1.*;

import java.util.Random;
import java.util.ArrayList;

public class Zadanie2 {
    public static void main(String[] args) {

        Animal a;
        Bird b = new Bird();
        Parrot p = new Parrot();

        a = b;
        System.out.println(a.getName());

        a = p;
        System.out.println(a.getName());

        b = p;
        b.fly();

        p.live(); //dziedziczone!

        Animal tablica[] = new Animal[100];

        Random rand = new Random();

        int kl=1;

        for(int i=0;i<100;i++)
        {
            kl = rand.nextInt(5);

            switch(kl)
            {
                case 0:
                    tablica[i] = new Cow();
                    break;
                case 4:
                    tablica[i]= new Parrot();
                    break;
                case 1:
                    tablica[i]= new Snake();
                    break;
                case 2:
                    tablica[i]= new szpak();
                    break;
                case 3:
                    tablica[i] = new kos();
                    break;
            }
        }

        for(int i=0;i<100;i++)
        {
            System.out.println(tablica[i].getName());
        }

        //tablica 100 zwierzat
        //dodaj klasy 2 nowych zwierzar
        //dodaj losowo rĂłĹĽne zwierzÄ™ta do tablicy
        //wykorzystaj funkcjÄ™ Random z pakietu java.util
        //wypisz w pÄ™tli nazwy wszystkich zwierzÄ…t
    }
}