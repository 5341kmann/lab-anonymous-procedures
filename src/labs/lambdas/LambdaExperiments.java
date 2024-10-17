package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * LambdaExperiments.java
 *
 * A variety of experiments for working with lambdas. 
 *
 * @author Samuel A. Rebelsky
 * @author Natalie Nardone
 * @author Grant Sackmann
 */
public class LambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    String[] tmp =
      new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                     "foxtrot", "golf", "hotel", "india",
                     "juliett", "kilo", "lima", "mike",
                     "november", "oscar", "papa", "quebec",
                     "romeo", "sierra", "tango", "uniform",
                     "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
  } // main(String[])

} // class LambdaExperiments
