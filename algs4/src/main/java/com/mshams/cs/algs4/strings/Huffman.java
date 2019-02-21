package com.mshams.cs.algs4.strings;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.PriorityQueue;

public class Huffman {
    private static final int R = 256;

    private Huffman() {
    }

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left;
        private final Node right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    public static byte[] compress(String text) {
        char[] input = text.toCharArray();
        int[] freq = new int[R];
        for (char ch : text.toCharArray()) {
            freq[ch]++;
        }

        Node root = buildTrie(freq);

        String[] st = new String[R];
        buildCode(st, root, "");

        byte[] trie = writeTrie(root);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bos);
        try {
            out.write(trie.length);
            out.write(trie);

            for (int i = 0; i < input.length; i++) {
                String code = st[input[i]];
                for (char c : code.toCharArray()) {
                    if (c == '0') {
                        out.writeBoolean(false);
                    } else if (c == '1') {
                        out.writeBoolean(true);
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bos.toByteArray();
    }

    private static byte[] writeTrie(Node root) {
        ByteArrayOutputStream trieBos = new ByteArrayOutputStream();
        writeTrie(root, trieBos);
        try {
            trieBos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trieBos.toByteArray();
    }

    private static void writeTrie(Node x, ByteArrayOutputStream bos) {
        if (x.isLeaf()) {
            bos.write((byte) 1);
            bos.write(x.ch);
            return;
        }
        bos.write((byte) 0);
        writeTrie(x.left, bos);
        writeTrie(x.right, bos);
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + "0");
            buildCode(st, x.right, s + "1");
        } else {
            st[x.ch] = s;
        }
    }

    private static Node buildTrie(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < R; i++) {
            if (freq[i] != 0)
                pq.add(new Node((char) i, freq[i], null, null));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node n = new Node('\0', left.freq + right.freq, left, right);
            pq.add(n);
        }

        return pq.poll();
    }
}
