package edu.greenriver.sdev333;

/**
 * This class is a Separate Chaining Hash Table implementation of the MathSet using
 * the SequentialSearchST to manage the buckets of the hash table
 * @author: Jasmine David
 * @param <KeyType>
 */
public class HashSet<KeyType> implements MathSet<KeyType> {

    // used separatechaininghashst as model/example
    // ^^^ code manages the "buckets" of the hash table
    // separate chaining hash st depends on having sequentialsearchst (basically a linkedlist)
    // ^^^ code manages the insides of the buckets of the hash table
    // a linked list is inside each bucket
    // will need to bring in sequentialsearchst or write your own linkedlist


    // fields
    private SequentialSearchST<KeyType>[] st;
    private int M; // M is the number of buckets (or piles)

    /**
     * default constructor - sets M as 997 buckets
     */
    public HashSet() {
        // default constructor, no parameters
        this(997); // put 997 buckets
    }


    /**
     * parameterized constructor
     * @param M - number of buckets
     */
    public HashSet(int M) {
        // take their number of buckets, save it in to my field
        this.M = M;

        // create the array
        st = new SequentialSearchST[M];

        // for each position in the array (for each bucket)
        // create a linked list (sequentialsearchst) in each bucket
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(KeyType key) {
        // hash function = they give me a key, I return an int (bucket #, array index)
        return (key.hashCode() & 0x7fffffff) % M; // % (mod) gives you a # between 0 and 100

    }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        // put the key into the bucket
        st[hash(key)].put(key); // this is using put method from the sequentialsearchst
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

    /**
     * get method used in contains method above
     */
    public KeyType get(KeyType key) {
        // go into bucket and see if it's there
        return st[hash(key)].get(key); // using sequentialsearchst get method
    }


    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Number of keys in the set
     *
     * @return number of keys in the set.
     */
    @Override
    public int size() {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += st[i].size();
        }
        return sum;
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
        MathSet<KeyType> result = new HashSet<KeyType>();

        // add keys from other set
        for (KeyType currentKey : other.keys()) {
            result.add(currentKey);
        }
        // add keys from this set
        for (KeyType currentKey : this.keys()) {
            result.add(currentKey);
        }
        // return the union
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
        MathSet<KeyType> result = new HashSet<KeyType>();

        // add key to this set ONLY if the key is in the other set
        for (KeyType currentKey : this.keys()) {
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
        MathSet<KeyType> result = new HashSet<KeyType>();

        // add key to this set if it is NOT in other set
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
        Queue<KeyType> collector = new Queue<>();
        for (int i = 0; i < M; i++) {
            for(KeyType key : st[i].keys()){
                collector.enqueue(key);
            }
        }
        return collector;
    }
}
