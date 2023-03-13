package edu.greenriver.sdev333;
import java.util.*;
public class BSTSet<KeyType extends Comparable <KeyType>> implements MathSet<KeyType>{

    private Node root;


    //helper class
    private class Node {
        private KeyType key;

        private Node left;
        private Node right;
        private int N; // Number of Nodes in the subtree rooted here

        public Node(KeyType key,  int N){
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
        root = add(root,key);

    }

    private Node add( Node current, KeyType key) {
        //current is the root of the subtree we are looking at

        //where we are supposed to be
        if (current == null) {
            return new Node(key, 1);
        }

        int cmp = key.compareTo(current.key);
        // cmp will be -1(negative) if key < current.key
        //cmp will be 0(zero) if the key == current.key
        // cmp will be +1(positive) if key > current.key
        if (cmp < 0) {
            //go left
            current.left = add(current.left, key);

        } else if (cmp > 0) {
            //go right\
            current.right = add(current.right, key);
        } else {
            //key already exists
            current.key = key;
        }

        current.N = size(current.left) + size(current.right) + 1;

        return current;

    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node current){
        if(current == null){
            return 0;
        } else {
            return size(current.left) + size(current.right) + 1;
        }
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {


            //if someone gives me a key, i want to find the value for that key
            Node current = root;
            while(current != null){
                int cmp = key.compareTo(current.key);
                //compareTo returns neg, zero, pos

                if(cmp < 0){
                    current = current.left;
                }else if(cmp > 0){
                    current = current.right;
                }else {
                    return true;
                }
            }// end of the while loop

            return false;
        }


    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return root == null || root.N == 0;
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
        MathSet<KeyType> result = new BSTSet<KeyType>();

        //add all the elements of this se to the result set
        for(KeyType currentKey : this.keys()){
                result.add(currentKey);
        }

        // add elements of the other set to the result set if they are not already in the result set
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
        MathSet<KeyType> result = new BSTSet<KeyType>();

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

        //create an empty set that will hold a result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        for(KeyType currentKey : this.keys()){
            if(!other.contains(currentKey)){
                result.add(currentKey);
            }
        }

        return result;



        //iterator version
//       //iterate(walk through) all items in this
//        Iterator<KeyType> itr = (Iterator<KeyType>)this.keys();
//        while(itr.hasNext()){
//            KeyType currentKey = itr.next();
//            if(!other.contains(currentKey)){
//                result.add(currentKey);
//            }
//        }
//
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();
        //start the recursion, collecting the results in the queue
        inorder(root,queue);
        //when done, return the queue
        return queue;
    }

    private void inorder(Node current,Queue<KeyType> q){
        if (current == null){
            // do nothing - intentionally blank
            return;
        }

        inorder(current.left,q);
        q.enqueue(current.key);
        inorder(current.right,q);
    }
}
