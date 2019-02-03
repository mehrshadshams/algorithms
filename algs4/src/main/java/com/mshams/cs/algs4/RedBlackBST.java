package com.mshams.cs.algs4;

import org.apache.commons.lang3.NotImplementedException;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    @Override
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.value;
        }
        return null;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    @Override
    public void delete(Key key) {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Key min() {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public Key max() {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public Key ceiling(Key key) {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public Key floor(Key key) {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public int rank(Key key) {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public Key select(int k) {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public void deleteMin() {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public void deleteMax() {
        throw new NotImplementedException("Not Implemented");
    }

    @Override
    public int size(Key lo, Key hi) {
        throw new NotImplementedException("Not Implemented");
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null)
            return new Node(key, value, RED, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;

        if (isRed(x.right) && !isRed(x.left))
            x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left))
            x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right))
            flipColors(x);

        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    private void flipColors(Node node) {
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
        node.color = !node.color;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.size = size(x.left) + size(x.right) + 1;
        h.size = size(h.left) + size(h.right) + 1;

        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private boolean isRed(Node node) {
        return node != null ? node.color == RED : BLACK;
    }

    private class Node {
        private final Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }
}
