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

        MathSet<String> set1 = new HashSet<>();
        set1.add("Ken");
        set1.add("Tina");
        set1.add("Tyler");

        MathSet<String> set2 = new HashSet<>();
        set2.add("Ken");
        set2.add("Josh");
        set2.add("Tina");

        // union set 1 and set 2, save into result 1
        MathSet<String> result1 = set1.union(set2);
        //print out keys from result1
        for(String key: result1.keys())
        {
            System.out.println(key);
        }
        System.out.println();
        result1 = set1.intersection(set2);
        //print out keys from result1
        for(String key: result1.keys())
        {
            System.out.println(key);
        }
        System.out.println();
        result1 = set1.difference(set2);
        //print out keys from result1
        for(String key: result1.keys())
        {
            System.out.println(key);
        }


        MathSet<String> set11 = new BSTSet<>();
        set11.add("A");
        set11.add("B");
        set11.add("C");

        MathSet<String> set22 = new BSTSet<>();
        set22.add("C");
        set22.add("D");
        set22.add("E");
        set22.add("F");

        // union set 11 and set 22, save into result 11
        MathSet<String> result11 = set11.union(set22);
        //print out keys from result11
        for(String key: result11.keys())
        {
            System.out.println(key);
        }
        System.out.println();
        result11 = set11.intersection(set22);
        //print out keys from result11
        for(String key: result11.keys())
        {
            System.out.println(key);
        }
        System.out.println();
        result11 = set11.difference(set22);
        //print out keys from result11
        for(String key: result11.keys())
        {
            System.out.println(key);
        }
    }
}