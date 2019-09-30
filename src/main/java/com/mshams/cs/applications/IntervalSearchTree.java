package com.mshams.cs.applications;

public class IntervalSearchTree {
    private Node root;

    public void put(int lo, int hi) {
        if (intersects(lo, hi) != null) return;
        root = put(root, lo, hi);
    }

    private Node put(Node n, int lo, int hi) {
        if (n == null) return new Node(new Interval(lo, hi), hi);
        if (lo < n.interval.start()) n.left = put(n.left, lo, hi);
        else n.right = put(n.right, lo, hi);

        n.max = Math.max(n.max, hi);

        return n;
    }

    public Interval intersects(int lo, int hi) {
        Node x = root;
        while (x != null) {
            if (x.interval.intersects(lo, hi)) return x.interval;
            else if (x.left == null) x = x.right;
            else if (x.left.max < lo) x = x.right;
            else x = x.left;
        }
        return null;
    }

    private class Node {
        private Interval interval;
        private Node left;
        private Node right;
        private int max;

        public Node(Interval interval, int max) {
            this.interval = interval;
            this.max = max;
        }
    }
}
