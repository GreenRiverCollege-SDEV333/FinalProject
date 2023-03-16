package edu.greenriver.sdev333;

import java.util.Iterator;

public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {
    //node helper class
    private class Node {
        private KeyType key;
        private Node left;
        private Node right;
        private int N;

        //field
        public Node(KeyType key, int N) {
            this.key = key;
            this.N = N;
        }
    }

    private Node root; // root of BST

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        root = add(root, key);
    }

    /**
     * Adds key to subtree rooted at x; returns subtree with key added
     */
    private Node add(Node x, KeyType key) {
        if (x == null) return new Node(key, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = add(x.left, key);
        else if (cmp > 0) x.right = add(x.right, key);
        else x.key = key;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return contains(root, key);
    }

    /**
     * Does the subtree rooted at x contain key?
     */
    private boolean contains(Node x, KeyType key) {
        if (x == null) return false;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return contains(x.left, key);
        else if (cmp > 0) return contains(x.right, key);
        else return true;
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
        return size(root);
    }

    /**
     * Number of nodes in subtree rooted at x; 0 if x is null
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
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
        for (KeyType key : keys()) {
            result.add(key);
        }
        for (KeyType key : other.keys()) {
            if (!contains(key)) {
                result.add(key);
            }
        }
        return result;
    }

    /**
     * Determine the intersection of this set with another specified set.
     * Returns A intersect B,

     * A intersect B = {key | A.contains(key) AND B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to intersect
     * @return the intersection of this set with other
     */
    @Override
    public MathSet intersection(MathSet other) {
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
    public MathSet difference(MathSet other) {
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();
        //iterate through all items in this set
        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
        while (itr.hasNext()) {
            KeyType currentKey = itr.next();
            if (!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }
        return result;
    }
    //using for each loop
    /*
    public MathSet difference(MathSet other) {
        MathSet<KeyType> result = new BSTSet<KeyType>();
        for (KeyType currentKey : this.keys()) {
            if (!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }
        return result;
    }
     */


    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable keys() {
        return null;
    }
}
