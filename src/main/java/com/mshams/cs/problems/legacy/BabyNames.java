package com.mshams.cs.problems.legacy;

import java.util.*;

public class BabyNames extends Problem {
  public Map<String, Integer> findFreq(Map<String, Integer> freq, List<List<String>> syn) {
    Graph graph = new Graph();
    for (String name : freq.keySet()) {
      graph.addNode(new Node(name, freq.get(name)));
    }
    for (List<String> list : syn) {
      graph.addSyn(list.get(0), list.get(1));
    }

    Map<String, Integer> trueFreq = new HashMap<>();
    for (String s : graph.nodes.keySet()) {
      int f = buildFreq(graph, s);
      if (f != 0) {
        trueFreq.put(s, f);
      }
    }
    return trueFreq;
  }

  private int buildFreq(Graph graph, String node) {
    Node n = graph.nodes.get(node);
    if (n.visited) {
      return 0;
    }

    int freq = n.freq;
    n.visited = true;

    List<String> edge = graph.edges.getOrDefault(n.name, new ArrayList<>());
    for (String e : edge) {
      freq += buildFreq(graph, e);
    }

    return freq;
  }

  @Override
  void run() {
    // see page 187
    Map<String, Integer> orig = new HashMap<>();
    orig.put("john", 15);
    orig.put("johnny", 5);
    orig.put("jon", 12);
    orig.put("chris", 13);
    orig.put("kris", 4);
    orig.put("christopher", 15);

    Map<String, Integer> map = findFreq(orig,
            Arrays.asList(Arrays.asList("jon", "john"), Arrays.asList("john", "johnny"), Arrays.asList("chris", "kris"),
                    Arrays.asList("chris", "christopher")));

    for (String k : map.keySet()) {
      System.out.println(k + " " + map.get(k));
    }
  }

  class Graph {
    Map<String, Node> nodes = new HashMap<>();
    Map<String, List<String>> edges = new HashMap<>();

    void addNode(Node node) {
      this.nodes.put(node.name, node);
    }

    void addSyn(String n1, String n2) {
      List<String> l = edges.getOrDefault(n1, new ArrayList<>());
      l.add(n2);
      edges.put(n1, l);
    }
  }

  class Node {
    String name;
    int freq;
    boolean visited;

    public Node(String name, int freq) {
      this.name = name;
      this.freq = freq;
    }
  }
}
