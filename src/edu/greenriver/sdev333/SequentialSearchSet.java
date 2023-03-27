package edu.greenriver.sdev333;

import java.util.Iterator;

/**
 * Sequential search (unordered linked list implementation) of Symbol Table
 * Refer to p. 374-377 in Sedgewick and Wayne, Algorithms, 4th edition
 * @param <KeyType>
 */

public class SequentialSearchSet <KeyType> {

    private Node first;
    private int size = 0;

    private class Node {
        KeyType key;
        Node next;

        public Node (KeyType key, Node next) {
            this.key = key;
            this.next = next;
        }
    }
    public void put(KeyType key) {
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) {
                return;
            }
        }
        first = new Node(key, first);
        size++;
    }

    public KeyType get(KeyType key) {
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) {
                return current.key;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Iterable<KeyType> keys() {
        Queue<KeyType> keys = new Queue<>();

        Node current = first;
        while(current != null) {
            keys.enqueue(current.key);
            current = current.next;
        }
        return keys;
    }
}