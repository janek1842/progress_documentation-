package makaANDsimonovsky.com;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class IP_CalculatorTest {
    @Test
    public void testAddress(){assertTrue(IP_Calculator.isAddressCorrect("192.168.1.0"));}

    @Test
    public void testthatAddress(){assertFalse(IP_Calculator.isAddressCorrect("192.168..0"));}




}
