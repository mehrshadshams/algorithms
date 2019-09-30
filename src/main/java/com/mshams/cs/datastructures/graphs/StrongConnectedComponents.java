package com.mshams.cs.datastructures.graphs;

import java.util.Stack;

public class StrongConnectedComponents {
    private final boolean[] marked;
    private final int[] scc;
    private int count;

    public StrongConnectedComponents(Digraph digraph) {
        scc = new int[digraph.V()];
        marked = new boolean[digraph.V()];

        Digraph reverse = digraph.reverse();
        TopologicalSort topologicalSort = new TopologicalSort(reverse);
        final Stack<Integer> stack = topologicalSort.reversePost();

        for (int v : stack) {
            if (!marked[v]) {
                dfs(digraph, v);
                count++;
            }
        }
    }

    public int count() {
        return this.count;
    }

    public int id(int v) {
        return scc[v];
    }

    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                scc[w] = count;
                dfs(digraph, w);
            }
        }
    }
}
