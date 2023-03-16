import edu.greenriver.sdev333.*;

/**
 * @author Bao Huynh
 * Date: 03/15/2023
 * Class: SDEV333
 * FINAL PROJECT
 */
public class Main {
    public static void main(String[] args) {
        //Create 2 sets
        // add items to each of the sets (some same, some different)
        //Test
        //set intersection
        //set union
        //set different

        MathSet<String> set1 = new BSTSet<>();
        MathSet<String> set2 = new BSTSet<>();

        //add elements to the sets
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("5");

        set2.add("1");
        set2.add("6");
        set2.add("7");

        System.out.print("SET A: ");
        for(String num :  set1.keys()){
            System.out.print(num + " ");
        }


        System.out.print("\nSET B: ");
        for(String num :  set2.keys()){
            System.out.print(num + " ");
        }

        //Test contains
        System.out.println("\nSET A contains number 1? " + set1.contains("1"));
        System.out.println("SET B contains number 1? " + set2.contains("1"));

        //Test size
        System.out.println("SET A size: " + set1.size());
        System.out.println("SET B size: " + set2.size());

        //Test isEmpty
        System.out.println("SET A empty? " + set1.isEmpty());
        System.out.println("SET B empty? " + set2.isEmpty());

        //Test Union
        //union set a and set b, save into result1
        MathSet<String> result1 = set1.union(set2);
        System.out.print("UNION SET A and SET B: ");
        for (String num : result1.keys()){
            System.out.print(num + " ");
        }

        //Test Intersection
        MathSet<String> result2 = set1.intersection(set2);
        System.out.print("\nINTERSECTION SET A and SET B: ");
        for (String num : result2.keys()){
            System.out.print(num + " ");
        }

        //Test Different
        MathSet<String> result3 = set1.difference(set2);
        System.out.print("\nDIFFERENCE SET A and SET B: ");
        for (String num : result3.keys()){
            System.out.print(num + " ");
        }

        MathSet<String> result4 = set2.difference(set1);
        System.out.print("\nDIFFERENCE SET B and SET A: ");
        for (String num : result4.keys()){
            System.out.print(num + " ");
        }

        System.out.println("\n------------------------------------------");
        MathSet<String> set3 = new SeparateChainingHashTable<>(20);
        MathSet<String> set4 = new BSTSet<>();

        set3.add("Dog");
        set3.add("Cat");
        set3.add("Chicken");

        set4.add("Fish");
        set4.add("Pig");
        set4.add("Wolf");
        set4.add("Chicken");
        set4.add("Bird");

        System.out.print("SET C: ");
        for(String num :  set3.keys()){
            System.out.print(num + " ");
        }


        System.out.print("\nSET D: ");
        for(String num :  set4.keys()){
            System.out.print(num + " ");
        }

        //Test contains
        System.out.println("\nSET C contains Fish? " + set3.contains("Fish"));
        System.out.println("SET D contains Fish? " + set4.contains("Fish"));

        //Test size
        System.out.println("SET C size: " + set3.size());
        System.out.println("SET D size: " + set4.size());

        //Test isEmpty
        System.out.println("SET C empty? " + set3.isEmpty());
        System.out.println("SET D empty? " + set4.isEmpty());

        //Test Union
        //union set c and set d, save into result5
        MathSet<String> result5 = set3.union(set4);
        System.out.print("UNION SET C and SET D: ");
        for (String num : result5.keys()){
            System.out.print(num + " ");
        }

        //Test Intersection
        MathSet<String> result6 = set3.intersection(set4);
        System.out.print("\nINTERSECTION SET C and SET D: ");
        for (String num : result6.keys()){
            System.out.print(num + " ");
        }

        //Test Different
        MathSet<String> result7 = set3.difference(set4);
        System.out.print("\nDIFFERENCE SET C and SET D: ");
        for (String num : result7.keys()){
            System.out.print(num + " ");
        }

        MathSet<String> result8 = set4.difference(set3);
        System.out.print("\nDIFFERENCE SET D and SET C: ");
        for (String num : result8.keys()){
            System.out.print(num + " ");
        }




    }
}