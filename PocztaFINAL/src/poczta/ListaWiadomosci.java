package poczta;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaWiadomosci implements Serializable {
    private ArrayList<Wiadomosc> lista;
    public ListaWiadomosci(ArrayList <Wiadomosc> lista) { this.lista = lista; }
    public ArrayList<Wiadomosc> getLista() { return lista; }
}
