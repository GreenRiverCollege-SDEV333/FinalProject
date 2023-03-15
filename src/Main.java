/**
 * @Author Ron Nguyen
 * Date: March 15, 2023
 * SDEV 333
 * Professor: Ken Hang
 * File name: Main.java
 * File Description: This file contains test code for MathSet of both implement of
 * SeparateChainingHashST and BST(Binary Search Tree)
 */

import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SeparateChainingHashSet;

public class Main {
    public static void main(String[] args) {
        MathSet<String> bstSet1 = new BSTSet<>();
        bstSet1.add("A");
        bstSet1.add("B");
        bstSet1.add("C");
        bstSet1.add("D");
        System.out.print("BSTSet 1: ");
        for (String s : bstSet1.keys()){
            System.out.print(s + " ");
        }
        MathSet<String> bstSet2 = new BSTSet<>();
        bstSet2.add("C");
        bstSet2.add("D");
        bstSet2.add("E");
        bstSet2.add("F");
        System.out.print("\nBSTSet 2: ");
        for (String s : bstSet2.keys()){
            System.out.print(s + " ");
        }
        System.out.println("\nBSTSet 1 size: " + bstSet1.size());
        System.out.println("BSTSet 1 is empty? "+ bstSet1.isEmpty());
        System.out.println("BSTSet 1 contain letter A?: " + bstSet1.contains("A"));
        System.out.println("BSTSet 2 contain letter A?: " + bstSet2.contains("A"));

        // Test Different method
        MathSet<String> BSTDifferent = new BSTSet<>();
        BSTDifferent = bstSet1.difference(bstSet2);
        System.out.print("Different of BSTSet 1 to BSTSet 2: ");
        for (String s : BSTDifferent.keys()){
            System.out.print(s + " ");
        }

        // Test Union method
        MathSet<String> BSTUnion= new BSTSet<>();
        BSTUnion = bstSet1.union(bstSet2);
        System.out.print("\nBSTSet 1 Union BSTSet 2: ");
        for (String s : BSTUnion.keys()){
            System.out.print(s + " ");
        }

        //Test Intersection method
        MathSet<String> BSTIntersection= new BSTSet<>();
        BSTIntersection = bstSet1.intersection(bstSet2);
        System.out.print("\nBSTSet 1 Intersect BSTSet 2: ");
        for (String s : BSTIntersection.keys()){
            System.out.print(s + " ");
        }
        //HASHSET
        System.out.println("\n==========================================================");
        MathSet<String> hashSet1 = new SeparateChainingHashSet<>(10);
        hashSet1.add("Green");
        hashSet1.add("Red");
        hashSet1.add("Orange");
        hashSet1.add("Yellow");
        System.out.print("HashSet 1: ");
        for (String s : hashSet1.keys()){
            System.out.print(s + " ");
        }
        MathSet<String> hashSet2 = new BSTSet<>();
        hashSet2.add("Red");
        hashSet2.add("Yellow");
        hashSet2.add("Blue");
        hashSet2.add("Cyan");
        System.out.print("\nHashSet 2: ");
        for (String s : hashSet2.keys()){
            System.out.print(s + " ");
        }
        System.out.println("\nHashSet 1 size is: "+ hashSet1.size());
        System.out.println("Is HashSet 1 empty? " + hashSet1.isEmpty());
        System.out.println("Does HashSet 1 contain color Blue? " + hashSet1.contains("Blue"));
        System.out.println("Does HashSet 2 contain color Blue? " + hashSet2.contains("Blue"));

        // Test Different method
        MathSet<String> SeparateChainingHashDifferent;
        SeparateChainingHashDifferent = hashSet1.difference(hashSet2);
        System.out.print("Different of HashSet 1 to HashSet 2: ");
        for (String s : SeparateChainingHashDifferent.keys()){
            System.out.print(s + " ");
        }

        // Test Union method
        MathSet<String> SeparateChainingHashUnion;
        SeparateChainingHashUnion = hashSet1.union(hashSet2);
        System.out.print("\nHashSet 1 Union HashSet 2: ");
        for (String s : SeparateChainingHashUnion.keys()){
            System.out.print(s + " ");
        }

        //Test Intersection method
        MathSet<String> SeparateChainingHashIntersection;
        SeparateChainingHashIntersection = hashSet1.intersection(hashSet2);
        System.out.print("\nHashSet 1 Intersect HashSet 2: ");
        for (String s : SeparateChainingHashIntersection.keys()){
            System.out.print(s + " ");
        }
    }
}