package com.mshams.cs.algorithms.graph;

import com.mshams.cs.datastructures.graphs.CycleDetector;
import com.mshams.cs.datastructures.graphs.DirectedEdge;
import com.mshams.cs.datastructures.graphs.EdgeWeightedDigraph;

import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private Queue<Integer> queue;
    private boolean[] onQueue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFord(EdgeWeightedDigraph g, int s) {
        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        onQueue = new boolean[g.V()];

        for (int v=0; v<g.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        queue = new LinkedList<>();
        queue.add(s);
        onQueue[s] = true;

        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.poll();
            onQueue[v] = false;
            relax(g, v);
        }
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQueue[w]) {
                    onQueue[w] = true;
                    queue.add(w);
                }
            }
            if (++cost % g.V() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;
            }
        }
    }

    private void findNegativeCycle() {
        // TODO: Find cycles for EdgeWeightedDigraph
    }

    private boolean hasNegativeCycle() {
        return cycle != null;
    }
}
