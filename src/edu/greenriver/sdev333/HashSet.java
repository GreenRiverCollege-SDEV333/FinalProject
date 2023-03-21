package edu.greenriver.sdev333;

public class HashSet<KeyType> implements MathSet<KeyType>{
    // fields:
    // array of linked lists
    //private SequentialSearchST<KeyType, ValueType>[] st;
    private int M;

    public HashSet(int M) {
        // take their number of buckets, save it into my field
        this.M = M;

        // create new array
        //st = new SequentialSearchST[M];

        // for each bucket, create a linked list
        for (int i = 0; i < M; i++) {
        //    st[i] = new SequentialSearchST<>();
        }
    }

    // Used SeparateChainingHastHT as model/example
    // ^^^ code manages the "buckets" of the hash table

    // vvv code manages the insides of the buckets of the hash table
    //      a linked list is inside each bucket
    // SeparateChainingHashST depends on having SequentialSearchST
    // will need to either bring in SequentialSearchST
    // or write your own linked list
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {

    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return false;
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        return 0;
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
        return null;
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
        return null;
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
