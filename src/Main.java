import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // CREATE 2 SETS
        // ADD ITEMS TO EACH OF THE SETS (SOME SAME, SOME DIFFERENT)

        // TEST
        // SET INTERSECTION
        // SET UNION
        // SET DIFFERENCE

        MathSet<String> set1 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Tina");

        MathSet<String> set2 = new BSTSet<>();

        // union set 1 and set 2, save into result1
        MathSet<String> result1 = set1.union(set2);

        //print out keys from result 1
        for (String key : result1.keys()) {
            System.out.println(key);
        }
    }
}