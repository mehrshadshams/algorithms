package com.mshams.cs.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private List<DirectedEdge>[] edges;
    private int edgeCount;

    public EdgeWeightedDigraph(int v) {
        edges = (List<DirectedEdge>[]) new ArrayList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public int V() {
        return edges.length;
    }

    public int E() {
        return this.edgeCount;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        edges[v].add(e);
        edgeCount++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return edges[v];
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> edges = new ArrayList<>();
        for (int v = 0; v < V(); v++) {
            int selfLoop = 0;
            for (DirectedEdge e : adj(v)) {
                if (e.to() != v) {
                    edges.add(e);
                } else {
                    if (selfLoop % 2 == 0)
                        edges.add(e);
                    selfLoop++;
                }
            }
        }

        return edges;
    }
}
