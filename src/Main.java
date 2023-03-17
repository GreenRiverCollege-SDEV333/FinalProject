import edu.greenriver.sdev333.*;

//Concepts
//
//        A set is effectively the same as a map (symbol table) except there are only keys (instead of both keys and values in a map).
//        A set does not allow duplicates
//        A set is a concept from mathematics: it's a mathematical object.
//        Integers are a mathematical object and it consists of a value and allowable operations (add, subtract, multiply, divide, etc.)
//        Sets are a mathematical object and it consists of a collection of values (elements or keys) and allowable operations (contains, union, intersection, difference, etc.)
//        To Do
//
//        Create two classes that implements the MathSet interface, which represents a mathematical set.
//        Write some test code in main that tests all of the set operations (perhaps create a MathSet<String> or a MathSet<Integer>) for both implementations.
//        Credit Levels
//
//        Full credit if you have:
//        One implementation using a Binary Search Tree (BST) or Red Black Balanced Binary Search Tree
//        One implementation using a Separate Chaining Hash Table
/*by Alex brenna
* */
public class Main {
    public static void main(String[] args) {

        MathSet<String> one = new SeparateChainingHashTable<>();
        System.out.println("Testing SeparateChainingHashTable isEmpty");
        System.out.println(one.isEmpty());
        one.add("1");
        one.add("2");
        one.add("3");
        one.add("5");
        one.add("4");
        System.out.println(one.isEmpty());

        System.out.println("Testing SeparateChainingHashTable size() ");
        System.out.println(one.size());

        MathSet<String> two = new SeparateChainingHashTable<>();
        two.add("7");
        two.add("5");
        two.add("2");
        two.add("8");
        two.add("1");
        two.add("0");
        System.out.println("Testing SeparateChainingHashTable contains() ");
        System.out.println(one.contains("1"));
        System.out.println(one.contains("7"));
        System.out.println("Testing SeparateChainingHashTable union() ");
        MathSet<String> result1 = one.union(two);
        for (String a: result1.keys()) {
            System.out.println(a);
        }
        System.out.println("Testing SeparateChainingHashTable intersection() ");
        MathSet<String> result2 = one.intersection(two);
        for (String a: result2.keys()) {
            System.out.println(a);
        }
        System.out.println("Testing SeparateChainingHashTable difference() ");
        MathSet<String> result3 = one.difference(two);
        for (String a: result3.keys()) {
            System.out.println(a);
        }
    }
}