package edu.greenriver.sdev333;
import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SeparateChainingHashTable<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {
    private LinkedList<KeyType>[] st;
    private int M; //number of buckets

    public SeparateChainingHashTable(int M){
        this.M = M;
        //make array
        st = new LinkedList[M];
        for(int i = 0; i < M; i++){
            st[i] = new LinkedList<>();
        }
    }

    private int hash(KeyType key){
        return (keys().hashCode() & 0x7fffffff) % M;
    }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int i = hash(key);
        //check if the key exist
        if(st[i].contains(key)){
            return;
        }
        //add the key
        st[i].add(key);
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        int i = hash(key);
        LinkedList<KeyType> l = st[i];
        for(KeyType element : l){
            if(element.equals(key)){
                return true;
            }
        }
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
        for(int i = 0; i < M; i++){
            count += st[i].size();
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
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        MathSet<KeyType> result = new BSTSet<KeyType>();
        for(KeyType currentKey : this.keys()){
            result.add(currentKey);
        }
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
        MathSet<KeyType> result = new BSTSet<>();
        for(KeyType currentKey : keys()){
            if(other.contains(currentKey));
            result.add(currentKey);
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
        MathSet<KeyType> result = new BSTSet<>();
        for(KeyType currentKey : keys()){
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
            LinkedList<KeyType> l = new LinkedList<>();
            for(int i = 0; i < M; i++){
                for(KeyType k : st[i]){
                    l.add(k);
                }
            }
        return l;
        }
    }

