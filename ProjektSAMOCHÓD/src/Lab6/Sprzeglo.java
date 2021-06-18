package Lab6;

class Sprzeglo extends Komponent {

    private boolean stanSprzegla;
    
    void wcisnij() {
        if(!stanSprzegla)
            stanSprzegla = true;
    }

    void zwolnij() {
        if(stanSprzegla)
            stanSprzegla = false;
    }

    public Sprzeglo(String nazwa, float waga, float cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public String isStanSprzegla() {
        if(stanSprzegla)
            return "Włączone";
        else
            return "Wyłączone";
    }

    public void setStanSprzegla(boolean stanSprzegla) {
        this.stanSprzegla = stanSprzegla;
    }

    public boolean getStanSprzegla(){
        return stanSprzegla;
    }

}
