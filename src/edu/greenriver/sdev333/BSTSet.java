package edu.greenriver.sdev333;

import java.util.Iterator;

/**
 * @author Katherine Watkins
 * SDEV 333
 * Final Project
 * @param <KeyType>
 */

public class BSTSet <KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{
    private Node root;
    private class Node{
        private KeyType key;
        private Node left;
        private Node right;
        private int N;

        public Node(KeyType key, int N){
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

    private Node add(Node current, KeyType key){
        if(current == null){
            return new Node (key, 1);
        }
        int cmp = key.compareTo(current.key);
        //go left
        if(cmp < 0){
            current.left = add(current.left, key);
        }
        //go right
        else if(cmp > 0){
            current.right = add(current.right, key);
        }
        else{
            current.key = key;
        }
        //update N
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
        for(KeyType currentKey: this.keys()){
            if(currentKey.equals(key)){
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
        return this.size() == 0;
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
    private int size(Node current){
        if(current == null){
            return 0;
        }
        else{
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
        MathSet<KeyType> result = new BSTSet<>();
        for (KeyType key : other.keys()) {
                result.add(key);
        }
        for (KeyType key : this.keys()) {
            result.add(key);
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
        MathSet<KeyType> result = new BSTSet<>();
        for (KeyType key : other.keys()) {
            if(this.contains(key)){
                result.add(key);
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
        //create empty set to hold result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        for (KeyType a: this.keys()) {
            if(!other.contains(a)){
                result.add(a);
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
        //empty queue to hold my result

        Queue<KeyType> queue = new Queue<>();
        //start recursion
        inOrder(root, queue);
        //when done return the queue
        return queue;
    }
    private void inOrder(Node current, Queue<KeyType> q){
        if(current == null){
            //do nothing - intentionally blank
            return;
        }

        inOrder(current.left, q);
        q.enqueue(current.key);
        inOrder(current.right, q);
    }
}
