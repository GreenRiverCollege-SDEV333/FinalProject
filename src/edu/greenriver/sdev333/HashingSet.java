package edu.greenriver.sdev333;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Katherine Watkins
 * SDEV 333
 * Final Project
 * @param <KeyType>
 */

public class HashingSet <KeyType> implements MathSet<KeyType>{
    private LinkedList [] hs;
    private int M;

    public HashingSet(){
        this(997);
    }
    public HashingSet(int M){
        this.M = M;
        hs = new LinkedList[M];
        for(int i= 0; i<M; i++){
            hs[i] = new LinkedList<>();
        }
    }
    private int hash(KeyType key){
        return (key.hashCode() & 0x7fffffff) % M;
//        return 1;
    }


    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key);
        if(!hs[index].contains(key)) {
            hs[index].add(key);
        }
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
        if(hs[index].contains(key)){
            return true;
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
        int size = 0;
        for(int i=0; i < M; i++){
            size += hs[i].size();
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
    public MathSet <KeyType> union(MathSet<KeyType> other) {
        MathSet<KeyType> union = new HashingSet<>();
        for (KeyType key: other.keys()) {
                union.add(key);
        }
        for(KeyType key : this.keys()){
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
    public MathSet <KeyType> intersection(MathSet<KeyType> other) {
        MathSet<KeyType> intersection = new HashingSet<>();
        for(KeyType key : other.keys()){
            if(this.contains(key)){
                intersection.add(key);
            }
        }
        return intersection;
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
        MathSet<KeyType> difference = new HashingSet<>();
        for (KeyType key: this.keys()) {
            if(!other.contains(key)){
                difference.add(key);
            }
        }
        return difference;
    }

    /**
     * Retrieves a collection of all the keys in this set.
     *
     * @return a collection of all keys in this set
     */
    @Override
    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();
        for(int i =0; i<M; i++){
           for(int j= 0; j< hs[i].size(); j++){
               KeyType current = (KeyType) hs[i].get(j);
               queue.enqueue(current);           }
        }
        return queue;
    }
}
