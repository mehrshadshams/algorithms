package com.mshams.cs.problems.leetcode;

import java.util.*;

public class CityAndMachines {

  int count;

  // Complete the minTime function below.
  int minTime(int[][] roads, int[] machines) {
    count = 0;
    Map<Integer, List<Edge>> graph = new HashMap<>();
    Set<Integer> m = new HashSet<>();
    for (int x : machines) {
      m.add(x);
    }

    int connections = 0;
    for (int[] road : roads) {
      int from = road[0];
      int to = road[1];
      int w = road[2];

      graph.putIfAbsent(from, new ArrayList<>());
      graph.putIfAbsent(to, new ArrayList<>());

      graph.get(from).add(new Edge(from, to, w));
      graph.get(to).add(new Edge(to, from, w));

    }

    int cost = 0;

    boolean[] visited = new boolean[graph.size()];
    int[] pre = new int[graph.size()];
    int[] low = new int[graph.size()];

    Arrays.fill(pre, -1);
    Arrays.fill(low, -1);

    List<Edge> bridges = new ArrayList<>();
    for (int v : graph.keySet()) {
      if (pre[v] == -1) {
        dfs(graph, pre, low, v, v, bridges);
      }
    }

    PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

    for (Edge b : bridges) {
      if (!m.contains(b.from) && !m.contains(b.to)) {
        continue;
      }

      pq.add(b);
    }

    while (!pq.isEmpty()) {
      Edge e = pq.poll();
      cost += e.weight;
      connections--;
    }

    return cost;
  }

  void dfs(Map<Integer, List<Edge>> g, int[] pre, int[] low, int u, int v,
           List<Edge> bridges) {
    pre[v] = count++;
    low[v] = pre[v];
    for (Edge e : g.get(v)) {
      int w = e.to;
      if (pre[w] == -1) {
        dfs(g, pre, low, v, w, bridges);
        low[v] = Math.min(low[v], low[w]);
        if (low[w] == pre[w]) {
          bridges.add(e);
        }
      } else if (w != u) {
        low[v] = Math.min(low[v], pre[w]);
      }
    }
  }

  static class Edge {
    int from;
    int to;
    int weight;

    Edge(int f, int t, int w) {
      this.from = f;
      this.to = t;
      this.weight = w;
    }
  }

  public static void main(String[] args) {
    CityAndMachines problem = new CityAndMachines();
    int[][] roads = new int[][]{
            {2, 1, 8},
            {1, 0, 5},
            {2, 4, 5},
            {1, 3, 4},
    };
    int[] machines = new int[]{2, 4, 0};
    System.out.println(problem.minTime(roads, machines));
  }
}
