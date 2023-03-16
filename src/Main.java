import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeparateChainingHashTable;

public class Main {
    public static void main(String[] args) {

        System.out.println("BSTSet tests:");
        SeparateChainingHashTable<String> firstSet = new SeparateChainingHashTable<String>();
        SeparateChainingHashTable<String> secondSet = new SeparateChainingHashTable<String>();

        System.out.println("isEmpty before adding to firstSet: " + firstSet.isEmpty());
        firstSet.add("a");
        firstSet.add("b");
        firstSet.add("c");
        firstSet.add("d");
        secondSet.add("a");
        secondSet.add("e");
        secondSet.add("f");
        secondSet.add("g");
        secondSet.add("h");
        System.out.println("Size after adding to firstSet = " + firstSet.size());


        // display each key in BST sets
        System.out.println("isEmpty after adding string to set: " + firstSet.isEmpty() + " Size is now: " + firstSet.size());
        System.out.println("Iterable test - print each key in firstSet with forEach loop");
        for (String str : firstSet.keys()) {
            System.out.println(str);
        }
        System.out.println("Second set keys:");
        for (String str : secondSet.keys()) {
            System.out.println(str);
        }

        // Union testing
        System.out.println("Union:");
        MathSet<String> unionSet = firstSet.union(secondSet);
        for (String str : unionSet.keys()) {
            System.out.println(str);
        }
        // Intersection testing
        System.out.println("Intersection:");
        MathSet<String> intersectionSet = firstSet.intersection(secondSet);
        for (String str : intersectionSet.keys()) {
            System.out.println(str);
        }
        // Difference testing
        System.out.println("Difference:");
        MathSet<String> differenceSet = firstSet.difference(secondSet);
        for (String str : differenceSet.keys()) {
            System.out.println(str);
        }


    }
}