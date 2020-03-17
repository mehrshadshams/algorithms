package com.mshams.cs.datastructures.graphs;

public class ConnectedComponents {
  private boolean[] marked;
  private int[] id;
  private int[] size;
  private int count;

  public ConnectedComponents(Graph graph) {
    marked = new boolean[graph.V()];
    id = new int[graph.V()];
    size = new int[graph.V()];

    for (int v = 0; v < graph.V(); v++) {
      if (!marked[v]) {
        dfs(graph, v);
        count++;
      }
    }
  }

  private void dfs(Graph graph, int v) {
    id[v] = count;
    size[v] += 1;
    marked[v] = true;
    for (int w : graph.adj(v)) {
      if (!marked[w]) {
        dfs(graph, w);
      }
    }
  }

  public int count() {
    return this.count;
  }

  public int id(int v) {
    return id[v];
  }

  public int size(int v) {
    return size[v];
  }

  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }
}
