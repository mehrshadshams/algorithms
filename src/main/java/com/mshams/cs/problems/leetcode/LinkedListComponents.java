package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/linked-list-components/
 * <p>
 * We are given head, the head node of a linked list containing unique integer values.
 * <p>
 * We are also given the list G, a subset of the values in the linked list.
 * <p>
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 * <p>
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 * <p>
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 */
@Complexity(ComplexityLevel.MEDIUM)
public class LinkedListComponents {
  public int numComponents(ListNode head, int[] G) {
    Graph g = new Graph(G);
    ListNode prev = head;
    head = head.next;
    while (head != null) {
      GraphNode prevNode = g.vertex(prev.val);
      GraphNode currentNode = g.vertex(head.val);

      if (prevNode != null && currentNode != null) {
        prevNode.addEdge(currentNode.value);
      }

      prev = head;
      head = head.next;
    }

    int comp = 0;
    for (int i = 0; i < G.length; i++) {
      int v = G[i];
      GraphNode node = g.vertex(v);
      if (!node.visited) {
        comp += 1;
        dfs(g, node);
      }
    }

    return comp;
  }

  private void dfs(Graph g, GraphNode node) {
    node.visited = true;
    for (int e : node.edges) {
      GraphNode w = g.vertex(e);
      if (!w.visited) {
        dfs(g, w);
      }
    }
  }

  public static class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }

  private class Graph {
    private Map<Integer, GraphNode> nodes = new HashMap<>();

    Graph(int[] g) {
      for (int i : g) {
        nodes.put(i, new GraphNode(i));
      }
    }

    GraphNode vertex(int val) {
      return nodes.getOrDefault(val, null);
    }
  }

  private class GraphNode {
    int value;
    boolean visited;
    List<Integer> edges = new ArrayList<>();

    GraphNode(int val) {
      this.value = val;
    }

    void addEdge(int v) {
      edges.add(v);
    }
  }
}
