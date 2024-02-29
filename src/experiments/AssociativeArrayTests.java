package experiments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import structures.AssociativeArray;
import structures.KeyNotFoundException;
import structures.NullKeyException;

/**
 * Tests of the AssociativeArray class.
 *
 * @author CSC-207 2024Sp
 */
public class AssociativeArrayTests {

  // +-------------------------------+-------------------------------
  // | Tests by Zakariye M. Abdilahi |
  // +-------------------------------+

  // +------------------------------+--------------------------------
  // | Tests by Medhashree Adhikari |
  // +------------------------------+

  // +------------------------+--------------------------------------
  // | Tests by Rommin N. Adl |
  // +------------------------+

  // +-------------------------+-------------------------------------
  // | Tests by Marina Ananias |
  // +-------------------------+
  /**
   * Successfully checks how many key/value pairs are in a associative array with >= 1 values
   */
  @Test
  public void marinaAnaniasTest1() {
    // Creates new associative array where both k and v are integers
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();

    // Adds pairs of keys and values to arr
    try {
      for (int i = 0; i <= 5; i++) {
        arr.set(i, i);
      } // for 
    } catch (Exception e) {
      fail("Could not add values to array.");
    }

    // Gets array size
    try {
      assertEquals(6, arr.size());
    } catch (Exception e) {
      fail("Size of array is not what expected.");
    }
  } // marinaAnaniasTest1()

  /**
   * Successfully checks how many key/value pairs are in an empty array
   */
  @Test
  public void marinaAnaniasTest2() {
    // Creates new associative array where both k and v are integers
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();

    // Gets array size
    try {
      assertEquals(0, arr.size());
    } catch (Exception e) {
      fail("Size of array is not what expected.");
    }
  } // marinaAnaniasTest2()

  /**
   * Successfully checks if certain key is in the associative array
   */
  @Test
  public void marinaAnaniasTest3() {
    // Creates new associative array where both k and v are integers
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();

    // Adds pairs of keys and values to arr
    try {
      for (int i = 0; i <= 5; i++) {
        arr.set(i, i);
      } // for 
    } catch (Exception e) {
      fail("Could not add values to array.");
    }

    // Finds key in array
    try {
      assertEquals(true, arr.hasKey(1));
    } catch (Exception e) {
      fail("Key expected to be in associative array was not found");
    }

  } // marinaAnaniasTest3()
  
  // +-----------------------------+---------------------------------
  // | Tests by Pranav K. Bhandari |
  // +-----------------------------+

  /** 
   * Test to see that setting a new value to an already existing key replaces the old value.
   */
  @Test
  public void PranavBTest1() throws NullKeyException{
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    int i = 0;
    for (i = 0; i < 10; i++) { // setting keys and their values as the squares of keys
      arr.set(i, i*i);
    }
    arr.set(9, 9*2);
    try {
      assertEquals(18, arr.get(9)); // check to see that the value is i*2 not i^2;
    }
    catch (KeyNotFoundException e) {
      fail("Key 9 does not exist");
    }
  }

  /** 
   * Test to see that hasKey returns false for a non-existent key.
   */
  @Test
  public void PranavBTest2() throws NullKeyException{
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    int i = 0;
    for (i = 0; i < 10; i++) { // setting keys and their values as the squares of keys
      arr.set(i, i*i);
    }
    assertEquals(false, arr.hasKey(i + 1)); // check to see that false is returned for a key with 
                                            // value i + 1
  }

  /** 
   * Test to see that size() works correctly, including that removing all 
   * the added values results in an associative array of size zero.
   */
  @Test
  public void PranavBEdge1() throws NullKeyException{
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    int i = 0;
    assertEquals(0, arr.size()); // size() check1
    for (i = 0; i < 10; i++) { // setting keys and their values as the squares of keys
      arr.set(i, i*i);
    }
    assertEquals(10, arr.size()); // size() check2
    for (i = 0; i < 10; i++) { // setting keys and their values as the squares of keys
      arr.remove(i);
    }
    assertEquals(0, arr.size()); // size() check 3 — size is zero again. 
  }
  
