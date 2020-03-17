package com.mshams.cs.datastructures.graphs;

public class FlowEdge {
  private final int v;
  private final int w;
  private final double capacity;
  private double flow;

  public FlowEdge(int v, int w, double capacity) {
    this.v = v;
    this.w = w;
    this.capacity = capacity;
  }

  public int from() {
    return v;
  }

  public int to() {
    return w;
  }

  public int other(int vertex) {
    if (vertex == v)
      return w;
    else if (vertex == w)
      return v;
    throw new IllegalArgumentException();
  }

  public double capacity() {
    return capacity;
  }

  public double flow() {
    return flow;
  }

  public double residualCapacityTo(int vertex) {
    if (vertex == this.v)
      return flow;
    else if (vertex == this.w)
      return capacity - flow;
    throw new IllegalArgumentException();
  }

  public void addResidualFlowTo(int vertex, double delta) {
    if (vertex == v)
      flow -= delta;
    else if (vertex == w)
      flow += delta;
    throw new IllegalArgumentException();
  }
}
