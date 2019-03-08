package com.mshams.cs.algs4.searching;

public class AVLTree<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Node root;

    @Override
    public Value get(Key key) {
        Node n = get(root, key);
        if (n == null) return null;
        return n.value;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }    

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node n, Key key) {
        if (n == null) return null;
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.left = delete(n.left, key);
        } else if (cmp > 0) {
            n.right = delete(n.right, key);
        } else {
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;

        }

        return n;
    }

    @Override
    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    @Override
    public int size() {
        return root != null ? root.size : 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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

    private Node put(Node n, Key key, Value value) {
        if (n == null) {
            return new Node(key, value, 0, 1);
        }
        
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.left = put(n.left, key, value);
        } else if (cmp > 0) {
            n.right = put(n.right, key, value);
        } else {
            n.value = value;
            return n;
        }

        n.size = 1 + size(n.left) + size(n.right);
        n.height = 1 + Math.max(height(n.left), height(n.right));

        final int balance = balanceFactor(n);
        
        if (balance > 1 && balanceFactor(n.left) > 0) {
            return rotateRight(n);
        }
        if (balance < -1 && balanceFactor(n.right) < 0) {
            return rotateLeft(n);
        }
        if (balance > 1 && balanceFactor(n.left) < 0) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        if (balance < -1 && balanceFactor(n.right) > 0) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }

        return n;
    }

    private Node get(Node n, Key key) {
        while (n != null) {
            int cmp = key.compareTo(n.key);
            if (cmp == 0) return n;
            if (cmp < 0) {
                n = n.left;
            }

            n = n.right;
        }

        return null;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));

        h.size = 1 + size(h.left) + size(h.right);
        h.height = 1 + Math.max(height(h.left), height(h.right));

        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));

        h.size = 1 + size(h.left) + size(h.right);
        h.height = 1 + Math.max(height(h.left), height(h.right));

        return x;
    }

    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private int size(Node n) {
        if (n == null) return 0;
        return 1 + size(n.left) + size(n.right);
    }

    private int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;
        private int height;

        Node(Key key, Value value, int height, int size) {
            this.key = key;
            this.value = value;
            this.height = height;
            this.size = size;
        }
    }
}