import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeperateChainingHashTableSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /// okay both implementations work ken, just uncommen the one you want to use
        System.out.println("Hello world!");

        //string created to put in set
        String testString = "A E S T H E T I C ";

        //tester method
        //MathSet<String> tester = new BSTSet<String>();
        MathSet<String> tester = new SeperateChainingHashTableSet<>();


        //scanner to add string to BSTSet
        Scanner input = new Scanner(testString);

        //testing is empty before anything is added
        System.out.println(tester.isEmpty());

        //loop to add the strings as keys to my tester
        while(input.hasNext()){
            String key = input.next();
            tester.add(key);
        }

        //MathSet<String> otherTester = new BSTSet<String>();
        MathSet<String> otherTester = new SeperateChainingHashTableSet<>();
        otherTester.add("A");
        otherTester.add("a");
        otherTester.add("e");
        otherTester.add("E");
        otherTester.add("P");
        otherTester.add("T");
        otherTester.add("O");
        otherTester.add("P");
        otherTester.add(("i"));

        //testing all my methods
        System.out.println(tester.size());
        System.out.println(tester.contains("A"));
        System.out.println(tester.contains("T"));
        System.out.println(tester.contains("t"));
        System.out.println(tester.contains("p"));
        System.out.println(tester.isEmpty());
        System.out.println();

        System.out.println("//////////////////////////////////////////////");

        System.out.println();
        // and again on otherTester
        System.out.println(otherTester.size());
        System.out.println(otherTester.contains("A"));
        System.out.println(otherTester.contains("T"));
        System.out.println(otherTester.contains("t"));
        System.out.println(otherTester.contains("p"));
        System.out.println(otherTester.isEmpty());
        System.out.println();

        System.out.println("//////////////////////////////////////////////");

        System.out.println();
        // this is the tester for the 3 set specific methods
        MathSet<String> unionTester = tester.union(otherTester);
        System.out.println("union of tester and otherTester");
        for (String element: unionTester.keys()){
            System.out.println(element);
        }
        System.out.println();
        System.out.println("//////////////////////////////////////////////");
        System.out.println();

        System.out.println("intersection of tester and otherTester");
        MathSet<String> intersectionTester = tester.intersection((otherTester));
        for (String element: intersectionTester.keys()){
            System.out.println(element);
        }

        System.out.println();
        System.out.println("//////////////////////////////////////////////");
        System.out.println();

        System.out.println("difference of tester and otherTester");
        MathSet<String> differenceTester = tester.difference((otherTester));
        for (String element: differenceTester.keys()){
            System.out.println(element);
        }





    }
}