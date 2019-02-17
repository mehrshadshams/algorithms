package com.mshams.cs.algs4.graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private List<Edge>[] edges;
    private int E;

    public EdgeWeightedGraph(int v) {
        edges = (List<Edge>[]) new ArrayList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        edges[v].add(e);
        edges[w].add(e);
        E += 1;
    }

    public Iterable<Edge> adj(int v) {
        return edges[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> edges = new ArrayList<>();
        for (int v = 0; v < V(); v++) {
            int selfLoop = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) != v) {
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

    public int V() {
        return edges.length;
    }

    public int E() {
        return E;
    }

    public int degree(int v) {
        return edges[v].size();
    }
}
