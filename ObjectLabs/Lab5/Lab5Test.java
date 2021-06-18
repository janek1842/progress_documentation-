import java.util.HashMap;

import static org.junit.Assert.*;

public class Lab5Test {
    Lab5 obj = new Lab5();
    @org.junit.Test
    public void word0() {
         HashMap<String,Integer> mapa = new HashMap<String,Integer>();
         mapa.put("a",1);
         mapa.put("h",1);
         mapa.put("g",1);
         assertEquals(mapa, obj.wordLen(new String[]{"a","h","g"}));

    }
}