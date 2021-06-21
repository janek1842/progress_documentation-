package kursik;

public class Test {

    public double getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(double pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    private double pojemnosc;

    private double stanwody;

    Test(double ileLitrow, double pojemnosc) {

        this.stanwody = ileLitrow;
        this.pojemnosc = pojemnosc;
    }


    private void wlejdo(double ile, Test dokąd) {

        double ilewyleje = this.ileMogeWylac(ile);

        double ilewleje = dokąd.ileMogeWlac(ile, dokąd);

        double decyzja;

        if(ilewleje>ilewyleje){
            decyzja=ilewyleje;
        }
        else {
            decyzja=ilewleje;
        }

        System.out.println(" "+ decyzja);

        dokąd.stanwody += decyzja;
        this.stanwody -= decyzja;

    }


    private double ileMogeWylac(double ileChcialbym) {
        if (this.stanwody - ileChcialbym > 0) {
            return ileChcialbym;
        } else {
            return this.stanwody;
        }
    }

    private double ileMogeWlac(double ileChcialbym, Test test) {
        if (test.stanwody + ileChcialbym > test.pojemnosc) {
            return test.pojemnosc - test.stanwody;
        } else {
            return ileChcialbym;
        }
    }




    public static void main(String[] args) {
        Test[] tablicaButelek = new Test[3];

        tablicaButelek[0] = new Test(5, 5);
        tablicaButelek[1] = new Test(8, 10);
        tablicaButelek[2] = new Test(5, 8);

        tablicaButelek[1].wlejdo(7,tablicaButelek[2]);

        System.out.println(tablicaButelek[0].stanwody);
        System.out.println(tablicaButelek[2].stanwody);





    }
}



