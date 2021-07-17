package makaANDsimonovsky.com;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {
 static private Network network;

 @BeforeAll
 public static void init() {
  network = new Network("192.168.128.0", 18);
 }

 @AfterAll
 public static void tearDown() {
  network = null;
 }

 @Test
 public void testConvertMaskToDecimal() {
  assertEquals("255.255.192.0", network.getNetworkMaskDecimal());
 }

 @Test
 public void testConvertMaskisCorrect() {
  assertNotEquals("192.0.0.1", network.getNetworkMaskDecimal());
 }


 @Nested
 @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class NumberofHostsCorrectness {
  ArrayList<Integer> list;

  @BeforeAll
  public void init() {
   list = new ArrayList<>();
   list.add(30);
   list.add(11);
   list.add(191);
  }

  @AfterAll
  public void tearDown() {
   list = null;
  }

  @org.junit.jupiter.api.Test
  void isNumberOfHostsCorrect() {
   {
    assertTrue(network.isNumberOfHostsCorrect(list));
   }

  }
 }
}