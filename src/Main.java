import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.HashSet;

/**
 * Main method that tests the BSTSet and HashSet classes
 * @author: Jasmine David
 */
public class Main {
    public static void main(String[] args) {
        // write code that tests methods in set
        // Create 2 sets
        // add items to each of the sets (some same, some different)

        MathSet<String> set1 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Tina");
        set1.add("Jasmine");
        set1.add("Ashley");

        MathSet<String> set2 = new HashSet<>();
        set2.add("Ken");
        set2.add("Josh");
        set2.add("Tyler");
        set2.add("Ashley");
        set2.add("Stephanie");

        System.out.println("Set 1: ");
        for (String key : set1.keys()) {
            System.out.println(key);
        }

        System.out.println("\nSet 2: ");
        for (String key : set2.keys()) {
            System.out.println(key);
        }


        // TESTING FOR SET 1 -------
        System.out.println("\nIs Set 1 empty? " + set1.isEmpty());
        System.out.println("Does Set 1 contain Josh? " + set1.contains("Josh"));
        System.out.println("Size of Set 1: " + set1.size());

        // TESTING FOR SET 2 -------
        System.out.println("\nIs Set 2 empty? " + set2.isEmpty());
        System.out.println("Does Set 2 contain Josh? " + set2.contains("Josh"));
        System.out.println("Size of Set 2: " + set2.size());


        // TESTING UNION ------
        System.out.println("\nTEST UNION: ");
        // union set 1 and set 2, save into result1
        MathSet<String> result1 = set1.union(set2);
        // print out keys from result1 - need for each loop to get the keys!
        for (String key : result1.keys()) {
            System.out.println(key);
        }

        // TESTING INTERSECTION ------
        System.out.println("\nTEST INTERSECTION: ");
        MathSet<String> result2 = set1.intersection(set2);
        for (String key : result2.keys()) {
            System.out.println(key);
        }


        // TESTING DIFFERENCE ------
        System.out.println("\nTEST DIFFERENCE: ");
        MathSet<String> result3 = set1.difference(set2);
        for (String key : result3.keys()) {
            System.out.println(key);
        }

    }
}