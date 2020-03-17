package com.mshams.cs.datastructures.graphs;

public interface IGraph {
  void addEdge(int v, int w);

  Iterable<Integer> adj(int v);

  int V();
}
