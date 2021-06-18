package poczta;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaInt implements Serializable {
    private ArrayList<Integer> lista;
    private String polecenie;
    public ListaInt(ArrayList <Integer> lista,String polecenie) {
        this.lista = lista;
        this.polecenie = polecenie;
    }
    public ArrayList<Integer> getLista() { return lista; }

    public String getPolecenie() { return polecenie; }
}