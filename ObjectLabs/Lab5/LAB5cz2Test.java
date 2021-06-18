import java.util.HashMap;

import static org.junit.Assert.*;

public class LAB5cz2Test {
    LAB5cz2 obj = new LAB5cz2();
    @org.junit.Test
   /* public void wordCount() {
        HashMap<String,Integer> mapa = new HashMap<String,Integer>();
        mapa.put("a",1);
        mapa.put("b",1);
        mapa.put("c",1);
        assertEquals(mapa, obj.wordCount(new String[]{"a","b","c"}));
        mapa.clear();
        mapa.put("a",1);
        mapa.put("a",2);
        mapa.put("c",1);
        assertEquals(mapa, obj.wordCount(new String[]{"a","a","c"}));
    }

    */
    /*
    public void firstChar() {
        HashMap<String,String> mapa = new HashMap<String,String>();
        mapa.put("s","saltsoda");
        mapa.put("t","teatoast");
        assertEquals(mapa, obj.firstChar(new String[]{"salt","tea","soda","toast",}));
    }
    */
    /*
    public void wordAppend() {
        assertEquals( "aa", obj.wordAppend(new String[]{"a","a","a","a"}));
        assertEquals( "", obj.wordAppend(new String[]{"a","b","c","h"}));
    }
     */
    /*
    public void wordMultiple() {
        HashMap<String,Boolean> mapa = new HashMap<String,Boolean>();
        mapa.put("a",true);
        mapa.put("b",true);
        mapa.put("c",false);
        assertEquals(mapa, obj.wordMultiple(new String[]{"a","b","a","c","b"}));
    }
    */
    /*
    public void allSwap() {
        String[] stra = new String[2];
        stra[0] = "ac";
        stra[1] = "ab";
        assertEquals(stra, obj.allSwap(new String[]{"ab","ac"}));
    }

    */
    public void firstSwap() {
        String[] stra = new String[2];
        stra[0] = "ac";
        stra[1] = "ab";
        assertEquals(stra, obj.firstSwap(new String[]{"ab","ac"}));
    }







}