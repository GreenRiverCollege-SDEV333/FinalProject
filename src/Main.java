import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.HashSet;

/**
 * Used to test our set implementations.  Each class is declared twice to
 * test against itself.  Uncomment/comment the appropriate lines to test
 * a specific class (BSTSet or SeparateChainingHashSet)
 *
 * @author Paul Woods
 */
public class Main {
    public static void main(String[] args) {



        // Test BSTSet structures
        //MathSet<String> test1 = new BSTSet<>();
        //MathSet<String> test2 = new BSTSet<>();

        // Test SeparateChainingHashTable structures
        MathSet<String> test1 = new HashSet<>();
        MathSet<String> test2 = new HashSet<>();

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

    }
}