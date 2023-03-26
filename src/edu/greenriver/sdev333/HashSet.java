package edu.greenriver.sdev333;

/**
 * This class implements the MathSet interface, mimicking a mathematical
 * set while employing an Array of LinkedLists in its implementation. This
 * class is not ordered, and does not require its keys to implement any
 * special interfaces.  Some code implemented in class w/ Ken
 *SeparateChainingHashTable
 * @author Paul Woods
 * @param <KeyType>
 */
public class HashSet<KeyType>  implements MathSet<KeyType> {

    private int M;      // number of buckets
    private LinkedList<KeyType>[] bucket; // lists that reside in each bucket
    private int size;

    /**
     * Default constructor,  defaults to a bucket list size
     * of 997 elements.
     */
    public HashSet() {
        this(997);  // call w/ a default prime # value, ensure more unique lists
    }

    /**
     * Constructor, with M indicating number of buckets to allocate
     * for.
     * @param M
     */
    public HashSet(int M) {
        this.M = M;

        bucket = new LinkedList[M];

        for (int i = 0; i < M; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    /*
     * returns the array element and linked list to address
     * when getting/putting/working-with this key value
     */
    private int hash(KeyType key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }



    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        if (!contains(key)) {
            bucket[hash(key)].add(key);
            ++size;
        }
    }

    /**
     * Is the key in the set?
     *
     * Utilizes the contains method from the LinkedList class
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {

        // return a LinkedList for the bucket corresponding to this key/hash
        return bucket[hash(key)].contains(key);
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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


        MathSet<KeyType> temp = new HashSet<>();

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

        MathSet<KeyType> temp = new HashSet<>();

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
     * @param other specified set to difference
     * @return the difference of this set with other
     */
    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {

        // create an empty set that will hold the result
        MathSet<KeyType> result = new HashSet<KeyType>();

        for (KeyType key: this.keys()) {
            if (!other.contains(key)) {
                result.add(key);
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
        Queue<KeyType> queue = new Queue<>();

        // cycle through array of Lists, bucket
        for (int i = 0; i < M; i++) {
            // cycle through LinkedList
            for (int a = 0; a < bucket[i].size(); a++) {
                queue.enqueue(bucket[i].get(a));
            }
        }

        return queue;
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
}
