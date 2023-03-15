import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeparateChainingHashTable;
import java.security.Key;

public class Main {
    public static void main(String[] args) {

        String testChar = "P O O P I E";

        MathSet<String> testset = new SeparateChainingHashTableSet<>();

        Scanner input = new Scanner(testChar);

        System.out.println(testset.isEmpty());

        while(input.hasNext()){
            String key = input.next();
            testset.add(key);
        }

        System.out.println(testset.size());
        System.out.println(testset.contains("P"));
        System.out.println(testset.contains("O"));
        System.out.println(testset.contains("O"));
        System.out.println(testset.contains("P"));
        System.out.println(testset.isEmpty());
        System.out.println();

    }

    MathSet<String> testset2 = new SeparateChainingHashTable<>();

    testset2.add("P");
    testset2.add("e");
    testset2.add("e"); 
    testset2.add("P"); 
    testset2.add("I");
    testset2.add("E"); 

    System.out.println("testset.union(testset2): " + testset.union(testset2));
    System.out.println("testset.intersection(testset2): " + testset.intersection(testset2));
    System.out.println("testset.difference(testset2): " + testset.difference(testset2));



}