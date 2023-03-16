package edu.greenriver.sdev333;

import java.util.Iterator;

public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {

    //node helper class
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

    //field
    private Node root;

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        root = add(root, key);
    }

    //helper method
    private Node add(Node x, KeyType key) {
        if(x==null) {
            return new Node(key, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = add(x.left, key);
        } else if (cmp > 0) {
            x.right = add(x.right, key);
        }
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
        return get(key) != null;
    }

    public KeyType get(KeyType key) {
        return get(root, key);
    }

    private KeyType get(Node x, KeyType key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            //go left
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.key;
        }
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
    private int size(Node x) {
        if(x == null) {
            return 0;
        } else {
            return x.N;
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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        for (KeyType currentKey : this.keys()) {
            result.add(currentKey);
        }

        for(KeyType currentKey : other.keys()) {
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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        /*
        //iterate (walk) through all items in this
        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
        while(itr.hasNext()) {
            KeyType currentKey = itr.next();
            if(!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }
        */

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
        Queue<KeyType> queue = new Queue<>();

        inOrder(root, queue);

        return queue;
    }
    private void inOrder(Node x, Queue<KeyType> queue) {
        if (x == null) {
            return;
        }
        inOrder(x.left, queue);
        queue.enqueue(x.key);
        inOrder(x.right, queue);
    }
}
