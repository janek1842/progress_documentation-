import static org.junit.Assert.*;

public class Lab4Test {
    Lab4 obj = new Lab4();
    @org.junit.Test
    public void bigDiff() {
        assertEquals( 7, obj.bigDiff(new int[]{10,3,5,6}));
        assertEquals( 8, obj.bigDiff(new int[]{7,2,9,10}));
        assertEquals( 8, obj.bigDiff(new int[]{10,2,7,2}));
        assertEquals( 8, obj.bigDiff(new int[]{2,10}));
        assertEquals( 8, obj.bigDiff(new int[]{10,2}));
        assertEquals( 10, obj.bigDiff(new int[]{0,10}));
        assertEquals( 1, obj.bigDiff(new int[]{2,3}));
        assertEquals( 0, obj.bigDiff(new int[]{2,2}));
        assertEquals( 0, obj.bigDiff(new int[]{2,2}));
        assertEquals( 0, obj.bigDiff(new int[]{2,}));
        assertEquals( 8, obj.bigDiff(new int[]{5,1,6,1,9,9}));

    }


}