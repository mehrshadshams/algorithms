package com.mshams.cs.datastructures.searching;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value>, Iterable<Key> {
    private Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(getRoot(), key, value);
    }

    @Override
    public void delete(Key key) {
        root = delete(getRoot(), key);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return getRoot() != null ? getRoot().size : 0;
    }

    @Override
    public boolean isEmpty() {
        return getRoot() == null;
    }

    @Override
    public Key min() {
        if (getRoot() == null)
            throw new NoSuchElementException();
//        Node node = root;
//        Key min = null;
//        while (node != null) {
//            min = node.key;
//            node = node.left;
//        }
//        return min;
        return min(getRoot()).key;
    }

    @Override
    public Key max() {
        if (getRoot() == null)
            throw new NoSuchElementException();
//        Node node = root;
//        Key max = null;
//        while (node != null) {
//            max = node.key;
//            node = node.right;
//        }
//        return max;
        return max(getRoot()).key;
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(getRoot(), key);
        if (node == null) return null;
        return node.key;
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(getRoot(), key);
        if (node == null)
            return null;
        return node.key;
    }

    @Override
    public int rank(Key key) {
        return rank(key, getRoot());
    }

    @Override
    public Key select(int k) {
        Node node = select(getRoot(), k);
        return node.key;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(getRoot());
    }

    @Override
    public void deleteMax() {
        root = deleteMax(getRoot());
    }

    @Override
    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        return rank(hi) - rank(lo);
    }

    @Override
    public Value get(Key key) {
        // Iterative find
        Node node = getRoot();
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0)
                return node.value;
            else if (cmp < 0)
                node = node.left;
            else
                node = node.right;
        }

        // TODO: Recursive find

        return null;
    }

    public int height() {
        return height(getRoot());
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(getRoot());
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            keys.add(n.key);
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
        return keys;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inorder(getRoot(), queue);
        return queue;
    }

    public Iterable<Key> keys(Key min, Key max) {
        Queue<Key> queue = new LinkedList<>();
        keys(queue, getRoot(), min, max);
        return queue;
    }

    @Override
    public Iterator<Key> iterator() {
        return keys().iterator();
    }

    protected Node getRoot() {
        return root;
    }

    /**
     * Hibbard deletion
     *
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
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
        if (node.left == null) {
            Node k = select(getRoot(), 1);
            k.pred = null;
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            Node k = select(getRoot(), size() - 1);
            k.succ = null;
            return node.left;
        }
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

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) {
            Node t = ceiling(node.left, key);
            if (t != null) return t;
            return node;
        }
        return ceiling(node.right, key);
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

    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void keys(Queue<Key> queue, Node node, Key min, Key max) {
        if (node == null) return;
        int minCmp = min.compareTo(node.key);
        int maxCmp = max.compareTo(node.key);
        if (minCmp < 0) {
            keys(queue, node.left, min, max);
        }
        if (minCmp <= 0 && maxCmp >= 0) {
            queue.add(node.key);
        }
        if (maxCmp > 0) {
            keys(queue, node.right, min, max);
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            Node n = new Node(key, value);
            n.pred = floor(getRoot(), key);
            n.succ = ceiling(getRoot(), key);
            return n;
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

    private void check() {
        if (!isBST()) throw new IllegalStateException();
        if (!isSizeConsistent()) throw new IllegalStateException();
        //if (!isRankConsistent()) throw new IllegalStateException();
    }

    private boolean isBST() {
        return isBST(getRoot(), null, null);
    }

    private boolean isBST(Node node, Key min, Key max) {
        if (node == null) return true;
        boolean valid = true;
        if (min != null) {
            valid &= node.key.compareTo(min) > 0;
        }
        if (valid && max != null) {
            valid &= node.key.compareTo(max) <= 0;
        }
        if (!valid) return false;
        return isBST(node.left, min, node.key) &&
                isBST(node.right, node.key, max);
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(getRoot());
    }

    private boolean isSizeConsistent(Node node) {
        if (node == null) return true;
        return (node.size == 1 + size(node.left) + size(node.right)) &&
                isSizeConsistent(node.left) && isSizeConsistent(node.left);
    }

    class Node {
        private final Key key;
        private Value value;
        private int size;

        private Node left;
        private Node right;

        private Node succ;
        private Node pred;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
