package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{

    private Node root;

    public class Node {
        private KeyType key;
        private Node left;
        private Node right;
        private int N; // number of nodes in the subtree rooted here

        public Node(KeyType key, int N) {
            this.key = key;
            this.N = N;
        }
    }
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        root = add(root, key);
    }

    public Node add(Node x, KeyType key) {
        if (x == null) {
            return new Node(key, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = add(x.left, key);
        else if (cmp > 0) x.right = add(x.right, key);
        x.N = size(x.left) + size(x.right) + 1;
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

    public boolean contains(Node x, KeyType key) {
        if (x == null) {
            return false;
        }
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
        return root == null;
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

    private int size(Node current) {
        if (current == null){
            return 0;
        }
        else {
            return current.N;
        }
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
        // create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // iterate through all items in this
        for (KeyType currentKey : this.keys()) {
            // add items that are not in other
            if (!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }
        // add all items from other
        for (KeyType currentKey : other.keys()) {
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
        // create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // iterate through all items in this
        for (KeyType currentKey : this.keys()) {
            if (other.contains(currentKey)) {
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
        // create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // iterate through all items in this
        for (KeyType currentKey : this.keys()) {
            if (!other.contains(currentKey)) {
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
        return keys(min(), max());
    }

    public Iterable<KeyType> keys(KeyType lo, KeyType hi) {
        Queue<KeyType> queue = new Queue<KeyType>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<KeyType> queue, KeyType lo, KeyType hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    // pulled in min() and max() from BST to help keys()
    public KeyType min() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = min(root);
        return x.key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public KeyType max() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = max(root);
        return x.key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }
}
