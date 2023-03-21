package edu.greenriver.sdev333;

/**
 * Using the code from ImplementingLists project
 * specifically the sequentialSearch class which implements an unordered linked list
 * essentially the only difference is that here we do not have values
 * @param <KeyType>
 */
public class SequentialSearchSet <KeyType>{

    private Node first;
    int size;

    private class Node {
        KeyType key;
        Node next;

        //constructor to implement
        public Node(KeyType key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /**
     * This method puts the kay/value pair into our tree
     * @param key
     *
     */
    public void put(KeyType key) {
        //need to iterate through the linked list to look for our value
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) {
                return;
            }
        }
        //if the value is not found in the list, create a new node and assign it the value
        first = new Node(key, first);
        size++;

    }

    /**
     * This method gets a given key/value
     * @param key
     * @return
     */
    public KeyType get(KeyType key) {
        // iterate through our linked list looking for matching key
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) {
                return current.key;
            }
        }
        // if there is no matching key found then return null
        return null;
    }

    /**
     * method returns the size of the tree accounting for how many nodes there are
     * @return
     */

    public int size() {
        return size;
    }

    /**
     * this method will return a ordered list of keys
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

