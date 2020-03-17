package com.mshams.cs.datastructures.graphs;

import java.util.Stack;

public class TopologicalSort {
  private boolean[] marked;
  private Stack<Integer> reversePost;

  public TopologicalSort(IGraph graph) {
    reversePost = new Stack<>();
    marked = new boolean[graph.V()];
    for (int i = 0; i < graph.V(); i++) {
      if (!marked[i]) {
        dfs(graph, i);

      }
    }
  }

  private void dfs(IGraph graph, int v) {
    marked[v] = true;
    for (int w : graph.adj(v)) {
      if (!marked[w]) {
        dfs(graph, w);
      }
    }
    reversePost.push(v);
  }

  public Stack<Integer> reversePost() {
    return reversePost;
  }
}
