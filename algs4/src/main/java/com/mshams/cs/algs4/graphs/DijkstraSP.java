package com.mshams.cs.algs4.graphs;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstraSP {
    private static final Double INFINITY = Double.POSITIVE_INFINITY;

    private final double[] dist;
    private final DirectedEdge[] edgeTo;

    public DijkstraSP(EdgeWeightedDigraph graph, int s) {
        for (DirectedEdge e : graph.edges()) {
            if (e.weight() < 0)
                throw new IllegalArgumentException("Graph can't have negative weights");
        }

        this.dist = new double[graph.V()];
        this.edgeTo = new DirectedEdge[graph.V()];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = INFINITY;
        }

        dist[s] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(s, dist[s]));

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            for (DirectedEdge e : graph.adj(v.index)) {
                relax(pq, e);
            }
        }
    }

    public double distTo(int v) {
        return dist[v];
    }

    public boolean hasPathTo(int v) {
        return dist[v] < INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        DirectedEdge e = edgeTo[v];
        while (e != null) {
            path.push(e);
            e = edgeTo[e.from()];
        }
        return path;
    }

    private void relax(PriorityQueue<Vertex> pq, DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (dist[w] > dist[v] + e.weight()) {
            dist[w] = dist[v] + e.weight();
            edgeTo[w] = e;
            Vertex vertex2 = new Vertex(w, dist[w]);
            pq.remove(vertex2);
            pq.add(vertex2);
        }
    }

    private class Vertex implements Comparable<Vertex> {
        private final int index;
        private final double dist;

        private Vertex(int v, double dist) {
            this.index = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(dist, o.dist);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(index);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this == obj) return true;

            if (!(obj instanceof Vertex)) {
                return false;
            }

            Vertex v = (Vertex) obj;

            return v.index == this.index;
        }
    }
}
