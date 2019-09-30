package com.mshams.cs.datastructures.graphs;

import java.util.Stack;

public class CycleDetector {
    private final boolean[] marked;
    private final int[] edgeTo;
    private Stack<Integer> cycle;

    public CycleDetector(Digraph digraph) {
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];

        for (int i = 0; i < digraph.V(); i++) {
            if (!marked[i]) {
                dfs(digraph, -1, i);
            }
        }
    }

    private void dfs(Digraph digraph, int u, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, v, w);
            } else if (w != u) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
