package edu.greenriver.sdev333;
import java.util.Iterator;

/**
 * This class is a BST implementation of the MathSet Interface
 * @author: Jasmine David
 * @param <KeyType>
 */
public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{
    // node helper class
    private class Node {
        private KeyType key;
        private Node right;
        private Node left;
        private int N;

        public Node (KeyType key, int N) {
            this.key = key;
            this.N = N;
        }

    }

    // fields
    private Node root;

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        // use put
        root = put(root, key);

    }

    // helper method for add method
    private Node put(Node current, KeyType key){
        // current is the root of the subtree we are looking at
        // we are at where we are supposed to be - current is null
        if(current == null){
            // create a new node and return it
            return new Node(key, 1);
        }

        // compare value of root (current) to the value of what we want to insert
        int cmp = key.compareTo(current.key);

        // cmp will be -1 (negative) if key < current.key
        // cmp will be 0 (zero) if key == current.key
        // cmp will be +1 (positive) if key > current.key
        // go left
        if (cmp < 0){
            current.left = put(current.left, key);
        }
        // go right
        else if (cmp > 0){
            current.right = put(current.right, key);
        }
        // key already exists
        else {
            current.key = key;

        }
        // update the nodes N - number of nodes in the subtree
        //            size of left + size of right + myself
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
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            // compareTo returns neg, zero, pos number
            // if key is less than current key; return negative number
            // if key is more than current key; returns positive number
            // if key is equal to current key; returns true

            if (cmp < 0) {
                current = current.left; // go to left of root
            }
            else if (cmp > 0) {
                current = current.right; // go to right of root
            }
            else if (cmp == 0){
                return true;
            }
        } // end of while loop
        return false;
    }


    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0 || root == null;
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

    // helper method for size
    private int size(Node current) {
        if (current == null ) {
            return 0;
        }
        else {
            return current.N;
        }

    }

    /**
     *
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

        // add keys from other set
        for (KeyType currentKey : other.keys()) {
            result.add(currentKey);
        }
        // add keys from this set
        for (KeyType currentKey : this.keys()) {
            result.add(currentKey);
        }
        // return the union
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
        MathSet<KeyType> result = new BSTSet<KeyType>();

        // add key to result ONLY if the key is also in the other set
        for (KeyType currentKey : this.keys()) {
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
        // create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

//        // iterate (walk) through all items in this
//        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
//        while(itr.hasNext()) {
//            KeyType currentKey = itr.next();
//            if (!other.contains(currentKey)) {
//                result.add(currentKey);
//            }
//        }

        // for each loop implementation of code above ^^
        // add key to this set if it is NOT in other set
        for (KeyType currentKey : this.keys()) {
            if(!other.contains(currentKey)) {
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
        // used code from the tree implementation of bst from hw
        // create a new empty queue to hold my results
        Queue<KeyType> queue = new Queue<>();

        // start the recursion, collecting results in the queue
        inorder(root, queue);

        // when done, return the queue
        return queue;
    }

    // helper method for keys
    private void inorder(Node current, Queue<KeyType> q) {
        if (current == null) {
            // do nothing, end the method immediately
            return;

        }
        inorder(current.left, q); // prints left subtree
        q.enqueue(current.key); // prints myself
        inorder(current.right, q); // prints right subtree
    }
}
