package com.mshams.cs.datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Prim's MST - Complexity O(m + nlg(n))
 * m edges, n nodes
 */
public class LazyPrimeMST implements MST {
    private List<Edge> mst;
    private boolean[] marked;
    private int weight;

    public LazyPrimeMST(EdgeWeightedGraph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        marked = new boolean[graph.V()];
        mst = new LinkedList<>();

        visit(pq, graph, 0);

        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;

            mst.add(e);
            weight += e.weight();

            if (!marked[v]) visit(pq, graph, v);
            if (!marked[w]) visit(pq, graph, w);
        }
    }

    private void visit(PriorityQueue<Edge> pq, EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge e : graph.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
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
