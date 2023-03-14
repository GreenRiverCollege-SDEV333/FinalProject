package edu.greenriver.sdev333;

import java.util.Iterator;

public class BSTSet<KeyType> implements MathSet<KeyType> {
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

    private Node root;

    /**
     * @param key key to be added into the set
     */
    @Override
    public void add(Object key) {

    }

    /**
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(Object key) {
        return false;
    }

    /**
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * @param other specified set to union
     * @return the union of this set with other
     */
    @Override
    public MathSet union(MathSet other) {
        return null;
    }

    /**
     * @param other specified set to intersect
     * @return the intersection of this set with other
     */
    @Override
    public MathSet intersection(MathSet other) {
        return null;
    }

    /**
     * @param other specified set to difference
     * @return the difference of this set with other
     */
    @Override
    public MathSet difference(MathSet other) {
        MathSet<KeyType> result = new BSTSet<KeyType>();

        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();

        while (itr.hasNext()) {
            KeyType currentKey = itr.next();
            if (!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }

        return result;
    }

    /**
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable keys() {
        return null;
    }
}