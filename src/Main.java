import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;


public class Main {
    public static void main(String[] args) {

        //WRITE CODE TO MAKE SURE YOUR SET WORKS

        System.out.println("Hello world!");

        /*

        create 2 sets
        add items to each of the sets (some same, some different)

        Test
        set intersection
        set union
        set difference

         */

//        MathSet<String> set1 = new BSTSet<>();
        MathSet<String> set1 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Tina");

        // union set 1 and set 2, save into result1
        MathSet<String> set2 = new BSTSet<>();

        // print out keys from result1
        MathSet<String> result1 = set1.union(set2);
        for (String key : result1.keys()) {
            System.out.println(key);
        }
    }
}