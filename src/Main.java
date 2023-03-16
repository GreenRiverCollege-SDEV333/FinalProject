import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SCHSet;

public class Main {
    public static void main(String[] args) {

        //Test set this
        MathSet<Integer> testSetThis = new BSTSet<Integer>();
        testSetThis.add(5);
        testSetThis.add(8);
        testSetThis.add(34);
        testSetThis.add(45);
        testSetThis.add(13);
        testSetThis.add(76);
        testSetThis.add(23);
        testSetThis.add(2);
        testSetThis.add(55);
        testSetThis.add(31);

        //Test set other
        MathSet<Integer> testSetOther = new BSTSet<Integer>();
        testSetOther.add(5);
        testSetOther.add(8);
        testSetOther.add(34);
        testSetOther.add(89);
        testSetOther.add(13);
        testSetOther.add(76);
        testSetOther.add(29);
        testSetOther.add(2);
        testSetOther.add(25);
        testSetOther.add(39);

        //Test Union
        MathSet<Integer> testSetUnion = testSetThis.union(testSetOther);

        for (Integer currentKey: testSetUnion.keys()
             ) {
            System.out.print("BST Union: " + currentKey);
            System.out.print("\n");
        }

        //Test Difference
        MathSet<Integer> testSetDifference = testSetThis.difference(testSetOther);

        for (Integer currentKey: testSetDifference.keys()
        ) {
            System.out.print("BST Difference: " + currentKey);
            System.out.print("\n");
        }

        //Test Intersection
        MathSet<Integer> testSetIntersection = testSetThis.intersection(testSetOther);

        for (Integer currentKey: testSetIntersection.keys()
        ) {
            System.out.print("BST Intersection: " + currentKey);
            System.out.print("\n");
        }

//        SCH TEST

        //Test set this
        MathSet<Integer> testSetThisChain = new SCHSet<Integer>();
        testSetThisChain.add(5);
        testSetThisChain.add(8);
        testSetThisChain.add(34);
        testSetThisChain.add(45);
        testSetThisChain.add(13);
        testSetThisChain.add(76);
        testSetThisChain.add(23);
        testSetThisChain.add(2);
        testSetThisChain.add(55);
        testSetThisChain.add(31);

        //Test set other
        MathSet<Integer> testSetOtherChain = new SCHSet<Integer>();
        testSetOtherChain.add(5);
        testSetOtherChain.add(8);
        testSetOtherChain.add(34);
        testSetOtherChain.add(89);
        testSetOtherChain.add(13);
        testSetOtherChain.add(76);
        testSetOtherChain.add(29);
        testSetOtherChain.add(2);
        testSetOtherChain.add(25);
        testSetOtherChain.add(39);

        //Test Union
        MathSet<Integer> testSetUnionChain = testSetThisChain.union(testSetOtherChain);

        for (Integer currentKey: testSetUnionChain.keys()
        ) {
            System.out.print("SCH Union: " + currentKey);
            System.out.print("\n");
        }

        //Test Difference
        MathSet<Integer> testSetDifferenceChain = testSetThisChain.difference(testSetOtherChain);

        for (Integer currentKey: testSetDifferenceChain.keys()
        ) {
            System.out.print("SCH Difference: " + currentKey);
            System.out.print("\n");
        }

        //Test Inersection
        MathSet<Integer> testSetIntersectionChain = testSetThisChain.intersection(testSetOtherChain);

        for (Integer currentKey: testSetIntersectionChain.keys()
        ) {
            System.out.print("SCH Intersection: " + currentKey);
            System.out.print("\n");
        }

    }
}