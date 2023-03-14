package edu.greenriver.sdev333;

import java.util.Iterator;

/**
 * Kevin Stone
 * SDEV333: Final Project Part 1 - Implementing a Set
 *
 */
public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {

    // private helper class used throughout class
    private class Node {
        private KeyType key;
        private Node left;
        private Node right;
        private int N;

        public Node(KeyType key, int N) {
            this.key = key;
            this.N = N;
        }
    }

    // private field
    private Node root;

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        // starts the recursion
        root = addNode(root, key);
    }

    // private helper method used in class
    // however, Sets do not utilize values - only keys
    private Node addNode(Node current, KeyType key){
        // current is the root of the subtree we are looking at
        // we are now at where we are supposed to be
        if(current == null) {
            // create a new node
            return new Node(key, 1);
        }

        int cmp = key.compareTo(current.key);
        // cmp will be -1 if key < currrent.key
        // cmp will be 0 if key == current.key
        // cmp will be 1 if key > currrent.key

        // we need to go left
        if(cmp < 0) {
            current.left = addNode(current.left, key);
        }
        // we need to go right
        else if(cmp > 0) {
            current.right = addNode(current.right, key);
        }
        else {
            // key already exists in the set
            current.key = key;
        }

        // update the node's N - number of nodes in the subtree
        // size of my left + size of my right + myself
        current.N = size(current.left) + size(current.right) + 1;
        return current;
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {

        // start at beginning, and look at each node's
        // left and right
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            // cmp will be -1 if key < currrent.key
            // cmp will be 0 if key == current.key
            // cmp will be 1 if key > currrent.key

            // we need to go left
            if(cmp < 0) {
                current = current.left;
            }
            // we need to go right
            else if(cmp > 0) {
                current = current.right;
            }
            else {
                // key already exists in the set
                return true;
            }

        }
        return false;
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

    // private helper method used in class
    private int size(Node current) {
        if (current == null) {
            return 0;
        }
        else {
            return size(current.left) + size(current.right) + 1;
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

        // create an empty set to return
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // add each key to result set, then check the "otherSet"
        // for new keys to add
        for (KeyType key : this.keys()) {
            result.add(key);
        }

        // if key in "otherSet" is not in our resultSet - add to resultSet
        for (KeyType currentKey : other.keys()) {
            if (!result.contains(currentKey)) {
                result.add(currentKey);
            }
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
        // create an empty set to return
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // if our "otherSet" contains a key from our currentSet - add key to resultSet
        for(KeyType currentKey : this.keys()){
            if(other.contains(currentKey)) {
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
        // create an empty set to return
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // if key in setA (currentSet) is NOT in setB (otherSet) - add to resultSet
        for(KeyType currentKey : this.keys()){
            if(!other.contains(currentKey)){
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

        // create a new empty queue to hold my results
        Queue<KeyType> keyQueue = new Queue<>();

        // start the recursion, collecting results in the queue
        inorder(root, keyQueue);

        // when done, return the queue
        return keyQueue;
    }

    // private helper method used in class, using provided Queue class
    private void inorder(Node current, Queue<KeyType> q){
        if(current == null) {
            // do nothing - end the method
            return;
        }

        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);

    }
}
