package edu.greenriver.sdev333;

import java.util.Iterator;

// page 398
public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType>
{
    private class Node{
        private KeyType key;
        private Node left;
        private Node right;
        private int N ;

        public Node(KeyType key, int N)
        {
            this.key = key;
            this.N = N ;
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
    public void add(KeyType key)
    {
        root = put(root,key);
    }

    private Node put(Node current, KeyType key) {
        //current is the root of the subtree we are looking at

        //we are at where we are supposed to be
        if (current == null)
        {
            return new Node(key, 1);
        }

        int cmp = key.compareTo(current.key);
        //cmp will be -1 (negative) if key < current.key
        //cmp will be 0 (zero) if key == current.key
        // cmp will be +1 (positive) if key> current.key
        // go left
        if(cmp < 0)
        {
            current.left = put(current.left, key);
        }
        else if(cmp > 0)
        {
            // go right
            current.right = put(current.right, key);
        }
        else
        {
            // key already exists, replace the data(val)
            // Do nothing
        }

        // update the node's N - number of nodes in the subtree
        current.N = size(current.left) +size(current.right) + 1;

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
        // someone gives me a key, i want to find the value that goes with that key
        Node current = root;
        while(current != null)
        {
            int cmp = key.compareTo(current.key);
                //compareTo returns, neg, zero, pos.
            if(cmp < 0)
            {
                current = current.left;
            }
            else if(cmp>0)
            {
                current = current.right;
            }
            else
            {
                return true;
            }
        }// end of while loop

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


    private int size(Node current)
    {
        if(current == null)
        {
            return 0;
        }
        else
        {
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
        for(KeyType currentKey : this.keys())
        {
            result.add(currentKey);
        }
        for(KeyType currentKey : other.keys())
        {
            if(!result.contains(currentKey))
            {
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
        MathSet<KeyType> result = new BSTSet<>();
        for(KeyType currentKey : this.keys())
        {
            if(other.contains(currentKey))
            {
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


/*        // iterate (walk) through all items in this
        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
        while(itr.hasNext())
        {
            KeyType currentKey = itr.next();
            if(!other.contains(currentKey))
            {
                result.add(currentKey);
            }
        }*/




        for(KeyType currentKey : this.keys())
        {
            if(!other.contains(currentKey))
            {
                result.add(currentKey);
            }
        }



        return result;
    }

    /**
     * Retrieves a collection of all the keys in this set.
     * tree class
     * @return a collection of all keys in this set
     */

    @Override
    public Iterable<KeyType> keys() {
        // create a new empty queue to hold my results
        Queue<KeyType> queue = new Queue<>();

        // start the recursion, collecting results in the queue
        inorder(root,queue);

        // when done, return the queue
        return queue;
    }

    private void inorder(Node current, Queue<KeyType> q )
    {
        if(current == null)
        {
            // do nothing, end the method immediately
            return;
        }

        inorder(current.left,q);
        q.enqueue(current.key);
        inorder(current.right,q);
    }
}
