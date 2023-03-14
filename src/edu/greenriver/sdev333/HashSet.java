package edu.greenriver.sdev333;

/**
 * Hash Set class
 *
 * Author: Dee Brecke
 * This class uses a hashset to process data and compare two sets
 * using math methods of intersect, union and difference
 * The constructor uses Sequential Search Set (code borrowed from SequentialSearchST
 * from a previoous project) and iterator uses a queue to store data
 * @param <KeyType> Any data type to be added to the set
 */
public class HashSet<KeyType> implements MathSet<KeyType>{

    private SequentialSearchSet<KeyType>[] listArray; //referred to as st in previous project
    private int buckets; //referred to as M in previous project and book

    //default constructor
    public HashSet(){
        this(1000);
    }

    //parameterized constructor (Code from previous project used variables "M" and "st" but I think these are more descriptive
    public HashSet(int buckets){
        this.buckets = buckets;
        listArray = new SequentialSearchSet[buckets];

        for(int i = 0; i < buckets; i++){
            listArray[i] = new SequentialSearchSet<>();
        }
    }

   private int hash(KeyType key){
        return (key.hashCode() & 0x7fffffff) % buckets;
   }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key);
        listArray[index].put(key);
    }

    /**
     * accessor method used in other methods
     * @param key item to be checked
     * @return item if it is in the set
     */
    public KeyType get(KeyType key) {
        int index = hash(key); //find array index/bucket
        //check in the bucket to see if it's there
        return listArray[index].get(key);
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return get(key) !=null;
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
        int sum = 0;
        for (int i = 0; i < buckets; i++) {
            sum+= listArray[i].size();
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
        MathSet<KeyType> result = new HashSet<KeyType>(buckets);
        //walk through this and put in result
        for (KeyType currentKey: this.keys()) {
            result.add(currentKey);
        }
        //then walk through other and put in result
        //because it's a set, it won't add duplicates
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
        MathSet<KeyType> result = new HashSet<KeyType>(buckets);
        //walk through this and see if they are in other if so put in result
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
        MathSet<KeyType> result = new HashSet<KeyType>(buckets);
        //walk through this and see if they are in other if not put in result
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
        for (int i = 0; i < buckets; i++) {
            for(KeyType key : listArray[i].keys()){
                collector.enqueue(key);
            }
        }
        return collector;
    }

    /**
     * Method to print out results as a string instead of an address
     * useful for testing
     * @return string version of data in set
     */
    public String toString(){
        String output ="";
        for(KeyType key: keys()){
            output += key + ", ";
        }
        return output;
    }
}
