import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeparateChainingHashTable;
import java.security.Key;

/**
 * Used to test our set implementations.  The tests are divided into two
 * sections, one per class (BSTSet first, then SeparateChainingHashSet next)
 * @author Paul Woods
 */
public class Main {
    public static void main(String[] args) {

        // Test BSTSet structures
        MathSet<String> test1 = new BSTSet<>();
        MathSet<String> test2 = new BSTSet<>();

        // Test SeparateChainingHashTable structures
        MathSet<String> test3 = new SeparateChainingHashTable<>();
        MathSet<String> test4 = new SeparateChainingHashTable<>();


        /*
         * Code to test BSTSet.java - it works!
         */
        System.out.println("----------------------------------------------");
        System.out.println("TESTING BSTSet Class -------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("isEmpty() - should be true: " + test1.isEmpty());
        System.out.println("size() - should be 0: " + test1.size());

        System.out.println("adding 6 keys to set ... ");

        test1.add("g");
        test1.add("q");
        test1.add("r");
        test1.add("b");
        test1.add("k");
        test1.add("c");

        System.out.println("size() - should be 6: " + test1.size());
        System.out.println("isEmpty() - should be false: " + test1.isEmpty());
        System.out.println();
        System.out.println("contains('r') - should be true:  " + test1.contains("r"));
        System.out.println("contains('a') - should be false:  " + test1.contains("a"));
        System.out.println("contains('c') - should be true:  " + test1.contains("c"));
        System.out.println("contains('z') - should be false:  " + test1.contains("z"));
        System.out.println();

        System.out.println("Creating 2nd set to test MathSet interface functions");

        test2.add("z");
        test2.add("a");
        test2.add("b"); // in test1
        test2.add("q"); // in test1
        test2.add("j");
        test2.add("c"); // in  test1

        System.out.println("contents of test1: " + test1.toString());
        System.out.println("contents of test2: " + test2.toString());
        System.out.println();
        System.out.println("test1.union(test2): " + test1.union(test2));
        System.out.println("test1.intersection(test2): " + test1.intersection(test2));
        System.out.println("test1.difference(test2): " + test1.difference(test2));

        /*
         * End BSTSet testing code
         */

        /*
         * Code to test SeparateChainingHashTable.java
         */
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("TESTING SeparateChainingHashTable Class ------");
        System.out.println("----------------------------------------------");
        System.out.println("isEmpty() - should be true: " + test3.isEmpty());
        System.out.println("size() - should be 0: " + test3.size());

        System.out.println("adding 6 keys to set ... ");

        test3.add("g");
        test3.add("q");
        test3.add("r");
        test3.add("b");
        test3.add("k");
        test3.add("c");

        System.out.println("size() - should be 6: " + test3.size());
        System.out.println("isEmpty() - should be false: " + test3.isEmpty());
        System.out.println();
        System.out.println("contains('r') - should be true:  " + test3.contains("r"));
        System.out.println("contains('a') - should be false:  " + test3.contains("a"));
        System.out.println("contains('c') - should be true:  " + test3.contains("c"));
        System.out.println("contains('z') - should be false:  " + test3.contains("z"));
        System.out.println();

        System.out.println("Creating 2nd set to test MathSet interface functions");

        test4.add("z");
        test4.add("a");
        test4.add("b"); // in test3
        test4.add("q"); // in test3
        test4.add("j");
        test4.add("c"); // in  test3

        System.out.println("contents of test3: " + test3.toString());
        System.out.println("contents of test4: " + test4.toString());
        System.out.println();
        System.out.println("test3.union(test4): " + test3.union(test4));
        System.out.println("test3.intersection(test4): " + test3.intersection(test4));
        System.out.println("test3.difference(test4): " + test3.difference(test4));
        /*
         * End SeparateChainingHashTable testing code
         */

    }
}