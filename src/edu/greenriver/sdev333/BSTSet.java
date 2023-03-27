package edu.greenriver.sdev333;

import java.util.Comparator;
import java.util.Iterator;

public class BSTSet<KeyType extends Comparable<KeyType>> implements MathSet<KeyType> {

    // node helper class
    private class Node {
        private KeyType key;
        private Node left;
        private Node right;
        private int N;

        public Node(KeyType key, int N) {
            this.key = key;
            this.N = N;
        }
    }

    // field
    private Node root;

    @Override
    public void add(KeyType key) {
        root = add(root, key);
    }

    private Node add (Node current, KeyType key) {
        // Current is the root of the subtree we are looking at

        //where we want to be
        if (current == null) {
            return new Node(key, 1);
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            // go left
            current.left = add(current.left, key);
        }else if (cmp > 0) {
            // go right
            current.right = add(current.right, key);
        } else {
            current.key = key;
        }

        current.N = size(current.left) + size(current.right) + 1;
        return current;
    }


    @Override
    public boolean contains(KeyType key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                // go left
                current = current.left;
            } else if (cmp > 0) {
                // go right
                current = current.right;
            } else {
                // match found, return true;
                return true;
            }
        }// no match was found if we get here
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size(root) == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    // private helper method for size, traverses the tree to record the size
    private int size(Node current) {
        if (current == null) {
            return 0;
        }else {
            return size(current.left) + size(current.right) + 1;
        }
    }

    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        MathSet<KeyType> intersections = new BSTSet<KeyType>();

        for (KeyType currentKey : this.keys()) {
            intersections.add(currentKey);
        }
        for (KeyType currentKey : other.keys()) {
            intersections.add(currentKey);
        }
        return intersections;
    }

    @Override
    public MathSet<KeyType> intersection(MathSet<KeyType> other) {
        MathSet<KeyType> intersections = new BSTSet<KeyType>();

        for (KeyType currentKey : this.keys()) {
            if (this.contains(currentKey) && other.contains(currentKey)) {
                intersections.add(currentKey);
            }
        }
        return intersections;
    }

    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        MathSet<KeyType> differences = new BSTSet<>();

        for (KeyType key : this.keys()) {
            if (!other.contains(key)) {
                differences.add(key);
            }
        }

        return differences;
    }

    @Override
    public Iterable<KeyType> keys() {
        Queue<KeyType> keys = new Queue<>();
        inorder(root, keys);

        return keys;
    }

    private void inorder(Node current, Queue<KeyType> q) {
        if (current == null) {
            // do nothing - intentionally blank
            return;
        }
        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);
    }
}