  // +------------------------+--------------------------------------
  // | Tests by Maya L. Flynn |
  // +------------------------+
  /** 
   * Checks to see if there an array can be 'set' and the last value can be 'get'
   */
  @Test
  public void mayaFlynnTest1() throws NullKeyException {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // set a large number of pairs in the array
    for (int i = 0; i < 65; i++) {
      arr.set(i, i*7);
    } // for
    try{
      // did it set the last number in the array
      assertEquals(64*7, arr.get(64));
    } catch (KeyNotFoundException e) {
      fail("Failed to set");
    }
  } // mayaFlynnTest1()

  /** 
   * Checks to see if cloning, then modifying the original, only changes the original and not the clone as well
   */
  @Test
  public void mayaFlynnTest2() throws NullKeyException {
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();
    // set numbers in an array
    for (int i = 0; i < 8; i++) {
      arr.set(i, "a");
    } // for: set array
    // clone the array
    AssociativeArray<Integer, String> arr2 = arr.clone();
    // change the elements in the original
    for (int i = 0; i < 8; i++) {
      arr.set(i, "b");
    } // for: change original array
    // did the clone remain unchanged like it should
    for (int i = 0; i < 8; i++) {
      try {
      assertEquals("a", arr2.get(i));
      }
      catch (KeyNotFoundException e) {
        fail("Clone changed with the origional array");
      }
    } // for
  } // mayaFlynnTest2()

   /** 
   * Checks to see if adding elements and then removing all of them results in an array of size 0
   */
  @Test
  public void mayaFlynnEdge1() throws NullKeyException {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // set the array
    for (int i = 0; i < 50; i++) {
      arr.set(i, i);
    } // for
    for (int i = 0; i < 50; i++) {
      arr.remove(i);
    } // for
    assertEquals(0, arr.size());
  } // mayaFlynnEdge1()

  // +----------------------------+----------------------------------
  // | Tests by Garikai F. Gijima |
  // +----------------------------+
  /**
   * Can we successfully set the same key to multiple values and get the last one? 
   * @throws NullKeyException 
   */
  @Test
  public void garikaiGijimaTest01() throws NullKeyException {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // Add a bunch of values
    for (int i = 0; i < 150; i++) {
      arr.set(5, i * i);
    } // for
    try{
      assertEquals(149*149, arr.get(5));
    } catch (KeyNotFoundException e) {
      fail("Failed to set to 5");
    }
  } // garikaiGijimaTest01()

  /**
   * Set multiple keys to the same value and return them 
   */
  @Test
  public void garikaiGijimaTest02() {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // Add a bunch of values
    for (int i = 0; i < 150; i++) {
      try {
        arr.set(i, 5);
      } catch (Exception e) {
        fail("Could not call arr.set(" + i + ", 5)");
      }
    } // for
    for (int i = 0; i < 150; i++) {
      try{
        assertEquals(5, arr.get(i));
      } catch (KeyNotFoundException e) {
        fail("Failed to set everything in our loop");
      }
    }
  } // garikaiGijimaTest02()

  /**
   * Can we set a key to have a value of null and retrieve it? 
   * @throws NullKeyException 
   */
  @Test
  public void garikaiGijimaEdge01() throws NullKeyException {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    arr.set(1, null);
    try{
      assertEquals(null, arr.get(1));
    } catch (KeyNotFoundException e) {
      fail("Failed to set to 1");
    }
  } // garikaiGijimaEdge01()

