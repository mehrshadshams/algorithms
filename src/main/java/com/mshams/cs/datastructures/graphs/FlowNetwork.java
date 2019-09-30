package com.mshams.cs.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private final int v;
    private final List<FlowEdge>[] adj;
    private int edgeCount;

    public FlowNetwork(int v) {
        this.v = v;
        this.adj = (List<FlowEdge>[]) new ArrayList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    public Iterable<FlowEdge> adj(int vertex) {
        if (vertex < 0 || vertex >= v)
            throw new IllegalArgumentException();
        return adj[vertex];
    }

    public Iterable<FlowEdge> edges() {
        List<FlowEdge> edges = new ArrayList<>();
        for (List<FlowEdge> e : adj) {
            edges.addAll(e);
        }
        return edges;
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
        edgeCount++;
    }

    public int V() {
        return v;
    }

    public int E() {
        return edgeCount;
    }
}
