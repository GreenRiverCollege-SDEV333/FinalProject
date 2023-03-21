import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.HashSet;
import edu.greenriver.sdev333.MathSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //creating the string to test out
        String testString = "T H I S S E T A B C";
        String newString = "O T H E R S E T D E F";

        // two sets that we are testing
        MathSet<String> thisSet = new HashSet<>();
        MathSet<String> otherSet = new HashSet<>();

        //creating scanners to add the strings created above to the sets created
        Scanner input = new Scanner(testString);
        Scanner otherInput = new Scanner(newString);

        //adding the strings as keys to thisSet
        while (input.hasNext()) {
            String key = input.next();
            thisSet.add(key);
        }

        //printing out the first set
        System.out.println("Set: " + thisSet);

        //repeating the process for otherSet
        while (otherInput.hasNext()) {
            String key = otherInput.next();
            otherSet.add(key);
        }
        System.out.println("other set: " + otherSet);

        //Testing all the different methods ------------------

        //if key is contained, true will be printed out
        System.out.println(thisSet.contains("S"));
        System.out.println(otherSet.contains("O"));
        // the size of the set will be printed, an int will be returned
        System.out.println(thisSet.size());
        System.out.println(otherSet.size());
        //the set has keys in it therefor it is not empty to false should be returned
        System.out.println(thisSet.isEmpty());
        System.out.println(otherSet.isEmpty());
        // adding extra keys to our sets
        thisSet.add("Y");
        otherSet.add("Z");
        System.out.println("this: " + thisSet);
        System.out.println("other: " + otherSet);


        //Testing the unique methods in a set -----------------------
        System.out.println("intersection " + thisSet.intersection(otherSet));
        System.out.println("union " + thisSet.union(otherSet));
        System.out.println("difference " + thisSet.difference(otherSet));


    }
}