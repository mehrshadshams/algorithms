package com.mshams.cs.problems.legacy;

import java.util.*;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class WordTransformer extends Problem {

  public List<String> transform(String word, String target, Set<String> dict) {
    Map<String, List<String>> mapping = buildMapping(dict);

    Graph graph = buildGraph(new ArrayList<>(dict), mapping);
    List<String> list = new ArrayList<>();

    Node start = graph.nodes.get(word);
    Node end = graph.nodes.get(target);

    dfs(graph, start, end, list);

    return list;
  }

  private Map<String, List<String>> buildMapping(Set<String> dict) {
    Map<String, List<String>> mapping = new HashMap<>();
    for (String word : dict) {
      List<String> wildcards = getWildcards(word);
      for (String wildcard : wildcards) {
        final List<String> list = mapping.getOrDefault(wildcard, new ArrayList<>());
        list.add(word);
        mapping.put(wildcard, list);
      }
    }
    return mapping;
  }

  private List<String> getWildcards(String word) {
    List<String> wildcards = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      String wildcard = word.substring(0, i) + "_" + word.substring(i + 1);
      wildcards.add(wildcard);
    }
    return wildcards;
  }

  private boolean dfs(Graph graph, Node start, Node end, List<String> list) {
    if (start == end) {
      start.visited = true;
      list.add(end.word);
      return true;
    }

    if (start.visited) {
      return false;
    }

    start.visited = true;
    boolean result = false;

    List<Node> nodes = graph.edges.getOrDefault(start, new ArrayList<>());
    for (Node n : nodes) {
      if (dfs(graph, n, end, list)) {
        result = true;
        list.add(n.word);
        break;
      }
    }

    return result;
  }

  private Graph buildGraph(List<String> dict, Map<String, List<String>> map) {
    Graph graph = new Graph();

    for (int i = 0; i < dict.size(); i++) {
      String word = dict.get(i);
      Node node = new Node(word);
      graph.nodes.put(word, node);
    }

    for (Node node : graph.nodes.values()) {
      graph.edges.put(node, new ArrayList<>());

      List<String> wildcards = getWildcards(node.word);

      for (String w : wildcards) {
        final List<String> connectedWords = map.get(w);
        for (String w2 : connectedWords) {
          Node node2 = graph.nodes.get(w2);
          if (node != node2) {
            graph.edges.get(node).add(node2);
          }
        }
      }

    }

    return graph;
  }

  private boolean isOneEdit(String w1, String w2) {
    int edit = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        edit++;
      }
    }
    return edit == 1;
  }

  @Override
  void run() {
    printArray(transform("damp", "like",
            new HashSet<>(Arrays.asList("damp", "lamp", "lump", "limp", "lime", "like"))));
  }

  class Graph {
    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> edges = new HashMap<>();
  }

  class Node {
    final String word;
    boolean visited;

    public Node(String word) {
      this.word = word;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Node node = (Node) o;
      return Objects.equals(word, node.word);
    }

    @Override
    public int hashCode() {
      return Objects.hash(word);
    }

    @Override
    public String toString() {
      return word;
    }
  }
}