  // +--------------------------+------------------------------------
  // | Tests by Connor E. Heagy |
  // +--------------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Hanmo (Linda) Jing |
  // +-----------------------------+
@Test
public void lindaJingTest1() throws Exception {
  AssociativeArray<BigInteger,BigInteger> testArray = new AssociativeArray<BigInteger, BigInteger>();
    for (int i = 0; i < 11; i++) {
        testArray.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
      }    
    
    assertEquals(true, testArray.hasKey(BigInteger.valueOf(1)));
    assertEquals(true, testArray.hasKey(BigInteger.valueOf(10)));
    assertEquals(false, testArray.hasKey(BigInteger.valueOf(11)));
    assertEquals(false, testArray.hasKey(BigInteger.valueOf(100)));
}

@Test
public void lindaJingTest2() {
    // Creates a new associative array where both k and v are integers
    AssociativeArray<Integer, Integer> testArray = new AssociativeArray<Integer, Integer>();
    try {
        for (int i = -5; i <= -1; i++) {
          testArray.set(i, i * 2); // Example operation to have a different value
        } // for
    } catch (Exception e) {
        fail("Could not add negative key-value pairs to array.");
    }

    // Checks if the negative keys have been added with the correct values
    try {
        for (int i = -5; i <= -1; i++) {
            assertEquals(i * 2, testArray.get(i));
        }
    } catch (Exception e) {
        fail("Array does not contain the expected negative key-value pairs.");
    }
} 

@Test
public void lindaJingEdgeTest() throws Exception {
  AssociativeArray<BigInteger,BigInteger> testArray = new AssociativeArray<BigInteger, BigInteger>();
    for (int i = 0; i < 11; i++) {
        testArray.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
      }    
    
      for (int i = 0; i < 11; i++) {
        testArray.remove(BigInteger.valueOf(i));
        assertEquals(11-i-1,testArray.size());
      }    
      try {
        // The following line should throw an exception
        testArray.get(BigInteger.valueOf(1));
        fail("Did not throw an exception");
      } catch (KeyNotFoundException e) {
        // Do nothing
      }
}
  // +----------------------+----------------------------------------
  // | Tests by Gun Woo Kim |
  // +----------------------+

  @Test
  // check if set(), size() and get() are working correctly:
  public void gunwooKimTest01() {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    
    for(int i = 0; i < 100; i++){
      try {
        arr.set(i, i);
      } catch (Exception e) {
        fail("set() not working correctly");
      }
      try {
        assertEquals(i, arr.get(i));
      } catch (Exception e) {
        fail("get() not working correctly");
      }
      try {
        assertEquals(i + 1, arr.size());
      } catch (Exception e) {
        fail("size() not working correctly");
      }
    }
  }

/*
  // Sam says try again.
  @Test
  // check if toString is working correctly:
  public void gunwooKimTest02() throws Exception {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    assertEquals("{}", arr.toString());
    arr.set(1, 10);
    arr.set(2, 20);
    assertEquals("{ 1: 10, 2: 20 }", arr.toString());
  }
 */

  @Test
  public void gunwooKimEdge01() throws Exception {
    // size of an empty array should be 0
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    assertEquals(0, arr.size());

    // size of an array with 1 element should be 1
    arr.set(1, 1);
    assertEquals(1, arr.size());

    // we can remmove key '1' from the array
    try{
      arr.remove(1);
    } catch (Exception e) {
      fail("remove() not working correctly");
    }

    // cannot remove a key that does not exist
    assertThrows(Throwable.class, () -> {
      arr.remove(1);
    });

    // if we set a value to existing key, it should replace that value
    try{
      arr.set(1, 2);
      arr.set(1, 3);
      assertEquals(3, arr.get(1));
    } catch (Exception e) {
      fail("set() doesn't replace the value of existing key");
    }
  }

  // +--------------------+------------------------------------------
  // | Tests by Si-Ho Kim |
  // +--------------------+

  @Test
  public void sihoKimTest01 () throws NullKeyException, KeyNotFoundException {
    AssociativeArray<Integer, Integer> ar = new AssociativeArray<Integer, Integer>();
    for (int i = 0; i < 1000; i++) {
      ar.set(i, i);
    }
    for (int i = 0; i < 1000; i++) {
      assertEquals(ar.get(i), i);
    }
  }

  @Test
  public void sihoKimTest02 () throws NullKeyException, KeyNotFoundException {
    AssociativeArray<Integer, Integer> ar = new AssociativeArray<Integer, Integer>();
    for (int i = 0; i < 900; i += 2) {
      ar.set(i, i);
    }
    for (int i = 0; i < 900; i += 2) {
      assertEquals(ar.get(i), i);
    }
  }

