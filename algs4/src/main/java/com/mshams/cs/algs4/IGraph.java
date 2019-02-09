package com.mshams.cs.algs4;

public interface IGraph {
    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int V();
}
