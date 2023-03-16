package edu.greenriver.sdev333;

/**
 * Sequential Search (unordered linked list implementation) Set
 * @author: Jasmine David
 * @param <KeyType>
 */
public class SequentialSearchST<KeyType> {
    // fields
    private Node first;
    private int size = 0;

    // helper class
    private class Node{
        KeyType key;
        Node next;

        // constructor:
        public Node (KeyType key, Node next)
        {
            this.key = key;
            this.next = next;
        }
    }


    /**
     * Method that puts/links node into "bucket" of hash table
     *
     * @param key - key
     */
    public void put(KeyType key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                return;
            }
        first = new Node(key, first);
        size++;

    }

    /**
     * Method that returns value of specified key - search for the key
     * and return associated value
     *
     * @param key - key
     * @return value of key
     */
    public KeyType get(KeyType key) {
        // Search for key, return associated value
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.key;
        return null;
    }


    /**
     * Method that returns the size of nodes in "buckets" - if first == null, return
     * size = 0; otherwise return size of nodes
     *
     * @return size of nodes
     */
    public int size() {
        if (first == null ) {
            return 0;
        }
        else {
            return size;
        }
    }

    /**
     * Iterable method that returns a queue of nodes
     *
     * @return queue
     */
    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();
        Node current = first;
        for(Node x = first; x != null; x = x.next){
            queue.enqueue(current.key);
            current = current.next;
        }
        return queue;
    }
}
