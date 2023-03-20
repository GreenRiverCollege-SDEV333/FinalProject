package edu.greenriver.sdev333;

public class SeparateChainingHashST<KeyType> implements MathSet<KeyType> {

    private SeparateChainingHashST<KeyType> hashTable;

    public SeparateChainingHashST() {
        hashTable = new SeparateChainingHashST<KeyType>();
    }

    @Override
    public void add(KeyType key) {
        hashTable.put(key);
    }

    private void put(KeyType key) {
    }

    @Override
    public boolean contains(KeyType key) {
        return hashTable.contains(key);
    }

    @Override
    public boolean isEmpty() {
        return hashTable.isEmpty();
    }

    @Override
    public int size() {
        return hashTable.size();
    }

    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        MathSet<KeyType> result = new SeparateChainingHashST<KeyType>();
        for (KeyType key : keys()) {
            result.add(key);
        }
        for (KeyType key : other.keys()) {
            result.add(key);
        }
        return result;
    }

    @Override
    public MathSet<KeyType> intersection(MathSet<KeyType> other) {
        MathSet<KeyType> result = new SeparateChainingHashST<KeyType>();
        for (KeyType key : keys()) {
            if (other.contains(key)) {
                result.add(key);
            }
        }
        return result;
    }

    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        MathSet<KeyType> result = new SeparateChainingHashST<KeyType>();
        for (KeyType key : keys()) {
            if (!other.contains(key)) {
                result.add(key);
            }
        }
        return result;
    }

    @Override
    public Iterable<KeyType> keys() {
        return hashTable.keys();
    }
}

