package com.mshams.cs.datastructures.graphs;

import java.util.Iterator;
import java.util.Stack;

public class DfsPaths implements Paths {
  private boolean[] marked;
  private int[] edgeTo;
  private int start;

  public DfsPaths(IGraph graph, int s) {
    this(graph, s, true);
  }

  public DfsPaths(IGraph graph, int s, boolean recursive) {
    this.start = s;
    this.marked = new boolean[graph.V()];
    this.edgeTo = new int[graph.V()];
    if (recursive) {
      dfs(graph, s);
    } else {
      dfsNonRecursive(graph, s);
    }
  }

  public DfsPaths(IGraph graph, Iterable<Integer> sources) {
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    for (Integer s : sources) {
      if (!marked[s])
        dfs(graph, s);
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  @Override
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  @Override
  public Iterable<Integer> pathTo(int v) {
    Stack<Integer> stack = new Stack<>();
    while (edgeTo[v] != start) {
      stack.push(v);
      v = edgeTo[v];
    }
    stack.push(start);
    return stack;
  }

  @Override
  public int distTo(int v) {
    return -1;
  }

  private void dfs(IGraph graph, int s) {
    marked[s] = true;
    for (int w : graph.adj(s)) {
      if (!marked[w]) {
        edgeTo[w] = s;
        dfs(graph, w);
      }
    }
  }

  private void dfsNonRecursive(IGraph graph, int s) {
    Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[graph.V()];
    for (int v = 0; v < graph.V(); v++) {
      adj[v] = graph.adj(v).iterator();
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(s);
    marked[s] = true;

    while (!stack.isEmpty()) {
      int v = stack.peek();
      if (adj[v].hasNext()) {
        int w = adj[v].next();
        if (!marked[w]) {
          marked[w] = true;
          stack.push(w);
        }
      } else {
        stack.pop();
      }
    }
  }
}
