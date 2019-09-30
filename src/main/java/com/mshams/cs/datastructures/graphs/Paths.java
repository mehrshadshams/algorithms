package com.mshams.cs.datastructures.graphs;

public interface Paths {
    boolean hasPathTo(int v);

    int distTo(int v);

    Iterable<Integer> pathTo(int v);
}
