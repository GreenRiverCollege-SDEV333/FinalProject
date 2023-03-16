package edu.greenriver.sdev333;
/**
 * Kevin Stone
 * SDEV333: Final Project Part 1 - Implementing a Set
 *
 * This class is to implement the MathSet interface. The
 * SequentialSearchST class (created in-class with instructor
 * Ken Hang) is used in this implementation.
 */
public class SeparateChainingHashTable<KeyType> implements MathSet<KeyType> {
    // fields:
    // array of linked lists - but we wrote a linked list in SequentialSearchSt
    private SequentialSearchST<KeyType>[] st;
    private int M; // M is the number of buckets

    // default constructor that calls our parameterized constructor
    public SeparateChainingHashTable(){
        // default constructor
        // calls the other constructor with a value
        this(997);
    }

    // constructor
    public SeparateChainingHashTable(int M) {
        // take their number of buckets and save them into the field
        this.M = M;

        // create the array
        st = new SequentialSearchST[M];

        // for each position in the array, create a linked list (SequentialSearchSt)
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }


    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        // use hash function to determine which index to add to
        int indexToAddTo = hash(key);
        // add here
        st[indexToAddTo].put(key);
    }

    // private helper method created in class to return an int
    private int hash(KeyType key){
        // hash function = give me a key, I return an int (bucket#, array index)
        return (key.hashCode() & 0x7fffffff ) % M;
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return get(key) != null;
    }

    // method created in class (SequentialSearchST)
    // return null if not found
    public KeyType get(KeyType key) {
        int index = hash(key); // find the bucket number
        // go into the bucket and see if it's there
        return st[index].get(key);
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
        // iterate through each "bucket"'s linkedList
        // for each of these lists, call the size method used in
        // SequentialSearchST
        int size = 0;
        for (int i = 0; i < M; i++) {
            size += st[i].size();
        }

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

        MathSet<KeyType> result = new SeparateChainingHashTable<KeyType>(M);

        // add all current keys to resultSet
        for (KeyType currentKey: this.keys()) {
            result.add(currentKey);
        }
        // add all "other" keys to resultSet
        for(KeyType currentKey : other.keys()){
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

        MathSet<KeyType> result = new SeparateChainingHashTable<KeyType>(M);

        // if our current key is also in our "other" keys, add to resultSet
        for (KeyType currentKey: this.keys()) {
            if(other.contains(currentKey)){
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

        MathSet<KeyType> result = new SeparateChainingHashTable<KeyType>(M);

        // if our current key is not in our "other" keys, add to resultSet
        for (KeyType currentKey: this.keys()) {
            if(!other.contains(currentKey)){
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
        Queue<KeyType> collector = new Queue<>();
        // for every bucket
        for (int i = 0; i < M; i++) {
            // take each key in that bucket and add it into the collector
            for (KeyType key : st[i].keys()) {
                collector.enqueue(key);
            }
        }
        return collector;
    }
}
