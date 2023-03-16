package edu.greenriver.sdev333;

public class HashSet<Key> implements MathSet<Key> {
    // Used SeparateChainingHashST as model/example
    // ^^^ code manges the "buckets" of the hash table

    // array  of linked list
    private HashSet<Key>[] set;
    private int M; // M is the number of buckets
    // VVV code manages the insides of the buckets of the hash table
    // a linked list is the inside each bucket
    // SeperateChainingHashST depends on having SequentialSearchST
        // will need to either bring in SequentialSearchST
        // or write your own linked list

    public HashSet() {
    }
    public HashSet(int M) {
        // take the number of buckets and save it to fields
        this.M = M;

        // create a array
        set = new HashSet[M];

        // for each position in the array (for each bucket)
        // create linked list in each bucket
        for(int i = 0; i < M; i++) {
            set[i] = new HashSet<>();
        }
    }

    private int hash(Key key) {
        // hash function = they give me a key, I return an int
        // return an int (bucket #, array index)
        return (key.hashCode() & 0x7fffffff) % M;
    }
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(Key key) {
        int i = hash(key);
         set[i].get(key);
    }

    public Key get(Key key) {
        int i = hash(key); // find the bucket number
        // go into that bucket and see if it's there
        return set[i].get(key);
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(Key key) {
        // not sure what to put here
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
        int count = 0;
        for(int i = 0; i < M; i++) {
            count+= set[i].size();
        }
        return count;
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
    public MathSet<Key> union(MathSet<Key> other) {
        MathSet<Key> union = new HashSet<Key>(M);

        for(Key key : this.keys()) {
            union.add(key);
        }
        for(Key key : other.keys()) {
            union.add(key);
        }
        return union;
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
    public MathSet<Key> intersection(MathSet<Key> other) {
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
    public MathSet<Key> difference(MathSet<Key> other) {
        return null;
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
