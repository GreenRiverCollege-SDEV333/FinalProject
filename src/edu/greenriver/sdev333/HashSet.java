package edu.greenriver.sdev333;

import java.util.LinkedList;

/**
 * using a lot of the same code from SymbolTables project
 * seperatChainingHashST class
 * @param <KeyType>
 */
public class HashSet<KeyType> implements MathSet<KeyType>{

    // SequentialSearchST<KeyType> this is the linked list, [] says we want to have an array of linked lists
    // and st is the variable name
    private SequentialSearchSet<KeyType>[] st;
    private int M; // M represents the number of buckets/piles
    //when someone makes a new hash table they tell us how many buckets they want (M)
    //hence why we want a default constructor

    public HashSet(){
        this(999);
    }

    //add a parameterized constructor
    public HashSet(int M) {
        //take their number of buckets, save it into my field
        this.M = M;

        //create the array
        st = new SequentialSearchSet[M];

        //for each position in the array (for each bucket)
        // create a linked list (sequentialSearchSet) in each bucket
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchSet<>();
        }

    }

    private int hash(KeyType key) {
        // hash function = they give me a key, I return an int (the bucket number) we can think of the bucket number as the arrya index
        return (key.hashCode() & 0x7fffffff) % M; //moding by M gives us a number between 0 and M

    }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key);  //find the bucket number
        //put the key into that bucket
        st[index].put(key);

        //so if someone gives you the key and the value, go find me the hash number for the key
        // thats going to be the index for the array,
        // then go into the array at that position and put that key
        // into that bucket
    }

    /**
     * Helper method
     * @param key
     * @return
     */
    //if someone says im going to give you a key, go find it for me
    public KeyType get(KeyType key) {
        //figure out what bucket im in
        int index = hash(key); //find the bucket number
        //go into the bucket and see if its there
        return st[index].get(key); //if its in there we get our value back, if its not in there null returns back
    }


    /**
     * Returns a boolean value indicating whether the
     * given key exists in the data structure or not.
     * @param key
     * @return
     */
    @Override
    public boolean contains(KeyType key) {
        return get(key) != null;
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
        //we need to go into each bucket and find the number of items in each bucket
        // we need to go through each bucket and add up each individual size
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += st[i].size; // add each bucket size to the sum
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
        //create a new set that will hold the result of all the items we want
        MathSet<KeyType> result = new HashSet<KeyType>(M);
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
        MathSet<KeyType> result = new HashSet<KeyType>(M);
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
        MathSet<KeyType> result = new HashSet<KeyType>();

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
        Queue<KeyType> collector = new Queue<>();
        // for every bucket
        for (int i = 0; i < M; i++) {
            // take each key and add it into the collector
            for (KeyType key: st[i].keys()) {
                collector.enqueue(key);
            }
        }
        return collector;
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
