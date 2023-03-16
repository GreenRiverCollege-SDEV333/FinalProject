package edu.greenriver.sdev333;

import java.security.Key;
import java.util.LinkedList;

public class SeparateChainingHashSet<KeyType> implements MathSet<KeyType> {
    private int size;
    private LinkedList<KeyType>[] lists; //array of LinkedLists

    public SeparateChainingHashSet() {
        this(997);
    }
    public SeparateChainingHashSet(int size) {
        this.size = size;
        lists = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            lists[i] = new LinkedList<>();
        }
    }
    private int hash(KeyType key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key); //find bucket number

        lists[index].add(key); //add key into bucket
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        int index = hash(key);

        return lists[index].contains(key);
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        //returns using size() method since default constructor puts
        //in 997 for size
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
        for (int i = 0; i < size; i++) {
            sum += lists[i].size();
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
        //create empty set that will hold the result
        MathSet<KeyType> result = new SeparateChainingHashSet<KeyType>();

        for(KeyType currentKey : this.keys()) {
            result.add(currentKey);
        }

        for(KeyType currentKey : other.keys()) {
            if(!result.contains(currentKey)) {
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
        //create empty set that will hold the result
        MathSet<KeyType> result = new SeparateChainingHashSet<KeyType>();

        //checks other for currentKey & adds to result if other contains currentKey
        for(KeyType currentKey : this.keys()) {
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
        //create empty set that will hold the result
        MathSet<KeyType> result = new SeparateChainingHashSet<KeyType>();

        for(KeyType currentKey : this.keys()) {
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
        for (int i = 0; i < size; i++) {
            // take every key in that bucket and add it to the collector
            for (KeyType key : lists[i]) {
                collector.enqueue(key);
            }
        }
        return collector;
    }
}
