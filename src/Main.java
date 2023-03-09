import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputString = "S E A R C H E X A M P L E";
        String newString = "O T H E R S E T";

        Scanner input = new Scanner(inputString);
        Scanner otherInput = new Scanner(newString);

        MathSet<String> set = new BSTSet<>();
        MathSet<String> otherSet = new BSTSet<>();

        while (input.hasNext()) {
            String key = input.next();
            set.add(key);
        }

        while (otherInput.hasNext()) {
            String key = otherInput.next();
            otherSet.add(key);
        }

        System.out.println(set.contains("E"));//should be true so something is wrong with my contains method
        System.out.println(set.isEmpty());//false as it should be
        System.out.println(set.size());//10
        System.out.println(otherSet.isEmpty());//false as it should be
        System.out.println(otherSet.size());//6--correct

        //System.out.println(set.intersection(otherSet));//ClassCastException error
        //System.out.println(set.union(otherSet));//ClassCastException error
        //System.out.println(set.difference(otherSet));/ClassCastException error
    }
}