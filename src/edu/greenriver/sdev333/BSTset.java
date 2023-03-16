package edu.greenriver.sdev333;

class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {
    //fields
    private Node root;

    //Node helper class
    private class Node{
        private KeyType key;
        private Node left;
        private Node right;
        private int N; // number of nodes in the subtree rooted here

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
        root = add(root,key);
    }

    private Node add(Node current, KeyType key){
        // current is the root of the subtree wer are looking at

        //we are at where we are supposed to be
        if (current == null){
            //create new node
            return new Node(key, 1);
        }

        int cmp = key.compareTo(current.key);
        // left
        if (cmp < 0){
            current.left = add(current.left, key);
        }
        //right
        else if (cmp > 0){
            current.right = add(current.right, key);
        }
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
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false; //no matching in tree
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return root == null;
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
        if (current == null){
            return 0;
        }
        else {
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
        // Create an empty set that hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();

        //add all element from this set
        for (KeyType currentKey : this.keys()){
            result.add(currentKey);
        }
        //add all element from the other set
        for (KeyType currentKey : other.keys()){
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
        MathSet<KeyType> result = new BSTSet<KeyType>();
        for (KeyType currentKey : this.keys()){
            // if the key contains in the other set, add to result set
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
        // Create an empty set that hold the result
        MathSet<KeyType> result = new BSTSet<KeyType>();
        for (KeyType currentKey : this.keys()){
            if (!other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
    }
    // iterate (walk through all items in this)
//        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
//        while(itr.hasNext()){
//            KeyType currentKey = itr.next();
//            if (!other.contains(currentKey)){
//                result.add(currentKey);
//            }
//        }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        //create a new empty queue to hold my results
        Queue<KeyType> queue = new Queue<>();

        //start recursion, collecting results in the queue
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node current, Queue<KeyType> q){
        if (current == null){
            //do nothing - intentional
            return;
        }

        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);
    }
}