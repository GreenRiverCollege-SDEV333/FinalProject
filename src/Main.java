import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeparateChainingHashST;

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

        //test number 2

        SeparateChainingHashST<String> st1 = new SeparateChainingHashST<>();
        SeparateChainingHashST<String> st2 = new SeparateChainingHashST<>();

        st1.put("a", 1);
        st1.put("b", 2);
        st1.put("c", 3);

        st2.put("c", 4);
        st2.put("d", 5);
        st2.put("e", 6);

        // Testing union
        SeparateChainingHashST<String> union = st1.union(st2);
        System.out.println("Union:");
        for (String key : union.keys()) {
            System.out.println(key + ": " + union.get(key));
        }

        // Testing intersection
        SeparateChainingHashST<String> intersection = st1.intersection(st2);
        System.out.println("Intersection:");
        for (String key : intersection.keys()) {
            System.out.println(key + ": " + intersection.get(key));
        }

        // Testing difference
        SeparateChainingHashST<String> difference = st1.difference(st2);
        System.out.println("Difference:");
        for (String key : difference.keys()) {
            System.out.println(key + ": " + difference.get(key));
        }

    }




}
