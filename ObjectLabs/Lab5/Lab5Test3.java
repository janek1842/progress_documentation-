import java.util.HashMap;

import static org.junit.Assert.*;

public class Lab5Test3 {
    Lab5 obj = new Lab5();
    @org.junit.Test
    public void pairs() {

        HashMap<String,String> mapa = new HashMap<String,String>();
        mapa.put("m","n");
        assertEquals(mapa, obj.pairs(new String[]{"main","man","moon"}));
        mapa.clear();
        mapa.put("b","g");
        mapa.put("c","e");
        assertEquals(mapa, obj.pairs(new String[]{"code","bug"}));
    }

}