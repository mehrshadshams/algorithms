package com.mshams.cs.algs4.searching;

import java.util.LinkedList;

public class SkipList<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private final LinkedList<Key> l0;

    public SkipList() {
        l0 = new LinkedList<>();

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }
}
