package edu.greenriver.sdev333;

/**
 * Sequential search (unordered linked list implementation) of Symbol Table
 * Refer to p. 374-377 in Sedgewick and Wayne, Algorithms, 4th edition
 * @param <KeyType>
 */
public class SequentialSearchSet <KeyType> {

    private Node first;
    private int size = 0;
    private class Node
    {   //Linked-list node
        private KeyType key;
        private Node next;
        public Node(KeyType key, Node next)
        {
            this.key = key;
//            this.val = val;
            this.next = next;
        }

    }


    public void put(KeyType key) {
        //Search for key, Update value if found; grow table if new
        for(Node x = first; x != null; x = x.next)
        {
            if(key.equals(x.key))
            {
//                x.val = value; // Search hit: update val.
                //If the key already exists do nothing.
                return;
            }

        }
        // if it doesn't exist create a new one.
        first = new Node(key,first); //Search miss: add new node.
        size++;
    }


    public boolean contains(KeyType key) {
        //Search for key, return associated value.
        for(Node x = first; x != null; x = x.next)
        {
            if(key.equals(x.key))
            {
                return true; // search hit
            }
        }
        return false;
    }


    public int size() {
        return size;
    }


    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();
        Node current = first;
        while(current != null)
        {
            queue.enqueue(current.key);
            current = current.next;
        }

        return queue;
    }
}
