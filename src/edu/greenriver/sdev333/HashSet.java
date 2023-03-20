package edu.greenriver.sdev333;

import java.security.Key;

public class HashSet<KeyType> implements MathSet<KeyType>
{
    // Used SeparateChainingHashST as my model/example
    // ^^^ code manages the "buckets" of the hash table

    //VVV code manages the insides of the buckets of the hash table
    // a linked list is inside each bucket
    // SeparateChainingHashST Depends on having SequentialSearchST
        //will need to either bring in SequentialSearchST
        // or write your own linked list

    /**
     * Hash Table (separate chaining implementation) of Symbol Table
     * Refer to p. 458-468 in Sedgewick and Wayne, Algorithms, 4th edition
     * @param <KeyType>
     */
        // fields

        private SequentialSearchSet<KeyType>[] st;
        private int M; // M is the number of buckets
        public HashSet()
        {
            // default constructor , takes no parameters
            // call the other constructor with a value

            this(997);
        }

        public HashSet(int M) {
            this.M = M;

            st = new SequentialSearchSet[M];

            //for each position in the array (for each bucket)
            // create a linked list (squentialsearchse) in each bucket
            for (int i = 0; i < M; i++)
            {
                st[i] = new SequentialSearchSet<>();
            }
        }

        private int hash(KeyType key)
        {
            // hash function = they give me a key, i return an int(bucket #. array index)
            return (key.hashCode() & 0x7fffffff) % M;
        }

        public void put(KeyType key) {
            int index = hash(key);
            st[index].put(key);
        }


//        public ValueType get(KeyType key) {
//            int index = hash(key);
//            return st[index].get(key);
//        }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {

    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        //get the key if the key is not null, return true.
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        //if size() == 0 it will be empty.
    }

    public int size() {
            // go through each bucket and add up the each individual size
            int sum = 0;
            for(int i =0; i <M; i ++)
            {
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
        return null;
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
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        return null;
    }

    public Iterable<KeyType> keys() {
            Queue<KeyType> collector = new Queue<>();
            for(int i = 0 ; i < M; i ++)
            {
                for(KeyType key : st[i].keys())
                {
                    collector.enqueue(key);
                }
            }
            return collector;
        }
}