  @Test
  public void sihoKimTest03 () throws NullKeyException, KeyNotFoundException { //Edge case test
    AssociativeArray<Integer, Integer> ar = new AssociativeArray<Integer, Integer>();
    for (int i = 0; i < 1000; i++) {
      ar.set(i, i);
    }
    for (int i = 0; i <= 1000; i++) {
      try {
        ar.get(i);
      } catch (Exception e) {
        assertEquals(i, 1000);
      }
    }
  }


  // +----------------------+----------------------------------------
  // | Tests by Trung T. Le |
  // +----------------------+

  // +---------------------------+-----------------------------------
  // | Tests by Yuxuan (Tony) Li |
  // +---------------------------+

  // +---------------------------------+-----------------------------
  // | Tests by Hui-Chieh (Candice) Lu |
  // +---------------------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Alexander J. Maret |
  // +-----------------------------+
  /**
   * Tests get(K key) on a given associative array
   */
  @Test
  public void alexanderMaretTest01() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer,String>();

    arr.set(0, "Hello");
    arr.set(1, "World");

    assertEquals("Hello", arr.get(0));
    assertEquals("World", arr.get(1));
    assertThrows(KeyNotFoundException.class, () -> {arr.get(2);});
  }


  /**
   * Tests size() at various points in the construction of an associative array
   */
  @Test
  public void alexanderMaretTest02() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();
    assertEquals(0, arr.size());

    arr.set(0, "Hello");
    assertEquals(1, arr.size());

    arr.set(1, "World");
    assertEquals(2, arr.size());

    arr.set(0, "Goodbye");
    assertEquals(2, arr.size());

    arr.remove(1);
    assertEquals(1, arr.size());
  }

  /**
   * Tests size() and hasKey(K key) specifically when the final element of an array is removed
   */
  @Test
  public void alexanderMaretEdge01() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();

    arr.set(0, "Test");
    assertEquals(1, arr.size());
    assertTrue(arr.hasKey(0));

    arr.remove(0);
    assertEquals(0, arr.size());
    assertFalse(arr.hasKey(0));
  }

  // +----------------------------+----------------------------------
  // | Tests by Keely R. Miyamoto |
  // +----------------------------+
  /**
   * Does get properly return the value of a given key (when that key is in the array)?
   */
  @Test
  public void keelyMiyamotoTest1() {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    for (int i = 0; i < 100; i++) {
      // Build an AssociativeArray with KVPairs (0, 0) to (99, 198)
      try {
        arr.set(i, 2 * i);
      } catch (Exception e) {
        fail("Array initialization unsuccessful.");
      }
      // Attempt to 'get' the value at each key in {0, ..., 99}
      try {
      assertEquals(2 * i, arr.get(i));
      } catch (Exception e) {
        fail("Did not properly 'get'.");
      }
    }
  } // keelyMiyamotoTest1

  /**
   * Does 'remove' delete the desired key/value pair (when the key appears in the array)?
   * (And does size appropriately reduce by 1?)
   */
  @Test
  public void keelyMiyamotoTest2() {
    // Build an array; check that it contains expected values.
    AssociativeArray<Integer, Double> arr = new AssociativeArray<Integer, Double>();
    for (int i = 0; i < 100; i++) {
      try {
        arr.set(i, java.lang.Math.random());
      } catch (Exception e) {
        fail("Array initialization unsucessful.");
      }
    }
    // Check array size.
    try {
      assertEquals(100, arr.size());
    } catch (Exception e) {
      fail("Array does not have expected size");
    }
    // Call 'remove' with several keys in the array. 
    for (int i = 10; i < 20; i++) {
      int initialSize = arr.size();
      try { 
        arr.remove(i);
      } catch (Exception e) {
        fail("Array removal unsuccessful.");
      }
      // Verify that the array no longer has that key.
      try {
        assertFalse(arr.hasKey(i));
      } catch (Exception e) {
        fail("The desired key was not removed");
      }
      // Also check that size was reduced by 1.
      try {
        assertEquals(initialSize - 1, arr.size());
      } catch (Exception e) {
        fail("Array did not shrink after remove was called.");
      }
    }
  } // keelyMiyamotoTest2

  /**
   * Edge case: Does 'size' appropriately return zero?
   * Note that array size is zero for new arrays and emptied arrays.
   */
  @Test
  public void keelyMiyamotoEdge1() {
    // Build an array. Do not add any values, and check size.
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      assertEquals(0, arr.size());
    } catch (Exception e) {
      fail("Size of empty array was non-zero.");
    }
    // Add a value to the array. Check that array does contain the added value.
    try {
      arr.set("A", "Apple");
    } catch (Exception e) {
      fail("Array initialization unsuccessful.");
    }
    // Call 'remove' with a key in the array. Ensure that the key was removed.
    try {
      arr.remove("A");
    } catch (Exception e) {
      fail("Array removal unsuccessful.");
    }
    // Verify that the size of the emptied array is zero.
    try {
      assertEquals(0, arr.size());
    } catch (Exception e) {
      fail("Size of empty array was non-zero.");
    }
  } // keelyMiyamotoEdge1

  // +------------------------------+--------------------------------
  // | Tests by Shibam Mukhopadhyay |
  // +------------------------------+

  // +-------------------------------+-------------------------------
  // | Tests by William A. Pitchford |
  // +-------------------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Samuel A. Rebelsky |
  // +-----------------------------+

  /**
   * A test of cloning.
   * @throws NullKeyException 
   */
  @Test
  public void samuelRebelskyTest01() throws NullKeyException {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (Exception e) {
      fail("Original array does not contain expected value");
    }
    // Make a copy
    AssociativeArray<String, String> arr2 = arr.clone();
    // Make sure it contains the appropriate value
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Clone does not contain original value");
    } // try/catch
    // Change the original array
    arr.set("A", "aardvark");
    // Make sure we haven't changed the clone.
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Change to original changes clone.");
    }
    // Change the clone
    arr2.set("A", "Ant");
    // And look for values
    try {
      assertEquals("Ant", arr2.get("A"));
    } catch (Exception e) {
      fail("Cannot change clone");
    }
    try {
      assertEquals("aardvark", arr.get("A"));
    } catch (Exception e) {
      fail("Change to clone changes original");
    }
  } // samuelRebelskyTest01()

  /**
   * Can we successfully add a bunch of values? (Checks array expansion.)
   * @throws NullKeyException 
   */
  @Test
  public void samuelRebelskyTest02() throws NullKeyException {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // Add a bunch of values
    for (int i = 10; i < 50; i++) {
      arr.set(i, i * i);
    } // for
    try {
      for (int i = 49; i >= 10; i--) {
        assertEquals(i * i, arr.get(i));
      }
    } catch (Exception e) {
      fail("Exception in call to get");
    }
  } // samuelRebelskyTest02()

  /**
   * Do we get exceptions when grabbing a deleted value from the array?
   * @throws NullKeyException 
   */
  @Test
  public void samuelRebelskyTest03() throws NullKeyException {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // Add an element to the array
    arr.set("A", "Apple");
    // Make sure that it's there.
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (KeyNotFoundException e) {
      fail("Could not set A to Apple");
    }
    // Remove it.
    arr.remove("A");
    // Make sure it's no longer there.
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyTest03

  /**
   * Does `toString` work correctly on multi-element arrays?
   * @throws NullKeyException 
   */
  @Test
  public void samuelRebelskyTest04() throws NullKeyException {
    AssociativeArray<String,Integer> si = 
      new AssociativeArray<String,Integer>();
    si.set("A",1);
    si.set("B",2);
    si.set("C",3);
    String result = si.toString();
    // System.err.println(result);
    assertTrue(result.equals("{ A: 1, B: 2, C: 3 }") ||
          result.equals("{ A: 1, C: 3, B: 2 }") ||
          result.equals("{ B: 2, A: 1, C: 3 }") ||
          result.equals("{ B: 2, C: 3, A: 1 }") ||
          result.equals("{ C: 3, A: 1, B: 2 }") ||
          result.equals("{ C: 3, B: 2, A: 1 }"));
  } // samuelRebelskyTest04()

  /**
   * Do we get exceptions when grabbing a value from the empty array?
   */
  @Test
  public void samuelRebelskyEdge01() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyEdge01

  // +---------------------------+-----------------------------------
  // | Tests by David I. Rhoades |
  // +---------------------------+

  /**
   * Does using set with a key already in use overwrite the existing value?
   * @throws KeyNotFoundException 
   * @throws NullKeyException 
   */
  @Test
  public void davidRhoadesTest01() throws KeyNotFoundException, NullKeyException {
    AssociativeArray<Integer, Character> arr = new AssociativeArray<Integer, Character>();
    arr.set(1, 'a');
    arr.set(1, 'b');
    assertEquals(arr.get(1), 'b', "set overwrites previous values");
  }

  /**
   * Does hasKey return false if a key hasnt been added, true if it has, and false if it has been removed?
   * @throws NullKeyException 
   */
  @Test
  public void davidRhoadesTest02() throws NullKeyException {
    AssociativeArray<String, Character> arr = new AssociativeArray<String, Character>();
    assertFalse(arr.hasKey("now you see me"), "hasKey returns false for an unused key");
    arr.set("now you see me", 'x');
    assertTrue(arr.hasKey("now you see me"), "hasKey returns true for a used key");
    arr.remove("now you see me");
    assertFalse(arr.hasKey("now you see me"), "hasKey returns false for a removed key");
  }

  // +--------------------------+------------------------------------
  // | Tests by Arsal K. Shaikh |
  // +--------------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Elene Sturua |
  // +-----------------------+

  // +---------------------------+-----------------------------------
  // | Tests by Nye A. Tenerelli |
  // +---------------------------+

  // +--------------------------+------------------------------------
  // | Tests by Alyssa A. Trapp |
  // +--------------------------+
  
 /*
   * Will the methods on the original array return the same on the clone of the array?
   */
  @Test 
  public void alyssaTrappTest01(){
  // Build an array
  AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
  // Sets key of l to Lemon
          arr.set("l", "Lemon");
        } catch (NullKeyException e) {
            fail("Array initialization unsuccessful.");
          }
  // Checks if the hasKey method is the same for the original array and clone
    assertEquals((arr.hasKey("l")), true);
    assertEquals((arr.clone().hasKey("l")), true);
  // Checks if the get method is the same for the original array and clone
        try {
          assertEquals((arr.get("l")), "Lemon");
          assertEquals((arr.clone().get("l")), "Lemon");
        } catch(KeyNotFoundException e){
        fail ("The key of l wasn't found.");
    } 
  // Checks if the size method is the same for the original array and clone
    assertEquals(arr.size(), 1);
    assertEquals (arr.clone().size(), 1);
  }


  /*
   * Will setting values to the same key value overwrite the previous value stored at the key?
   */

 @Test 
 public void alyssaTrappTest02(){
   // Build an array
  AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
  // Sets key of z to Kitten
        arr.set("z", "Kitten");
       } catch (NullKeyException e) {
          fail("Array initialization unsuccessful.");
          }
    try {
        assertEquals("Kitten", arr.get("z"));
          } catch (KeyNotFoundException e) {
              fail("Could not set t to Kitten");
            }
    try {
    // resets key of z to Puppy
        arr.set("z", "Puppy");
          } catch (NullKeyException e) {
              fail("Array initialization unsuccessful.");
          }

   try {
      assertEquals("Puppy", arr.get("z"));
        } catch (KeyNotFoundException e) {
            fail("Could not set t to Kitten");
          }
  } //alyssaTrappTest02
        
  /*
   * Will setting and then removing for every index create an empty array?
   */

   @Test 
   public void alyssaTrappEdge01(){
   // Build an array
   AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
     try {
   //Expands original array
          for (int i = 0; i < 1000; i++){
            arr.set("key" + i, "expanded");
            }
          } catch (NullKeyException e) {
            fail("Array initialization unsuccessful."); 
          }
     for (int i = 0; i < 1000; i++){
       arr.remove("key" + i);
     }
   assertEquals (arr.size(), 0);
 } //alyssaTrappEdge01

  // +---------------------------+-----------------------------------
  // | Tests by Amelia K. Vrieze |
  // +---------------------------+

  //Tests null key exception when setting a KVPair
  @Test
  public void ameliaEdge1() {
    AssociativeArray<String, String> aarr = new AssociativeArray<String, String>();
    try {
      aarr.set(null, "hello");
      fail();
    } catch (Exception e) {
      assertEquals(e instanceof NullKeyException, true, "Exception is a NullKeyException");
    }
  }

  //Can an associative array hold an associative array? 
  //(Test to make sure it can hold types beyond primitive types/Strings)
  @Test
  public void ameliaTest1() {
    AssociativeArray<String, String> inside = new AssociativeArray<String, String>();
    AssociativeArray<String, AssociativeArray<String, String>> outside = new AssociativeArray<String, AssociativeArray<String, String>>();
    try {
      inside.set("a", "apple");
      outside.set("a", inside);
      assertEquals(inside, outside.get("a"), "Successfully get the AssociativeArray stored inside another AssociativeArray");
    } catch (Exception e) {
      fail();
    }
  }

  //"Removing" a null key doesn't affect size and doesnt't throw an exception
  @Test
  public void ameliaTest2() {
    AssociativeArray<Integer, Integer> aarr = new AssociativeArray<Integer, Integer>();
    try {
      for (int i = 0; i < 10; i++) {
        aarr.set(i, i);
      }
      assertEquals(aarr.size(), 10, "Before removing null");
      aarr.remove(null);
      assertEquals(aarr.size(), 10, "After removing null");
    } catch (Exception e) {
      fail();
    }


  }

  // +---------------------------+-----------------------------------
  // | Tests by Lucas S. Willett |
  // +---------------------------+

  @Test
  public void lucasTest1() throws NullKeyException{
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();
    arr.set(1, "one");
    arr.set(2, "two");
    arr.set(4, "four");
    arr.set(3, "three");
    try {
      assertEquals("four", arr.get(4));
    } catch (Exception e) {
      fail();
    }
  }//lucasTest1 int key, string value

  @Test
  public void lucasTest2() throws NullKeyException{
    AssociativeArray<String, Integer> arr = new AssociativeArray<String, Integer>();
    arr.set("one", 1);
    arr.set("four", 4);
    arr.set("two", 2);
    arr.set("three", 3);
    try {
      assertEquals(2, arr.get("two"));
    } catch (Exception e) {
      fail();
    }
  }//lucasTest2 string key, integer value

  @Test
  public void lucasTestEdge() throws NullKeyException{
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    arr.set(1, 1);
    arr.set(2, 2);
    arr.remove(2);
    arr.remove(1);
    try {
      assertEquals(0, arr.size());
    } catch (Exception e) {
      fail();
    }
  }//lucasTestEdge size if no 


  // +-----------------------------+---------------------------------
  // | Tests by Yiwei (Vivien) Yan |
  // +-----------------------------+

  // +--------------------------------+------------------------------
  // | Tests by Shizhan (Vincent) Yao |
  // +--------------------------------+
  //Test1 does the remove function reduce the size if the key wasn't in the pair?
  @Test
  public void Vincenttest1() throws NullKeyException{
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("hellworld", "1");
    arr.set("goodbyeworld", "1");
    int sizebefore = arr.size();
    arr.remove("nothing");
    try {
      assertEquals(sizebefore, arr.size());
    } catch (Exception e) {
      fail();
    }
  }//Testforremove
  //Test2 Test to get the value using key that does not exist. 
  @Test
  public void Vincenttest2() {
      AssociativeArray<String, String> arr = new AssociativeArray<>();
      try {
          arr.set("a", "this is a");
          // try to get value 
          arr.get("nullvalue");
          // if there aren't any exception, failed 
          fail("no KeyNotFoundException thrown");
      } catch (KeyNotFoundException | NullKeyException e) {
          // 
      }
  }
  //Test3 test for tostring
