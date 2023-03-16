import java.util.Scanner;
import edu.greenriver.sdev333.BSTset;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeperateChainingHashTableSet;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //string created to put in set
        String testString = "I L O V E K U M A"; //9

        MathSet<String> testOne = new SeperateChainingHashTableSet<>();


        //scanner to add string to BSTSet
        Scanner input = new Scanner(testString);

        //testing isEmpty (true/false)
       // System.out.println(testOne.isEmpty());

        //loop to add the strings as keys to my testOne
        while(input.hasNext()){
            String key = input.next();
            testOne.add(key);
        }

        //Test for MathSet
        MathSet<String> testTwo = new SeperateChainingHashTableSet<>();
        testTwo.add("I");
        testTwo.add("t");
        testTwo.add("i");
        testTwo.add("S");
        testTwo.add("W");
        testTwo.add("h");
        testTwo.add("a");
        testTwo.add("T");
        testTwo.add(("i"));
        testTwo.add(("t"));
        testTwo.add(("i"));
        testTwo.add(("s"));


        //testing all methods in mathSet: return int
        System.out.println(testOne.size());

        //returns boolean
        System.out.println(testOne.contains("B"));
        System.out.println(testOne.contains("R"));
        System.out.println(testOne.contains("o"));
       //
//        System.out.println(testOne.isEmpty());
//        System.out.println();
//
        System.out.println("__________________________________");
//
//        System.out.println();
//        // and again on testTwo
        System.out.println(testTwo.size());
        System.out.println(testTwo.contains("A"));
        System.out.println(testTwo.contains("K"));
        System.out.println(testTwo.contains("a"));
        System.out.println(testTwo.contains("T"));
        System.out.println(testTwo.contains("z"));
//
//
//        System.out.println("__________________________________");
//
//        System.out.println();
//        // this is the testOne for union/intersection/different methods
        MathSet<String> unionTester = testOne.union(testTwo);
        System.out.println("union: testOne and testTwo");
        for (String element: unionTester.keys()){
            System.out.println(element);
        }
        System.out.println("__________________________________");
        System.out.println("intersection:  testOne and testTwo");
        MathSet<String> intersectionTester = testOne.intersection((testTwo));
        for (String element: intersectionTester.keys()){
            System.out.println(element);
        }
        System.out.println("__________________________________");

        System.out.println("difference: testOne and testTwo");
        MathSet<String> differenceTester = testOne.difference((testTwo));
        for (String element: differenceTester.keys()){
            System.out.println(element);
        }
    }
}
//IN CLASS
//
////
////        //Create 2 sets
////        MathSet<String> set1 = new BSTset<>();
////        // add items to each of the sets (some same, some different)
////        set1.add("Ken");
////        set1.add("Tina");
////
//        MathSet<String> set2 = new BSTset<>();
//
//
//        MathSet<String> result1 = set1.union(set2);
//        //test
//        for (String key : result1.keys()) {
//            System.out.println(key);
//        }

        //set intersection
        //set union
        //set difference

