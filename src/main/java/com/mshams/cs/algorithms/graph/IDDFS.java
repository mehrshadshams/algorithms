package com.mshams.cs.algorithms.graph;

import com.mshams.cs.datastructures.graphs.IGraph;

/**
 * Iterative Deepening Depth First Search.
 *
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class IDDFS {
  private final IGraph graph;

  /**
   * Creates an instance of IDDFS search.
   * @param graph Graph object to work on
   */
  public IDDFS(IGraph graph) {
    this.graph = graph;
  }

  /**
   * Checks if target exists in the graph using IDDFS.
   * @param source source node
   * @param target target node
   * @param maxDepth max allowed depth to check
   * @return true if the node is found
   */
  public boolean find(int source, int target, int maxDepth) {
    for (int depth = 0; depth <= maxDepth; depth++) {
      if (dls(source, target, depth)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Depth Limited Search.
   *
   * @return true
   */
  private boolean dls(int node, int target, int depth) {
    if (node == target) {
      return true;
    }

    if (depth <= 0) {
      return false;
    }

    for (int w : this.graph.adj(node)) {
      if (dls(w, target, depth - 1)) {
        return true;
      }
    }

    return false;
  }
}
