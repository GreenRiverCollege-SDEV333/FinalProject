package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Sequential search (unordered linked list implementation) of Symbol Table
 * Refer to p. 374-377 in Sedgewick and Wayne, Algorithms, 4th edition
 * @param <KeyType>
 */

public class SequentialSearchST<KeyType> implements MathSet<KeyType> {
    public Node first; //also referred to as the root
    private int size = 0;

    /**
     * Helper Class for LinkedList type implementation
     */
    private class Node {
        KeyType key;
        Node next;
        public Node(KeyType key, Node next ){
            this.key = key;
            this.next = next;
        }
    }

    /**
     * searches for given key and then puts a value at given key
     * @param key
     */
    @Override
    public void add(KeyType key) {
        //if current(first) is not null then loop through and find the key then change the value
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) {
                return;
            }
        }
        //thia only runs if first is null
        first = new Node(key, first);
    }

    public Node get(KeyType key) {
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) {
                return current; // return the node with matching key
            }
        }
        return null; // key not found in the set
    }

    /**
     * Checks if key exists in the set
     * @param key
     * @return boolean True- contains / False - Does not contain
     */
    public boolean contains(KeyType key) {
        //start at first/root, while current != null, increment current = current.next
        for (Node current = first; current != null; current = current.next){
            //check if current key is equal to the key that we are passing in
            if (key.equals(current.key)) {
                return true; // the key is present in the set
            }
        }
        return false; // the key is not present in the set
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
     * Returns the size of the set
     * @return size
     */
    @Override
    public int size() {
        for (KeyType s : this.keys()) {
            size++;
        }
        return size;
    }

    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        //create an empty set that will hold the result
        MathSet<KeyType> result = new SequentialSearchST<KeyType>();


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
        MathSet<KeyType> result = new SequentialSearchST<KeyType>();
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
        MathSet<KeyType> result = new SequentialSearchST<KeyType>();


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
     *Returns the keys in order using the helper class SequentialSearchSTKeyIterator
     * @return SequentialSearchSTKeyIterator
     */
    @Override
    public Iterable<KeyType> keys() {
        return new Iterable<KeyType>() {
            @Override
            public Iterator<KeyType> iterator() {
                return new SequentialSearchSTKeyIterator(first);
            }
        };
    }

    /**
     * Iterator for the SequentialSearchSymbolTable
     */
    public class SequentialSearchSTKeyIterator implements Iterator<KeyType> {

        private Node current;

        public SequentialSearchSTKeyIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public KeyType next() {
            //next is null/ doesn't exist
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            KeyType key = current.key;
            current = current.next;
            return key;
        }
    }
}
