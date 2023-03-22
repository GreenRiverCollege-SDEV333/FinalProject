package edu.greenriver.sdev333;

/**
 * Modification of:
 * Sequential search (unordered linked list implementation) of Symbol Table
 * Refer to p. 374-377 in Sedgewick and Wayne, Algorithms, 4th edition
 * @param <KeyType>
 */
public class SequentialSearchSet <KeyType> {
    private Node first;
    private class Node {
        KeyType key;
        Node next;
        public Node(KeyType key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public void put(KeyType key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }
        first = new Node(key, first);
    }

    public boolean contains(KeyType key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return true;
        }
        return false;
    }

    public int size() {
        // Have to find size every time, could also keep track as a variable
        int size = 0;
        for (Node x = first; x != null; x = x.next) {
            size++;
        }
        return size;
    }

    public Iterable<KeyType> keys() {
        Queue<KeyType> collector = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            collector.enqueue(x.key);
        }
        return collector;
    }
}

