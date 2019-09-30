package com.mshams.cs.algorithms.strings;

public class TST<TValue> {
    private Node root;

    public void put(String key, TValue value) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key");
        }

        root = put(root, key, value, 0);
    }

    public TValue get(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key");
        }

        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return node.value;
    }

    private Node get(Node node, String key, int d) {
        if (node == null)
            return null;
        char c = key.charAt(d);
        if (c < node.c)
            return get(node.left, key, d);
        else if (c > node.c)
            return get(node.right, key, d);
        else if (d < key.length() - 1)
            return get(node.middle, key, d + 1);
        else
            return node;
    }

    private Node put(Node node, String key, TValue value, int d) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c)
            node.left = put(node.left, key, value, d);
        else if (c > node.c)
            node.right = put(node.right, key, value, d);
        else if (d < key.length() - 1)
            node.middle = put(node.middle, key, value, d);
        else
            node.value = value;

        return node;
    }

    public class Node {
        private TValue value;
        private char c;
        private Node left;
        private Node middle;
        private Node right;
    }
}
