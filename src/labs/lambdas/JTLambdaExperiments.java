package labs.lambdas;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * JTLambdaExperiments.java
 *
 * A variety of experiments for working with lambdas, based on the Java Tutorial on lambda
 * expressions, available at
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author Samuel A. Rebelsky
 * @author Natalie Nardone
 * @author Grant Sackmann
 */
public class JTLambdaExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {
    List<Person> roster = new ArrayList<>();
    roster.add(new Person("Natalie", IsoChronology.INSTANCE.date(1980, 6, 20), Person.Sex.MALE,
        "natalie@example.com"));
    roster.add(new Person("Nicole", IsoChronology.INSTANCE.date(1990, 7, 15), Person.Sex.FEMALE,
        "nicole@example.com"));
    roster.add(new Person("Nicky", IsoChronology.INSTANCE.date(1991, 8, 13), Person.Sex.MALE,
        "nicky@example.com"));
    roster.add(new Person("Nathan", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE,
        "nathan@example.com"));

    // calling cool functions
    printPersonsOlderThan(roster, 25);
    



  } // main(String[])

  // +--------------------------------+------------------------------
  // | Methods from the Java Tutorial |
  // +--------------------------------+
  public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
      if (p.getAge() >= age) {
        p.printPerson();
      }
    }
  }


  public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
    for (Person p : roster) {
      if (low <= p.getAge() && p.getAge() < high) {
        p.printPerson();
      }
    }
  }

  public static void printPersons(List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
      if (tester.test(p)) {
        p.printPerson();
      }
    }
  }

  public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
    for (Person p : roster) {
      if (tester.test(p)) {
        p.printPerson();
      }
    }
  }

  public static void processPersons(List<Person> roster, Predicate<Person> tester,
      Consumer<Person> block) {
    for (Person p : roster) {
      if (tester.test(p)) {
        block.accept(p);
      }
    }
  }

  public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
      Function<Person, String> mapper, Consumer<String> block) {
    for (Person p : roster) {
      if (tester.test(p)) {
        String data = mapper.apply(p);
        block.accept(data);
      }
    }
  }

  public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
      Function<X, Y> mapper, Consumer<Y> block) {
    for (X p : source) {
      if (tester.test(p)) {
        Y data = mapper.apply(p);
        block.accept(data);
      }
    }
  }

  interface CheckPerson {
    boolean test(Person p);
  }

  class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
      return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }
  }

} // class JTLambdaExperiments
