package edu.greenriver.sdev333;

/**
 * This class implements the MathSet interface, mimicking a mathematical
 * set while employing a Binary Tree in its implementation. This allows
 * the BSTSet to be ordered, and requires the Keys that are stored to
 * implement the Comparable interface.  Some code was written during
 * class w/ Ken.
 *
 * @author Paul Woods
 * @param <KeyType>
 */
public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {

    // Used code from BST class as reference ...

    // node helper class
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
    private int size;

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        // in case the tree is empty, having = allows us to save/start the tree
        if (!contains(key)) {
            root = add(root, key);
            ++size;
        }
    }


    private Node add(Node n, KeyType key) {
        // we are where we are supposed to be
        if (n == null) {
            // create a new node
            return new Node(key, 1);
        }

        int cmp = key.compareTo(n.key);
        // n will be < 0 if key < current
        // n = 0 if key == current
        // n > 0 if key > current

        if (cmp < 0) {
            // go left
            n.left = add(n.left, key);
        } else if (cmp > 0) {
            // go right
            n.right = add(n.right, key);
        }

        // update the node's N, number of nodes in subtree
        // size of left + size of right + self
        // resets size N as works way back up the stack
        int l = 0;
        int r = 0;
        if (n.right != null)
            r = n.right.N;
        if (n.left != null)
            l = n.left.N;

        n.N = l + r + 1;        // add N values from left and right nodes (if exist)

        return n;
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return contains(root, key);
    }

    /*
     * Recursive helper method for contains(KeyType)
     */
    private boolean contains(Node current, KeyType key) {

        // if we are at a point that is null and have not found key
        if (current == null) {
            return false;
        }

        // compare current key value to key looking for
        int compare = key.compareTo(current.key);

        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return contains(current.left, key);
        } else {
            return contains(current.right, key);
        }
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        return size;
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

        MathSet<KeyType> temp = new BSTSet<>();

        for (KeyType key: this.keys()) {
            temp.add(key);
        }

        for (KeyType key: other.keys()) {
            temp.add(key);
        }

        return temp;
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
        // cycle through set A
        // determine if key is in set B
        // if true, add key to temp set

        MathSet<KeyType> temp = new BSTSet<>();

        for (KeyType key: this.keys()) {
            if (other.contains(key)) {
                temp.add(key);
            }
        }

        return temp;
    }

    /**
     * Determine the difference of this set with another specified set.
     * Returns A difference B, where A is this set, B is other set.
     * A difference B = {key | A.contains(key) AND !B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * {a,b,r,c,e} - {c,e,d,u,f} = {a,b,r} only
     * will cycle through 1st set, checking for elements in 2nd set
     * if are not present in 2nd set, add to result set
     *
     * @param other specified set to difference
     * @return the difference of this set with other
     */
    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {

        // create an empty set that will hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        for (KeyType key: this.keys()) {
            if (!other.contains(key)) {
                result.add(key);
            }
        }

        return result;
    }

    /**
     * Overridden toString() method to output this list
     * in a presentable manner.  Used for testing in
     * the Main class as well.
     * @return
     */
    @Override
    public String toString() {

        String s = "{";
        for (KeyType key: keys()) {
            s += key + ", ";
        }

        s = s.substring(0, s.length() - 2);
        s += "}";

        return s;

    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        // new empty queue to hold results
        Queue<KeyType> queue = new Queue<>();

        // start the recursion
        inorder(root, queue);

        return queue;
    }

    // Helper method for keys(), recursively finds list of
    // keys inside tree
    private void inorder(Node current, Queue<KeyType> q) {
        if (current == null) {
            // do nothing - intentionally blank
            return;
        }

        // left subtree
        inorder(current.left, q);

        // add self to queue
        q.enqueue(current.key);

        // right subtree
        inorder(current.right, q);
    }

}
