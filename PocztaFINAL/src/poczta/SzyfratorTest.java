package poczta;

import static org.junit.Assert.*;

public class SzyfratorTest {

    Szyfrator szyfrator = new Szyfrator("daAMmnpq2;'3");
    @org.junit.Test
    public void szyfruj() {
        assertEquals("cfowlkgyxomlhmcghgfjklcra",szyfrator.szyfruj("abcdefghijklmnouprstuwxyz"));
        assertEquals("GUNCDIJADPWPBMQMFJKLCRA",szyfrator.szyfruj("ABCDEFGIJKMNOUPRSTUWXYZ"));
        assertEquals("ntoiąówtxla",szyfrator.szyfruj("aaaaaóąaaaa"));
        szyfrator.setKlucz("H]Gsj33K6");
        assertEquals("rwnadyquztwiztgzjtsgjuxzt",szyfrator.szyfruj("abcdefghijklmnouprstuwxyz"));
        assertEquals("KMXWNQVVXNLPAKEASGJUXZT",szyfrator.szyfruj("ABCDEFGIJKMNOUPRSTUWXYZ"));
        assertEquals("onoząópiint",szyfrator.szyfruj("aaaaaóąaaaa"));
        szyfrator.setKlucz("ReWoLwEr2021");
        assertEquals("pyfdckow hdisqtencwavehf ikk qóoq łjnfjzknenzdgz wjmwebqedpjrh bqpsvmrglefnzeJ",
                szyfrator.szyfruj("Wyrewolwerowany rewolwerowiec wyrewolwerował swój nie wyrewolwerowany rewolwer"));
    }

    @org.junit.Test
    public void odszyfruj() {
        assertEquals("abcdefghijklmnouprstuwxyz",szyfrator.odszyfruj("cfowlkgyxomlhmcghgfjklcra"));
        assertEquals("ABCDEFGIJKMNOUPRSTUWXYZ",szyfrator.odszyfruj("GUNCDIJADPWPBMQMFJKLCRA"));
        assertEquals("aaaaaóąaaaa",szyfrator.odszyfruj("ntoiąówtxla"));
        szyfrator.setKlucz("H]Gsj33K6");
        assertEquals("abcdefghijklmnouprstuwxyz",szyfrator.odszyfruj("rwnadyquztwiztgzjtsgjuxzt"));
        assertEquals("ABCDEFGIJKMNOUPRSTUWXYZ",szyfrator.odszyfruj("KMXWNQVVXNLPAKEASGJUXZT"));
        assertEquals("aaaaaóąaaaa",szyfrator.odszyfruj("onoząópiint"));
        szyfrator.setKlucz("ReWoLwEr2021");
        assertEquals("Wyrewolwerowany rewolwerowiec wyrewolwerował swój nie wyrewolwerowany rewolwer",
                szyfrator.odszyfruj("pyfdckow hdisqtencwavehf ikk qóoq łjnfjzknenzdgz wjmwebqedpjrh bqpsvmrglefnzeJ"));
    }
}