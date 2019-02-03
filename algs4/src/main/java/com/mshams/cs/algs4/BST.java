package com.mshams.cs.algs4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value>, Iterable<Key> {
    private Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return root != null ? root.size : 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Key min() {
        if (root == null)
            throw new NoSuchElementException();
//        Node node = root;
//        Key min = null;
//        while (node != null) {
//            min = node.key;
//            node = node.left;
//        }
//        return min;
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    @Override
    public Key max() {
        if (root == null)
            throw new NoSuchElementException();
//        Node node = root;
//        Key max = null;
//        while (node != null) {
//            max = node.key;
//            node = node.right;
//        }
//        return max;
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        return x;
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null)
            return null;
        return node.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        return x;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    @Override
    public Key select(int k) {
        Node node = select(root, k);
        return node.key;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0)
                return node.value;
            else if (cmp < 0)
                node = node.left;
            else
                node = node.right;
        }

        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    @Override
    public Iterator<Key> iterator() {
        return keys().iterator();
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Hibbard deletion
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node, key);
        } else if (cmp > 0) {
            node.right = delete(node, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private int rank(Key key, Node node) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(key, node.left);
        else if (cmp > 0)
            return 1 + size(node.left) + rank(key, node.right);
        else
            return size(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int t = size(node.left);
        if (t > k)
            return select(node.left, k);
        if (t < k)
            return select(node.right, k - t - 1);
        return node;
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    private void inorder(Node node, Queue<Key> keys) {
        if (node == null)
            return;
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
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
