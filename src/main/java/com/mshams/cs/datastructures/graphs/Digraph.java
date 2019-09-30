package com.mshams.cs.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Digraph implements IGraph {
    private final int v;
    private final List<Integer>[] adj;
    private int e;

    public Digraph(int v) {
        this.v = v;
        this.adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        e++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    @Override
    public int V() {
        return v;
    }

    public int E() {
        return e;
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (int j : adj(i)) {
                reverse.addEdge(j, i);
            }
        }

        return reverse;
    }

    public boolean hasCycle() {
        return new CycleDetector(this).hasCycle();
    }
}
