package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.NoSuchElementException;

//Bring in sequential search st
public class SCHSet<KeyType> implements MathSet<KeyType> {
    private int m;
    private SequentialSearchST[] st;

    public SCHSet(){
        this(997);
    }

    public SCHSet(int m){
        this.m = m;
        //construct an array of SequentialSearchST objects
        st = (SequentialSearchST<KeyType>[]) new SequentialSearchST[m];
        //instantiate new Sequential Search objects for each index in the array
        for(int i = 0; i < m; i++){
            st[i] = new SequentialSearchST();
        }
    }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    public int hash(KeyType key){
        return (key.hashCode() & 0x7fffffff) % m;
    }
    @Override
    public void add(KeyType key) {
        st[hash(key)].add(key);
    }

    /**
     * Retrieves the value associated with a given key in the set.
     *
     * @param key the key to retrieve the value for
     * @return the value associated with the key, or null if the key is not in the set
     */
    public Object get(KeyType key) {
        int index = hash(key);
        return st[index].get(key);
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return st[hash(key)].contains(key);
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
        //iterate through array
        //at each iteration call st[i].size() add to the size counter
        int size = 0;
        for(int i=0; i < st.length; i ++){
            size += st[i].size();
        }
        return size;
    }

    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        //create an empty set that will hold the result
        MathSet<KeyType> result = new SCHSet<KeyType>();


        for (KeyType currentKey: this.keys()) {
            if(!result.contains(currentKey)) {
                result.add(currentKey);
            }
        }

        for (KeyType currentKey: other.keys()) {
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
        MathSet<KeyType> result = new SCHSet<KeyType>();
        for (KeyType currentKey : this.keys()) {
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
        //create an empty set that will hold the result
        MathSet<KeyType> result = new SCHSet<KeyType>();


        for (KeyType currentKey: this.keys()) {
            if(!other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
        //Iterate through all of this
//        Iterator<KeyType> itr = (Iterator<KeyType>) this.keys();
//        while (itr.hasNext()){
//            KeyType currentKey = itr.next();
//            if (!other.contains(currentKey)) {
//                result.add(currentKey);
//            }
//        }
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        return new Iterable<KeyType>() {
            @Override
            public Iterator<KeyType> iterator() {
                return new Iterator<KeyType>() {
                    private int currentIndex = 0;
                    private Iterator<KeyType> currentIterator = st[currentIndex].keys().iterator();

                    @Override
                    public boolean hasNext() {
                        while (!currentIterator.hasNext() && currentIndex < m - 1) {
                            currentIndex++;
                            currentIterator = st[currentIndex].keys().iterator();
                        }
                        return currentIterator.hasNext();
                    }

                    @Override
                    public KeyType next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return currentIterator.next();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
