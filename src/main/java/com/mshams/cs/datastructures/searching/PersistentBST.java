package com.mshams.cs.datastructures.searching;

import java.util.NoSuchElementException;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class PersistentBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Stack<Node> roots = new Stack<>();

    @Override
    public Value get(Key key) {
        if (roots.empty())
            throw new NoSuchElementException();
        Node n = get(getRoot(), key);
        if (n == null)
            throw new NoSuchElementException();
        return n.value;
    }

    private Node get(Node n, Key key) {
        while (n != null) {
            int cmp = key.compareTo(n.key);
            if (cmp == 0)
                return n;
            if (cmp < 0)
                n = n.left;
            else
                n = n.right;
        }

        return null;
    }

    @Override
    public void put(Key key, Value val) {
        Node root = getRoot();
        roots.push(put(root, key, val));
    }

    private Node put(Node n, Key key, Value value) {
        if (n == null) {
            return new Node(key, value);
        }

        Node x = copy(n);

        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            x.left = put(n.left, key, value);
        } else if (cmp > 0) {
            x.right = put(n.right, key, value);
        } else {
            x.value = value;
        }

        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }

    private int size(Node n) {
        if (n == null)
            return 0;
        return 1 + size(n.left) + size(n.right);
    }

    private Node copy(Node n) {
        Node x = new Node(n.key, n.value);
        x.left = n.left;
        x.right = n.right;
        x.size = n.size;
        return x;
    }

    private Node getRoot() {
        if (roots.empty())
            return null;
        return roots.peek();
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

    private class Node {
        private final Key key;
        private Value value;
        private int size;

        private Node left;
        private Node right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
