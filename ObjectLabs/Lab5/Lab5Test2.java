import java.util.HashMap;

import static org.junit.Assert.*;

public class Lab5Test2 {
    Lab5 obj = new Lab5();
    @org.junit.Test
    public void wordLen() {
        HashMap<String,Integer> mapa = new HashMap<String,Integer>();
        mapa.put("aaa",3);
        mapa.put("bb",2);
        mapa.put("c",1);
        assertEquals(mapa, obj.wordLen(new String[]{"aaa","bb","c"}));

    }

    public void pairs() {

        HashMap<String,String> mapa = new HashMap<String,String>();
        mapa.put("m","n");
        assertEquals(mapa, obj.wordLen(new String[]{"main","man","moon"}));

    }
}