package com.mshams.cs.datastructures.graphs;

import java.util.ArrayList;

public class Graph implements IGraph {
  private final int v;
  private ArrayList<Integer>[] adj;

  public Graph(int v) {
    this.v = v;
    adj = new ArrayList[10];
    for (int i = 0; i < v; i++) {
      adj[i] = new ArrayList<>();
    }
  }

  @Override
  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  @Override
  public Iterable<Integer> adj(int v) {
    return this.adj[v];
  }

  public int V() {
    return this.v;
  }

  public Paths bfs(int s) {
    return new BfsPaths(this, s);
  }
}
