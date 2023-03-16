package edu.greenriver.sdev333;

/**
 *
 */
public class SequentialSearchST <KeyType> {

    // private field
    private Node first;
    private int size;

    // private helper class
    private class Node {
        // linked list node
        KeyType key;
        Node next;
        public Node(KeyType key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public void put(KeyType key) {

        for(Node x = first; x != null; x = x.next ){
            if(key.equals(x.key)){
                x.key = key;
                return;
            }
        }
        first = new Node(key, first);
        size++;
    }

    /**
     * Gets the value of the key passed as a parameter
     * @param key
     * @return the associated value of the given key
     */
    public KeyType get(KeyType key) {

        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                return x.key;
            }
        }
        return null;
    }

    public int size() {

        return size;
    }

    public Iterable<KeyType> keys() {

        Queue<KeyType> keyQueue = new Queue<>();

        Node current = first;
        while(current != null) {
            keyQueue.enqueue(current.key);
            current = current.next;
        }
        return keyQueue;
    }
}
