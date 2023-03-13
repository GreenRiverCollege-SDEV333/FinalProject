package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SeperateChainingHashTableSet <KeyType> implements MathSet<KeyType> {


    private Node head; // first node in the linked list
    private int size; // size variable for tracking size

    private class Node {
        KeyType key;
        Node next;

        /**
         * Node class used in lunkedlist symbol table implentation
         * @param key
         * @param next
         */
        public Node(KeyType key, Node next) {
            this.key = key;
            this.next = next;
        }

    }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {

            for (Node current = head; current != null; current = current.next) {
                if (key.equals(current.key)) {
                    return;
                }
            }
            head = new Node(key, head);

        }


    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {

            for (Node current = head; current != null; current = current.next) {
                if (key.equals(current.key)) {
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
        for (KeyType key : this.keys()) {
            size++;
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
        MathSet<KeyType> result = new SeperateChainingHashTableSet<KeyType>();

        //add all the elements of this se to the result set
        for(KeyType currentKey : this.keys()){
            result.add(currentKey);
        }

        // add elements of the other set to the result set if they are not already in the result set
        for (KeyType currentKey : other.keys()) {
            if (!result.contains(currentKey)) {
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
        MathSet<KeyType> result = new SeperateChainingHashTableSet<KeyType>();

        for(KeyType currentKey : this.keys()){
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
        //create an empty set that will hold a result
        MathSet<KeyType> result = new SeperateChainingHashTableSet<KeyType>();

        for(KeyType currentKey : this.keys()){
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
        return new Iterable<>() {
            @Override
            public Iterator<KeyType> iterator() {
                return new SSIterator(head);
            }
        };
    }


    /**
     * helper iterator class used in for each loops
     */
    public class SSIterator implements Iterator<KeyType> {

        private Node current;

        public SSIterator(Node head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public KeyType next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            KeyType key = current.key;
            current = current.next;
            return key;
        }
    }
}
