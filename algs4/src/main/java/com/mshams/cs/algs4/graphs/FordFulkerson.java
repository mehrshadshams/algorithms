package com.mshams.cs.algs4.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;

    public FordFulkerson(FlowNetwork g, int s, int t) {
        value = 0.0;
        while (hasAugmentingPath(g, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;

            // Compute Bottleneck capacity
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            // Augment Flow
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            value += bottle;
        }
    }

    public double value() {
        return this.value;
    }

    /**
     * Returns true if v is reachable from s
     *
     * @param v
     * @return
     */
    public boolean inCut(int v) {
        return marked[v];
    }

    private boolean hasAugmentingPath(FlowNetwork g, int s, int t) {
        marked = new boolean[g.V()];
        edgeTo = new FlowEdge[g.V()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (FlowEdge e : g.adj(v)) {
                int w = e.other(v);
                if (e.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }

        return marked[t];
    }
}
