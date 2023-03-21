import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Create 2 BSTSets
        // add items to each of the sets (some same, some different)
        MathSet<String> set1 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Ken");
        set1.add("Tina");
        set1.add("Susan");

        MathSet<String> set2 = new BSTSet<>();
        set2.add("Josh");
        set2.add("Ken");
        set2.add("Tyler");

        // Test

        // intersection set 1 and set 2
        MathSet<String> result1 = set1.intersection(set2);
        System.out.println("\nBSTSet intersection: ");
        for (String key : result1.keys()) {
            System.out.println(key);
        }

        // union set 1 and set 2
        MathSet<String> result2 = set1.union(set2);
        System.out.println("\nBSTSet union: ");
        for (String key : result2.keys()) {
            System.out.println(key);
        }

        // difference set 1 -> set 2
        MathSet<String> result3 = set1.difference(set2);
        System.out.println("\nBSTSet difference: ");
        for (String key : result3.keys()) {
            System.out.println(key);
        }

        // difference set 2 -> set 1
        MathSet<String> result4 = set2.difference(set1);
        System.out.println("\nBSTSet reverse difference : ");
        for (String key : result4.keys()) {
            System.out.println(key);
        }
    }
}