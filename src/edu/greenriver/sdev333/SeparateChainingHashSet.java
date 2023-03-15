/**
 * @Author Ron Nguyen
 * Date: March 15, 2023
 * SDEV 333
 * Professor: Ken Hang
 * File name: SeparateChainingHashSet.java
 * File Description: This file is an implement of MathSet using SeparateChainingHashST
 */

package edu.greenriver.sdev333;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class SeparateChainingHashSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {
    private int M; // M is the number of buckets (or pile)
    private LinkedList<KeyType>[] st; // array of ST objects

    public SeparateChainingHashSet(int M){
        // Take their number of buckets, save it into my filed
        this.M = M;
        st =  new LinkedList[M];
        for (int i = 0; i < M; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private int hash(KeyType key){
        // hash function = they give me a key, I return an int (bucket #, array index)
        return (key.hashCode() & 0x7fffffff) % M;
    }



    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key);
        // put the key and value into that bucket
        st[index].add(key);
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        int index = hash(key);
        return st[index].contains(key);
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += st[i].size();
        }
        return sum;
    }

    /**
     * Determine the union of this set with another specified set.
     * Returns A union B, where A is this set, B is other set.
     * A union B = {key | A.contains(key) OR B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to union
     * @return the union of this set with other
     */
    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        // Create an empty set that hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        //add all element from this set
        for (KeyType currentKey : this.keys()){
            result.add(currentKey);
        }
        //add all element from the other set
        for (KeyType currentKey : other.keys()){
            result.add(currentKey);
        }
        return result;
    }

    /**
     * Determine the intersection of this set with another specified set.
     * Returns A intersect B, where A is this set, B is other set.
     * A intersect B = {key | A.contains(key) AND B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to intersect
     * @return the intersection of this set with other
     */
    @Override
    public MathSet<KeyType> intersection(MathSet<KeyType> other) {
        // Create an empty set that hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        for (KeyType currentKey : this.keys()){
            // if the key contains in the other set, add to result set
            if (other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
    }

    /**
     * Determine the difference of this set with another specified set.
     * Returns A difference B, where A is this set, B is other set.
     * A difference B = {key | A.contains(key) AND !B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to difference
     * @return the difference of this set with other
     */
    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        // Create an empty set that hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // iterate (walk through all items in this)
//        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
//        while(itr.hasNext()){
//            KeyType currentKey = itr.next();
//            if (!other.contains(currentKey)){
//                result.add(currentKey);
//            }
//        }

        //foreach loop
        for (KeyType currentKey : this.keys()){
            if (!other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        LinkedList<KeyType> list = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (KeyType key : st[i]) {
                list.add(key);
            }
        }
        return list;
    }
}
