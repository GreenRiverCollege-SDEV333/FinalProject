package edu.greenriver.sdev333;

public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {

    // private helper class
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

    // field
    private Node root;
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        root = add(root,key);
    }

    private Node add(Node current, KeyType key) {
        if(current == null) {
            return new Node (key,1);
        }
        int cmp = key.compareTo(current.key);
        if(cmp < 0) {
            current.left = add(current.left, key);
        }
        if(cmp > 0) {
            current.right = add(current.right,key);
        }
        // increment N
        current.N = size(current.left) + size(current.right) +1;
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
        while(root!=null) {
            /// not sure what to put here
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

    // helper class for size
    private int size(Node current) {
        if(current == null) {
            return 0;
        }
        return current.N;
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
        MathSet<KeyType> union = new BSTSet<KeyType>();

        for(KeyType key : this.keys()) {
            union.add(key);
        }
        for(KeyType key : other.keys()) {
            union.add(key);
        }
        return union;
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

        /*
        //iterate (walk) through all the items in this
        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
        while(itr.hasNext()) {
            KeyType currentKey = itr.next();
            if (!other.contains(currentKey)) {
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
        return null;
    }
}
