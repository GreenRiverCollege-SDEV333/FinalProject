import edu.greenriver.sdev333.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        // TEST CODE FOR BSTSET //

        //create two sets
        //add items to each of the sets (some same. some different)
        MathSet<String> bstSet1 = new BSTSet<>();
        bstSet1.add("Ken");
        bstSet1.add("Tina");
        bstSet1.add("Josh");
        bstSet1.add("Tyler");
        bstSet1.add("Monroe");
        bstSet1.add("Snoop");

        MathSet<String> bstSet2 = new BSTSet<>();
        bstSet2.add("Tina");
        bstSet2.add("Tyler");
        bstSet2.add("Ken");
        bstSet2.add("Kelly");
        bstSet2.add("Zoe");

        //empty bstSet to test isEmpty()
        MathSet<String> emptyBSTSet = new BSTSet<>();

        System.out.println("BSTSet: ");

        System.out.println("bstSet1 Empty: " + bstSet1.isEmpty());
        System.out.println("bstSet2 Empty: " + bstSet2.isEmpty());
        System.out.println("emptyBSTSet Empty: " + emptyBSTSet.isEmpty());
        System.out.println("");

        System.out.println("bstSet1 size: " + bstSet1.size());
        System.out.println("bstSet2 size: " + bstSet2.size());
        System.out.println("");

        //tests
        //set intersection
        // intersect set 1 and set 2, save into intersResult
        MathSet<String> intersResult1 = bstSet1.intersection(bstSet2);

        //print out keys from intersResult
        System.out.println("Intersection results: ");
        for(String key : intersResult1.keys()) {
            System.out.println(key);
        }
        System.out.println("");

        //set union
        // union set 1 and set 2, save into unionResult
        MathSet<String> unionResult1 = bstSet1.union(bstSet2);

        //print out keys from unionResult
        System.out.println("Union results: ");
        for(String key : unionResult1.keys()) {
            System.out.println(key);
        }
        System.out.println("");

        //set difference
        // union set 1 and set 2, save into diffResult
        MathSet<String> diffResult1 = bstSet1.difference(bstSet2);

        //print out keys from diffResult
        System.out.println("Difference results: ");
        for(String key : diffResult1.keys()) {
            System.out.println(key);
        }
        System.out.println("");

        // TEST CODE FOR SEPARATECHAININGHASHSET //

        //create two sets
        //add items to each of the sets (some same. some different)
        MathSet<String> schSet1 = new SeparateChainingHashSet<>();
        schSet1.add("Ken");
        schSet1.add("Tina");
        schSet1.add("Josh");
        schSet1.add("Tyler");
        schSet1.add("Monroe");
        schSet1.add("Snoop");

        MathSet<String> schSet2 = new SeparateChainingHashSet<>();
        schSet2.add("Tina");
        schSet2.add("Tyler");
        schSet2.add("Ken");
        schSet2.add("Kelly");
        schSet2.add("Zoe");

        //empty schSet to test isEmpty()
        MathSet<String> emptySCHSet = new SeparateChainingHashSet<>();

        System.out.println("SeparateChainingHashSet: ");

        System.out.println("schSet1 Empty: " + schSet1.isEmpty());
        System.out.println("schSet2 Empty: " + schSet2.isEmpty());
        System.out.println("emptySCHSet Empty: " + emptySCHSet.isEmpty());
        System.out.println("");

        System.out.println("schSet1 size: " + schSet1.size());
        System.out.println("schSet2 size: " + schSet2.size());
        System.out.println("");

        //tests
        //set intersection
        // intersect set 1 and set 2, save into intersResult
        MathSet<String> intersResult2 = schSet1.intersection(schSet2);

        //print out keys from intersResult
        System.out.println("Intersection results: ");
        for(String key : intersResult2.keys()) {
            System.out.println(key);
        }
        System.out.println("");

        //set union
        // union set 1 and set 2, save into unionResult
        MathSet<String> unionResult2 = schSet1.union(schSet2);

        //print out keys from unionResult
        System.out.println("Union results: ");
        for(String key : unionResult2.keys()) {
            System.out.println(key);
        }
        System.out.println("");

        //set difference
        // union set 1 and set 2, save into diffResult
        MathSet<String> diffResult2 = schSet1.difference(schSet2);

        //print out keys from diffResult
        System.out.println("Difference results: ");
        for(String key : diffResult2.keys()) {
            System.out.println(key);
        }
        System.out.println("");

    }
}