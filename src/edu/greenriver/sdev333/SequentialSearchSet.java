package edu.greenriver.sdev333;

public class SequentialSearchSet <KeyType>{
    private Node first; //we usually call this head but the book uses first so that's what I did this time

    private int count;
    private class Node{
        KeyType key;
        Node next;

        /**
         * Constructor for Nodes being used int this class
         * @param key key
         * @param next the next node in the linked list
         */
        public Node(KeyType key, Node next){
            this.key = key;
            this.next = next;
        }
    }

    /**
     * Given a key value pair, add the node to the structure
     * @param key key
     */
    public void put(KeyType key) {
        for(Node current = first; current!=null; current = current.next){
            if(key.equals(current.key)){
                return;
            }
        }first=new Node(key, first);
        count++;
    }

    /**
     * Find the value at a given key
     * @param key key
     * @return value at given key
     */

    public KeyType get(KeyType key) {
        for(Node current = first; current !=null; current = current.next){//the book uses x instead of current
            if(key.equals(current.key)){
                return current.key;
            }
        }
        return null;
    }

    /**
     * This method counts how many nodes are in the structure
     * @return integer number of nodes in structure
     */
    public int size() {
        return count;
    }

    /**
     * iterator to go through the structure and put the nodes into a queue
     * @return queue of nodes
     */

    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();
        Node current = first;
        while (current !=null){
            queue.enqueue(current.key);
            current = current.next;
        }
        return queue;
    }
}