/*
  // Sam says: "Don't assume a particular order for the elements
  // in the array.
  @Test
  public void testToString() {
      AssociativeArray<String, String> arr = new AssociativeArray<>();
      try {
          arr.set("a", "this is a");
          arr.set("b", "this is b");
          String expected1 = "{ a: this is a, b: this is b }";
          String expected2 = "{ b: this is b, a: this is a }";
          String actual = arr.toString();
          ssertTrue(actual.equals("{ a: this is a, b: this is b }") ||"{ b: this is b, a: this is a }");
      } catch (NullKeyException e) {
          fail("NullKeyException should not be thrown");
      }
  }
 */

  // +----------------------+----------------------------------------
  // | Tests by Tianyang Yu |
  // +----------------------+
  /**
   * Is the size of the array calculated properly?
   */
  @Test
  public void timYuTest1() {
    AssociativeArray<Integer, Double> arr = new AssociativeArray<Integer, Double>();
    for (int i = 0; i < 1000; i++) {
      assertEquals(i, arr.size(), "Returns the correct size");
      try {
        arr.set(i, java.lang.Math.random());
      } catch (Exception e) {
        fail();
      }
    }
  }

  /**
   * Does hasKey return true after a key is added and false otherwise?
   */
  @Test
  public void timYuTest2() {
    AssociativeArray<Integer, Double> arr = new AssociativeArray<Integer, Double>();
    for (int i = 0; i < 1000; i++) {
      assertFalse(arr.hasKey(i));
      try {
        arr.set(i, java.lang.Math.random());
      } catch (Exception e) {
        fail();
      }
      assertTrue(arr.hasKey(i));
    }
  }

  /**
   * Removing a key/value pair that does not exist should do nothing
   */
  @Test
  public void timYuEdge1() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      arr.set("hello", "world");
      arr.set("lorem", "ipsum");
    } catch (Exception e) {
      fail("Setting shouldn't throw exceptions");
    }

    int sizeBefore = arr.size();
    try {
      arr.remove("foo");
    } catch (Exception e) {
      fail("Removing nonexistent entry should not throw exceptions");
    }
    int sizeAfter = arr.size();

    assertTrue(arr.hasKey("hello"));
    assertTrue(arr.hasKey("lorem"));
    assertFalse(arr.hasKey("foo"));
    assertEquals(sizeBefore, sizeAfter);
  }
  
  @Test
  public void vivienyTest1() throws NullKeyException, KeyNotFoundException {
    AssociativeArray<String, Integer> Test1 = new AssociativeArray<>();
    Test1.set("Vivien", 1);
    Test1.set("Vivien", 2);
    Test1.set("ABC", 1);
    assertEquals(Integer.valueOf(2), Test1.get("Vivien"));
    assertEquals(Integer.valueOf(1), Test1.get("ABC"));
  }

  @Test
  public void vivienyTest2() throws NullKeyException {
    AssociativeArray<String, String> Test2 = new AssociativeArray<>();
    Test2.set("Vivien", "Yan");
    Test2.set("ABC", "Wang");
    Test2.remove("ABC");
    assertFalse(Test2.hasKey("ABC"));
    assertEquals(1, Test2.size());

  }

  @Test
  public void vivienyEdge1() throws NullKeyException, KeyNotFoundException {
    AssociativeArray<Integer, Integer> Edge = new AssociativeArray<>();
    Edge.set(1, 20);
    Edge.set(2, 30);
    Edge.set(3, 40);
    Edge.set(4, 20);
    Edge.set(5, 30);
    Edge.set(6, 40);
    Edge.set(7, 20);
    Edge.set(8, 30);
    Edge.set(9, 40);
    Edge.set(10, 20);
    Edge.set(11, 30);
    Edge.set(12, 40);
    Edge.set(13, 20);
    Edge.set(22, 30);
    Edge.set(23, 40);
    Edge.set(31, 20);
    Edge.set(42, 30);
    Edge.set(53, 40);
    Edge.set(61, 20);
    Edge.set(72, 30);
    Edge.set(83, 40);
    assertTrue(Edge.hasKey(4));
    assertEquals(21, Edge.size());
  }
} // class AssociativeArrayTests
