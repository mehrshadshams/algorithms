package com.mshams.cs.algs4;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.mshams.cs.algs4.applications.UF;
import com.mshams.cs.algs4.applications.WeightedQuickUnionUF;

public class KruskalMST implements MST {
    private final List<Edge> mst;
    private double weight;

    public KruskalMST(EdgeWeightedGraph graph) {
        UF uf = new WeightedQuickUnionUF(graph.V());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge e : graph.edges()) {
            pq.add(e);
        }

        weight = 0.0;
        mst = new LinkedList<>();
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
                weight += e.weight();
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return this.weight;
    }
}
