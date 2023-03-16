import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Test add method
        MathSet<String> set1 = new BSTSet<>();
        set1.add("cat");
        set1.add("dog");
        assert(set1.contains("cat"));
        assert(set1.contains("dog"));

        MathSet<String> set2 = new BSTSet<>();
        set2.add("dog");
        set2.add("mouse");
        assert(set2.contains("dog"));
        assert(set2.contains("mouse"));

        // Test union method
        MathSet<String> result1 = set1.union(set2);
        assert(result1.contains("cat"));
        assert(result1.contains("dog"));
        assert(result1.contains("mouse"));

        // Test intersection method
        MathSet<String> result2 = set1.intersection(set2);
        assert(result2.contains("dog"));
        assert(!result2.contains("cat"));
        assert(!result2.contains("mouse"));

        // Test difference method
        MathSet<String> result3 = set1.difference(set2);
        assert(result3.contains("cat"));
        assert(!result3.contains("dog"));
        assert(!result3.contains("mouse"));
    }
}
