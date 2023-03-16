package edu.greenriver.sdev333;

public class SequentialSearchST <KeyType>{
    private Node first;

    public int size() {
        return 0;
    }
    //private int size = 0;

    private class Node{
        KeyType key;
        Node next;

        public Node(KeyType key, Node next){
            this.key = key;
            this.next = next;
        }
    }

//    @Override
    public void put(KeyType key) {
        // Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;                             //update val
            }
        }
        first = new Node(key, first);      //add new node
        //size++;
    }


    public KeyType get(KeyType key) {
        // Search for key, return associated value
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.key;       // search hit
            }
        }
        return null;               // search miss
    }

//    @Override
//    public int size() {
//        if (first == null){
//            return 0;
//        }
//        else {
//            return size;
//        }
//    }

//    @Override
    public Iterable<KeyType> keys() {
        //create a new empty queue to hold my results
        Queue<KeyType> queue = new Queue<>();

        Node current = first;
        //if is not empty
        while (current != null) {
            //added to queue
            queue.enqueue(current.key);
            //sends to next
            current = current.next;
        }

//        for(Node x = first; x !=null; x = x.next){
//            queue.enqueue(current.key);
//            current=current.next;
//        }

        return queue;
    }
}

