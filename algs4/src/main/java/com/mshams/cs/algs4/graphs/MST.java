package com.mshams.cs.algs4.graphs;

import com.mshams.cs.algs4.graphs.Edge;

public interface MST {
    Iterable<Edge> edges();

    double weight();
}
