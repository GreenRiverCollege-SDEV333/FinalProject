package edu.greenriver.sdev333;

import java.util.Iterator;

/**
 * Sequential search (unordered linked list implementation) of Symbol Table
 * Refer to p. 374-377 in Sedgewick and Wayne, Algorithms, 4th edition
 *
 * Note: size method returns number of elements, but there is currently no method
 * to remove elements, only add via put().
 *
 * @param <KeyType>
>
 */
public class SequentialSearchST <KeyType> {

    private Node first;
    private int size;

    private class Node {
        KeyType key;
        Node next;
        public Node(KeyType key,  Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /**
     * Puts the key/value into the tree
     * @param key
     */

    public void put(KeyType key) {
        // cycle through linked list looking for value
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }

        // value not found in list, create a new node and assign value
        first = new Node(key, first);
        ++size;
    }

    /**
     * Gets the given key/value from the tree
     * @param key
     * @return
     */
    public KeyType get(KeyType key) {
        // cycle through linked list looking for matching key
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.key;
            }
        }

        // no matching key found, return null
        return null;
    }
    /**
     * returns the size of the tree as an int value
     * @return
     */

    public int size() {
        return size;
    }

    /**
     * Returns an iterable list of keys for this list
     * @return
     */
    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();

        Node current = first;
        while (current != null) {
            queue.enqueue(current.key);
            current = current.next;
        }

        return queue;
    }
}