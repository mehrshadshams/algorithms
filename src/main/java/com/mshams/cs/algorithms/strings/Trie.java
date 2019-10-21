package com.mshams.cs.algorithms.strings;

import java.util.LinkedList;
import java.util.Queue;

public class Trie<TValue> {
    private static final int R = 256;
    private int n = 0;
    private Node root = new Node();

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
        if (node == null) {
            return null;
        }

        return (TValue) node.value;
    }

    public void delete(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key");
        }

        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int d) {
        if (node == null)
            return null;
        if (d >= key.length()) {
            if (node.value != null) {
                n--;
            }
            node.value = null;
        } else {
            char c = key.charAt(d);
            node.next[c] = delete(node.next[c], key, d + 1);
        }

        if (node.value != null) {
            return node;
        }
        for (int c = 0; c < R; c++) {
            if (node.next[c] != null) {
                return node;
            }
        }

        return null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), queue);
        return queue;
    }

    public String longestPrefixOf(String query) {
        if (query == null) throw new IllegalArgumentException();
        int length = longestPrefixOf(root, query, -1, 0);
        if (length == -1) return null;
        return query.substring(0, length);
    }

    private int longestPrefixOf(Node node, String query, int length, int d) {
        if (node == null) return length;
        if (node.value != null) {
            length = d;
        }
        if (d == query.length()) {
            return length;
        }
        char ch = query.charAt(d);
        return longestPrefixOf(node.next[d], query, length, d + 1);
    }

    private void collect(Node node, StringBuilder prefix, Queue<String> queue) {
        if (node == null)
            return;
        if (node.value != null) {
            queue.add(prefix.toString());
        }
        for (int c = 0; c < R; c++) {
            prefix.append(c);
            collect(node.next[c], prefix, queue);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private Node get(Node node, String key, int d) {
        if (node == null) {
            return null;
        }
        if (d == key.length()) {
            return node;
        }
        char c = key.charAt(d);
        return get(node.next[c], key, d + 1);
    }

    private Node put(Node node, String key, TValue value, int d) {
        if (node == null) {
            node = new Node();
        }

        if (d >= key.length()) {
            if (node.value == null) {
                n++;
            }
            node.value = value;
            return node;
        }

        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, value, d + 1);

        return node;
    }

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }
}
