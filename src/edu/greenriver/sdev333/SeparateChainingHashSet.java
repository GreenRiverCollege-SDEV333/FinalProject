package edu.greenriver.sdev333;

public class SeparateChainingHashSet<KeyType> implements MathSet<KeyType>  {
    // fields:
    // array of linked lists
    int m;
    private SequentialSearchSet<KeyType>[] st;

    public SeparateChainingHashSet(int m) {
        this.m = m;
        st = (SequentialSearchSet<KeyType>[]) new SequentialSearchSet[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchSet();
        }
    }

    private int hash(KeyType key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public void add(KeyType key) {
        st[hash(key)].put(key);
    }

    @Override
    public boolean contains(KeyType key) {
        return st[hash(key)].get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        int size = 0;
        for (SequentialSearchSet<KeyType> set : st) {
            size+= set.size();
        }
        return size;
    }

    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        MathSet<KeyType> union = new SeparateChainingHashSet<>(m);

        for (KeyType currentKey : this.keys()) {
            union.add(currentKey);
        }
        for (KeyType currentKey : other.keys()) {
            union.add(currentKey);
        }
        return union;
    }

    @Override
    public MathSet<KeyType> intersection(MathSet<KeyType> other) {
        MathSet<KeyType> intersection = new SeparateChainingHashSet<>(m);

        for (KeyType currentKey : this.keys()) {
            if (this.contains(currentKey) && other.contains(currentKey)) {
                intersection.add(currentKey);
            }
        }
        return intersection;
    }

    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        MathSet<KeyType> difference = new SeparateChainingHashSet<>(m);

        for (KeyType currentKey : this.keys()) {
            if (!other.contains(currentKey)) {
                difference.add(currentKey);
            }
        }
        return difference;
    }

    @Override
    public Iterable<KeyType> keys() {
        Queue<KeyType> keys = new Queue<>();

        for(SequentialSearchSet<KeyType> set : st) {
            for (KeyType key : set.keys()) {
                keys.enqueue(key);
            }
        }
        return keys;
    }
}