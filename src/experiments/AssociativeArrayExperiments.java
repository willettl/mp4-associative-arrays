package experiments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.PrintWriter;
import java.math.BigInteger;

import structures.AssociativeArray;
import structures.KeyNotFoundException;
import structures.NullKeyException;

/**
 * Experiments with our AssociativeArray class.
 *
 * @author Lucas Willett
 * @author Samuel A. Rebelsky
 */
public class AssociativeArrayExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run the experiments.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    divider(pen);
    expreimentStringsToStrings(pen);
    divider(pen);
    experimentBigIntToBigInt(pen);
    divider(pen);
  } // main(String[])

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Our first experiment: Associative arrays with strings as both keys 
   * and values.
   */
  public static void expreimentStringsToStrings(PrintWriter pen) throws Exception {

    AssociativeArray<String,String> s2s = 
      new ReportingAssociativeArray<String,String>("s2s", pen);
    s2s.size();
    s2s.set("a", "apple");
    s2s.set("A", "aardvark");
    s2s.size();
    s2s.hasKey("a");
    s2s.hasKey("A");
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
    s2s.remove("a");
    s2s.size();
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
    s2s.remove("aardvark");
    s2s.size();
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
  } // expreimentStringsToStrings

  /**
   * Our second experiment: Associative arrays with big integers as
   * keys and values.
   */
  public static void experimentBigIntToBigInt(PrintWriter pen) throws Exception {
    AssociativeArray<BigInteger,BigInteger> b2b =
      new ReportingAssociativeArray<BigInteger,BigInteger>("b2b", pen);

    // Set some values
    for (int i = 0; i < 20; i++) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
      b2b.size();
    } // for

    // Then get them
    for (int i = 0; i < 20; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    // Then remove some of them
    for (int i = 1; i < 20; i += 2) {
      b2b.remove(BigInteger.valueOf(i));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 20; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    // Then reset or set some values
    for (int i = 0; i < 20; i += 3) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i + 10));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 20; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    AssociativeArray<BigInteger,BigInteger> testArray = new AssociativeArray<BigInteger, BigInteger>();
    for (int i = 0; i < 11; i++) {
        testArray.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
      }    
    
      for (int i = 0; i < 11; i++) {
        testArray.remove(BigInteger.valueOf(i));
        pen.println(11-i-1);
        pen.println(testArray.size());
      }    
     
      

  } // experimentBigIntToBigInt

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Print a divider.
   */
  public static void divider(PrintWriter pen) {
    pen.println();
    pen.println("------------------------------------------------");
    pen.println();
  } // divider(PrintWriter)

} // AssociativeArrayExperiments
