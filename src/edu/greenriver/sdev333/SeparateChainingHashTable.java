package edu.greenriver.sdev333;
import java.security.Key;
import java.util.LinkedList;

/*by Alex brenna
 * */
public class SeparateChainingHashTable< KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{

    //fields:
    //array of linkedLists
    private LinkedList[] st;
    //M = number of buckets
    private int M;

    public SeparateChainingHashTable(){
        this(997);

    }

    public SeparateChainingHashTable(int M){
        this.M = M;
        //create array
        st = new LinkedList[M];
        //create linkedList for each position in array
        for(int i = 0; i<M; i++){
            st[i] = new LinkedList<>();
        }

    }
    private int hash(KeyType key){
        //return int from key provided to get array index to put item in/get item from
        return (key.hashCode() & 0x7fffffff) % M;
    }
    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key);
        //put key/value into bucket
        st[index].add(key);
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
        if(st[index].contains(key)){
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
        MathSet<KeyType> result = new SeparateChainingHashTable<>();
        //all thats in A and B
        for (KeyType key : other.keys()) {
            result.add(key);
        }
        for (KeyType key : this.keys()) {
            result.add(key);
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
        //holds result
        MathSet<KeyType> result = new SeparateChainingHashTable<>();
        //whats in A and B at same time
        for (KeyType key : other.keys()) {
            if(this.contains(key)){
                result.add(key);
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
        //holds result
        MathSet<KeyType> result = new SeparateChainingHashTable<KeyType>();
        //whats in A but not in B
        for (KeyType a: this.keys()) {
            if(!other.contains(a)){
                result.add(a);
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
        for(int i =0; i<M; i++){
            for(int j= 0; j< st[i].size(); j++){
                KeyType current = (KeyType) st[i].get(j);
                queue.enqueue(current);
            }
        }
        return queue;
    }
}
