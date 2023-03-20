import edu.greenriver.sdev333.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //write some code to test out your methods for your set
        //Create 2 sets
        // add items to each of the sets (some same, some different)

        //Test
        // set intersection
        // set union
        // set difference

        MathSet<String> set1 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Tina");

        MathSet<String> set2 = new BSTSet<>();

        // union set 1 and set 2, save into result 1
        MathSet<String> result1 = set1.union(set2);

        //print out keys from result1
        for(String key: result1.keys())
        {
            System.out.println(key);
        }


    }
}