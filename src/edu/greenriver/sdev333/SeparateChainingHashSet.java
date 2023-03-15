package edu.greenriver.sdev333;

public class SeparateChainingHashSet<KeyType> implements MathSet<KeyType>  {

    @Override
    public void add(KeyType key) {

    }

    @Override
    public boolean contains(KeyType key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        return null;
    }

    @Override
    public MathSet<KeyType> intersection(MathSet<KeyType> other) {
        return null;
    }

    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        return null;
    }

    @Override
    public Iterable<KeyType> keys() {
        return null;
    }
}
