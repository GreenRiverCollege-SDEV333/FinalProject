package edu.greenriver.sdev333;
/*by Alex brenna
 * */
public class BST< KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{
    //fields
    private Node root;//top of treee
    //helper
    private class Node{
        private KeyType key;
        private Node left;
        private Node right;
        //number of nodes in the subtree rooted here
        private int num;

        public Node(KeyType key, int num){
            this.key = key;
            this.num = num;
        }
    }
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        root = put(root, key);
    }
    private Node put(Node current, KeyType key) {
        if (current == null) {
            return new Node(key, 1);
        }
        int CompareTO = key.compareTo(current.key);
        //go left (min/smaller number)
        if (CompareTO < 0) {
            current.left = put(current.left, key);
        }
        //go right (bigger/ max number)
        else if (CompareTO > 0) {
            current.right = put(current.right, key);
        } else {
            current.key = key;
        }
        //update N
        current.num = size(current.left) + size(current.right) + 1;
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
        return get(key) !=null;
    }
    //contains helper to clean up code
    public KeyType get(KeyType key) {
        return get(root,key);
    }
    //get helper to clean up code
    private KeyType  get(Node current, KeyType key){

        if (current == null){
            return null;
        }
        int cmp = key.compareTo(current.key);
        if(cmp < 0){
            return get(current.left, key);
        }
        else if (cmp > 0) {
            return get(current.right, key);
        }
        else{
            return current.key;
        }
    }
    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
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
    //size helper
    private int size(Node current){
        if(current == null){
            return 0;
        }
        else{
            return current.num;
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
        MathSet<KeyType> result = new BST<>();
        //all thats in A and B
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
        //holds result
        MathSet<KeyType> result = new BST<>();
        //whats in A and B at same time
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
        //holds result
        MathSet<KeyType> result = new BST<KeyType>();
        //whats in A but not in B
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
        //empty queue to hold results
        Queue<KeyType> queue = new Queue<>();
        //start the recursion collecting results in teh queue
        inOrder(root, queue);
        return queue;
    }

    //helper method for iterator
    private void inOrder(Node current, Queue<KeyType> q){
        if(current == null){
            //do nothing -- just exit
            return;
        }
        inOrder(current.left, q);
        q.enqueue(current.key);
        inOrder(current.right, q);
    }
}
