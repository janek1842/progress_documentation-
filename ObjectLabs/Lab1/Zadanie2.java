
abstract class Animal {
    int iloscNog;

    public void live() {
        System.out.println("I can live.");
    }

    public String getName() {
        return "animal";
    }
}

class Bird extends Animal {

    public String getName() {
        return "bird";
    }

    public void fly() {
        System.out.println("I can fly!");
    }
}

class Parrot extends Bird {
    public String getName() {
        return "parrot";
    }

    public void fly() {
        System.out.println("I can fly! I can fly!");
    }
}

class Snake extends Animal {
    public String getName() { return "snake";}
    public void sss() {System.out.println("sssssssss");}
}
class Cow extends Animal {
    public Strin getName() {return "cow";}
    public void milk() {System.out.println("U cant milk a cow");}
}

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

        Animal tablica[] = new Animal[100]; //tablica 100 zwierzat
        //dodaj klasy 2 nowych zwierzar
        //dodaj losowo różne zwierzęta do tablicy
        //wykorzystaj funkcję Random z pakietu java.util
        //wypisz w pętli nazwy wszystkich zwierząt

    }
}