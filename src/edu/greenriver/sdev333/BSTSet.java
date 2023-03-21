package edu.greenriver.sdev333;

import java.util.Iterator;

//modify the header to take in a generic keyType
//and implement MathSet
public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType>  {
   //if we want to create a BST what needs to go in there? it needs nodes
    //we create a Node helper class
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

   //instance fields
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

    /*
        Helper method for add
     */
    private Node add(Node current, KeyType key) {
        if (current == null) {
            return new Node(key,1);
        }

        int cmp = key.compareTo(current.key);

        if(cmp < 0) {
            current.left = add(current.left, key);
        }
        else if (cmp > 0) {
            current.right = add(current.right, key);
        }
        /*else the else is not needed because if we have the key
            we dont need to do anything else
        {
            current.key = key;
        }*/

        current.N = size(current.left) + size(current.right) + 1;
        return current;
    }

    /**
     * Is the key in the set?
     * this method would need the get helper method to get a key.
     * essentially the same as the BST
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return get(key) != null;
    }

    /*
        get a key and check if it is in the set
     */
    public KeyType get(KeyType key) {
        return get(root, key);
    }

    /*
        Helper method for the getter
     */
    private KeyType get(Node current, KeyType key){
        //author uses x instead of current in the book
        if (current == null) {
            return null;
        }
        int cmp = key.compareTo(current.key);
        //go left
        if (cmp < 0) {
            return get(current.left, key);
        } else if (cmp > 0) { //go right
            return get(current.right, key);
        } else { //dont move return current
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
        return size() == 0;
    }

    /** DOUBLE CHECK THIS
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        return size(root);
    }

    // private helper method, we are getting the size at a particular root
    // looks at subtree of where current is.
    // for example, if current is blank then its size is what ever proceeds after
    private int size(Node current) {
        if (current == null) {
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
        //create a new set that will hold the result of all the items we want
        MathSet<KeyType> result = new BSTSet<KeyType>();
        //write a loop that walks through 'this'
        for (KeyType currentKey : this.keys()) {
            //for each key that is in this add it to result, take everything in keys and add it in
            result.add(currentKey); //the add method handles duplicates
        }

        //now we have to do the same for other
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
        //go through this (set A) and determine if the key is also in other (set B)
        //if it is then add key to the result

        //first create a new set named result
        MathSet<KeyType> result = new BSTSet<KeyType>();
        //now go through this (set A) and check if the key is in other (set B)
        for (KeyType currentKey : this.keys()){
            //if it is in other, add it to result
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
        //create and empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        //using the iterator way
        // iterate (walk through) all items in this
       /* Iterator<KeyType> itr = (Iterator<KeyType>) this.keys(); //go get my keys from this and cast it to the iterator
        while(itr.hasNext()){
            KeyType currentKey = itr.next(); //if it has a next, save it to a variable named currentKey
            //if the other contains it, we dont want to add it. so if it does not contain it, we add our currentKey
            if (!other.contains(currentKey)) {
                result.add(currentKey);
            }
        }*/

        //using a for each loop
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
        //create a new empty queue to hold my results
        Queue<KeyType> queue = new Queue<>();

        //start the recursion, collection the results in the queue
        inorder(root,queue);

        //when done, return queue
        return queue;
    }

    /**
     * Helper method for our iterable keys method
     */
    public void inorder(Node current, Queue<KeyType> q){
        if (current == null) {
            //if current = null do nothing
            return;
        }
        //prints the left subtree
        inorder(current.left, q);

        //add myself if to the queue
        q.enqueue(current.key);

        //prints the right subtree
        inorder(current.right, q);
    }

    /**
     * Method to help us with testing (only code that was helped with from tutor to help with testing)
     * @return string version of data in set
     */
    public String toString(){
        String print ="";
        for(KeyType key: keys()){
            print += key + ", ";
        }
        return print;
    }
}
