package edu.greenriver.sdev333;
//page 398

import java.security.Key;
import java.util.Iterator;

public class BSTSet<KeyType> implements MathSet<KeyType> {

    private class Node {
        private KeyType key;
        private Node left;
        private Node right;
        private int N;
        //but this one dont have a valuetype

        public Node(KeyType key, int N) {
            this.key = key;
            this.N = N;
        }

    }

    private Node root;

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        //same code
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return false;
        //same code
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
        //same code?
    }

    /**
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        return 0;
        //same code??
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

        MathSet<KeyType> result = new BSTSet<KeyType>();
        for (KeyType currentKey : this.keys()){
                result.add(currentKey);
        }

        //same strategy for other ones
        //almost same code but change the if
        return result;
        //return null;
        //?????
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
        return null;
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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // iterate (walk) through all items in this
//        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
//        while (itr.hasNext()) {
//            KeyType currentKey = itr.next();
//            if (other.contains(currentKey)) {
//                result.add(currentKey);
//            }
//        }
//

        for (KeyType currentKey : this.keys()){
            if (!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }

        //same strategy for other ones
        return result;
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        return null;
    }
}
