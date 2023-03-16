package edu.greenriver.sdev333;

import java.util.Iterator;

public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{
    private class Node {
        private KeyType key;
        private Node left;
        private Node right;
        private int N;

        public Node(KeyType key, int N){
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
//    @Override
//    public void add(KeyType key) {
//
//    }
    @Override
    public void add(KeyType key) {
        root = put(root, key);
    }

    public Node put(Node current, KeyType key){
        //current is null create a new node n = 1
        if(current == null){
            return new Node(key,1);
        }
        //compare key past in to current key
        int cmp = key.compareTo(current.key);

        //if cmp less than 0 then put on left, if greater than 0 put on right else change current val
        if (cmp < 0 ) {
            current.left = put(current.left, key);
        } else if (cmp > 0 ){
            current.right = put(current.right, key);
        }
        //increment n
        current.N = size(current.left) + size(current.right) + 1;
        return current;
    }

    /**
     * Returns the value associated with the given key in the set.
     *
     * @param key the key to look up
     * @return the value associated with the given key, or null if the key is not found in the set
     */
    public KeyType get(KeyType key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.key;
            }
        }
        return null;
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {

        for (KeyType currentKey : this.keys()) {
            if(currentKey == key){
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
        if(root.N == 0){
            return true;
        }
        return false;
    }

    /**
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        if (root == null){
            return 0;
        } else {
            return root.N;
        }
    }

    private int size(Node current) {
        if (current == null){
            return 0;
        } else {
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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();


        for (KeyType currentKey: this.keys()) {
            if(!result.contains(currentKey)) {
                result.add(currentKey);
            }
        }

        for (KeyType currentKey: other.keys()) {
            if(!result.contains(currentKey)) {
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
        MathSet<KeyType> result = new BSTSet<KeyType>();
        for (KeyType currentKey : this.keys()) {
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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();


        for (KeyType currentKey: this.keys()) {
            if(!other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
        //Iterate through all of this
//        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
//        while (itr.hasNext()){
//            KeyType currentKey = itr.next();
//            if (!other.contains(currentKey)) {
//                result.add(currentKey);
//            }
//        }
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<KeyType>();
        inorder(root, queue);
        return new Iterable<KeyType>() {
            public Iterator<KeyType> iterator() {
                return queue.iterator();
            }
        };
    }

    private void inorder(Node current, Queue<KeyType> queue) {
        if (current == null) {
            return;
        }
        inorder(current.left, queue);
        queue.enqueue(current.key);
        inorder(current.right, queue);
    }
}
