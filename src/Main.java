import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // BSTSET:
        System.out.println("\nBSTSet Testing: ");

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
        System.out.println("\nBSTSet reverse difference: ");
        for (String key : result4.keys()) {
            System.out.println(key);
        }

        // HASHSET:
        System.out.println("\nHashSet Testing: ");

        // Create 2 HashSets
        // add items to each of the sets (some same, some different)
        MathSet<String> set3 = new HashSet<>(1);
        set3.add("Ken");
        set3.add("Ken");
        set3.add("Tina");
        set3.add("Susan");

        MathSet<String> set4 = new HashSet<>(10);
        set4.add("Josh");
        set4.add("Ken");
        set4.add("Tyler");

        // Test

        // intersection set 3 and set 4
        MathSet<String> result5 = set3.intersection(set4);
        System.out.println("\nHashSet intersection: ");
        for (String key : result5.keys()) {
            System.out.println(key);
        }

        // union set 3 and set 4
        MathSet<String> result6 = set3.union(set4);
        System.out.println("\nHashSet union: ");
        for (String key : result6.keys()) {
            System.out.println(key);
        }

        // difference set 3 -> set 4
        MathSet<String> result7 = set3.difference(set4);
        System.out.println("\nHashSet difference: ");
        for (String key : result7.keys()) {
            System.out.println(key);
        }

        // difference set 4 -> set 3
        MathSet<String> result8 = set4.difference(set3);
        System.out.println("\nHashSet reverse difference: ");
        for (String key : result8.keys()) {
            System.out.println(key);
        }
    }
}