import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeparateChainingHashSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputString = "S E A R C H E X A M P L E";
        String inputStringTwo = "F A K E E X A M P L E";

        Scanner input = new Scanner(inputString);
        Scanner inputTwo = new Scanner(inputStringTwo);

        //MathSet<String> ms = new SeparateChainingHashSet<String>();
        //MathSet<String> otherMS = new SeparateChainingHashSet<>();
        MathSet<String> ms = new BSTSet<>();
        MathSet<String> otherMS = new BSTSet<>();

        // isEmpty test before adding anything
        System.out.println(ms.isEmpty());

        // add method tests
        while(input.hasNext()) {
            String key = input.next();
            ms.add(key);
        }
        while(inputTwo.hasNext()) {
            String key = inputTwo.next();
            otherMS.add(key);
        }
        System.out.println();

        // isEmpty test after adding
        System.out.println(ms.isEmpty());
        System.out.println();

        // keys tests
        for (String s : ms.keys()) {
            System.out.println(s);
        }
        System.out.println();

        //contains tests
        System.out.println("Contains S: " + ms.contains("S"));
        System.out.println("Contains Y: " + ms.contains("Y"));
        System.out.println();

        // union intersect and difference tests
        MathSet<String> union = ms.union(otherMS);
        System.out.println("union");
        for (String s : union.keys()) {
            System.out.println(s);
        }
        System.out.println();

        MathSet<String> intersect = ms.intersection(otherMS);
        System.out.println("intersection");
        for (String s : intersect.keys()) {
            System.out.println(s);
        }
        System.out.println();

        MathSet<String> diff = ms.difference(otherMS);
        System.out.println("difference");
        for (String s : diff.keys()) {
            System.out.println(s);
        }
        System.out.println();
    }
}