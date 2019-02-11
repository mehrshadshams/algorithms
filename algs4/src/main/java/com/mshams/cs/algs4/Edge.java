package com.mshams.cs.algs4;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        return vertex == v ? vertex : w;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(weight, o.weight);
    }
}
