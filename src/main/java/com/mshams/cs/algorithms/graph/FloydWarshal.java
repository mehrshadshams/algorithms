package com.mshams.cs.algorithms.graph;

import com.mshams.cs.datastructures.graphs.DirectedEdge;
import com.mshams.cs.datastructures.graphs.EdgeWeightedDigraph;

import java.util.Arrays;

public class FloydWarshal {
  private final double[][] distances;

  public FloydWarshal(EdgeWeightedDigraph graph) {
    final int v = graph.V();
    distances = new double[v][v];
    for (int i = 0; i < v; i++) {
      Arrays.fill(distances[i], Double.POSITIVE_INFINITY);
    }

    for (int i = 0; i < v; i++) {
      Iterable<DirectedEdge> edges = graph.adj(i);
      for (DirectedEdge e : edges) {
        distances[i][e.to()] = e.weight();
      }
    }

    for (int i = 0; i < v; i++) {
      distances[i][i] = 0.0;
    }

    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++) {
        for (int k = 0; k < v; k++) {
          if (distances[i][j] > distances[i][k] + distances[k][j]) {
            distances[i][j] = distances[i][k] + distances[k][j];
          }
        }
      }
    }
  }

  public double getMinimumDistance(int v, int w) {
    return distances[v][w];
  }
}
