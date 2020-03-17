package com.mshams.cs.problems.legacy;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {
  public void findShortestPath(Graph g, Vertex s, Vertex w) {
    PriorityQueue<Vertex> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

    for (Vertex v : g.vertices) {
      q.add(v);
      v.weight = Integer.MAX_VALUE;
    }

    s.weight = 0;
    q.remove(s);
    q.add(s);

    while (!q.isEmpty()) {
      Vertex v = q.remove();

      int weight = v.weight;

      for (Edge e : v.edges) {
        Vertex n = e.target;
        int distance = e.weight + weight;
        if (distance < n.weight) {
          n.weight = distance;
          q.remove(n);
          q.add(n);
        }
      }
    }

    for (Vertex v : g.vertices) {
      System.out.println("Path from s to " + v.name + " : " + v.weight);
    }
  }

  public void test() {
    Graph g = new Graph();
    Vertex v1 = new Vertex("s");
    Vertex v2 = new Vertex("v");
    Vertex v3 = new Vertex("w");
    Vertex v4 = new Vertex("t");


    v1.edges.add(new Edge(v1, v2, 1));
    v1.edges.add(new Edge(v1, v3, 4));
    v2.edges.add(new Edge(v2, v3, 2));
    v2.edges.add(new Edge(v2, v4, 6));
    v3.edges.add(new Edge(v3, v4, 3));
    v3.edges.add(new Edge(v3, v1, 1));

    g.vertices.add(v1);
    g.vertices.add(v2);
    g.vertices.add(v3);
    g.vertices.add(v4);

    findShortestPath(g, v1, v4);
  }

  public class Graph {
    List<Vertex> vertices = new LinkedList<>();

  }

  public class Vertex {
    final String name;
    int id;
    int distance;
    int weight;
    List<Edge> edges = new LinkedList<>();

    public Vertex(String name) {
      this.name = name;
    }
  }

  public class Edge {
    Vertex source;
    Vertex target;
    int weight;

    public Edge(Vertex source, Vertex target, int weight) {
      this.source = source;
      this.target = target;
      this.weight = weight;
    }
  }
}
