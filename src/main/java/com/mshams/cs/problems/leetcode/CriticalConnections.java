package com.mshams.cs.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a
 * network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 *
 * <p>
 * https://leetcode.com/problems/critical-connections-in-a-network/
 */
public class CriticalConnections {
  int time = 0;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> res = new ArrayList<>();
    if (n < 1) return res;
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (List<Integer> conn : connections) {
      graph.get(conn.get(0)).add(conn.get(1));
      graph.get(conn.get(1)).add(conn.get(0));
    }

    int[] disc = new int[n];
    Arrays.fill(disc, -1);
    int[] low = new int[n];

    for (int i = 0; i < n; i++) {
      if (disc[i] == -1) {
        dfs(res, graph, i, low, disc, -1);
      }
    }

    return res;
  }

  void dfs(List<List<Integer>> res, List<List<Integer>> graph, int u, int[] low, int[] disc, int parent) {
    low[u] = disc[u] = time++;
    for (int v : graph.get(u)) {
      if (v == parent) continue;
      if (disc[v] == -1) {
        dfs(res, graph, v, low, disc, u);
        low[u] = Math.min(low[u], low[v]);
        if (low[v] > disc[u]) {
          res.add(Arrays.asList(u, v));
        }
      } else {
        low[u] = Math.min(low[u], disc[v]);
      }
    }
  }
}
