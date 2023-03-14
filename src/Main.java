import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.HashSet;
import edu.greenriver.sdev333.MathSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputString = "S E A R C H E X A M P L E";
        String newString = "O T H E R S E T";

        Scanner input = new Scanner(inputString);
        Scanner otherInput = new Scanner(newString);

        //This is currently being used to test HashSet, but can be changed to BSTSet to test that class
        MathSet<String> set = new HashSet<>();
        MathSet<String> otherSet = new HashSet<>();

        while (input.hasNext()) {
            String key = input.next();
            set.add(key);
        }

        //BST should print out in order A C E H L M P R S X
        System.out.println("Set " + set);// Hash: in no particular order: S E A R C H X M P L

        while (otherInput.hasNext()) {
            String key = otherInput.next();
            otherSet.add(key);
        }

        System.out.println("other Set = " + otherSet);// O T H E R S

        System.out.println(set.contains("E"));//should be true
        System.out.println(set.isEmpty());//false as it should be
        System.out.println(set.size());//10
        System.out.println(otherSet.isEmpty());//false as it should be
        System.out.println(otherSet.size());//6--correct

        //These should print in order for BST, not for Hash but still contain the same letters
        System.out.println("intersection " + set.intersection(otherSet));//should be E H R S
        System.out.println("union " + set.union(otherSet));// should be A C E H L M O P R S T X
        System.out.println("difference " + set.difference(otherSet)); // A C L M P X
        System.out.println("other difference " + otherSet.difference(set)); //O T

    }
}