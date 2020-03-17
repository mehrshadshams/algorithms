package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printArray;

public class CourseScheduler2 extends Problem {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer> list = new java.util.LinkedList<Integer>();
    List<Node> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      Node n = new Node(i);
      graph.add(n);
    }
    for (int i = 0; i < prerequisites.length; i++) {
      int current = prerequisites[i][0];
      int pre = prerequisites[i][1];
      graph.get(pre).edges.add(current);
    }

    boolean cycle = false;
    for (int i = 0; i < numCourses; i++) {
      cycle = dfs(graph, i, list);
      if (cycle) {
        return new int[0];
      }
    }

    int[] out = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      out[i] = list.get(i);
    }
    return out;
  }

  boolean dfs(List<Node> graph, int index, List<Integer> list) {
    Node node = graph.get(index);
    if (node.visited) {
      return false;
    }

    if (node.expanded) {
      return true;
    }

    boolean cycle = false;
    node.expanded = true;

    for (int out : node.edges) {
      cycle = dfs(graph, out, list);
      if (cycle) {
        return cycle;
      }
    }

    node.visited = true;

    if (!cycle) {
      list.add(0, index);
    }

    return cycle;
  }

  @Override
  void run() {
    int nCourses = 3;

//        int[][] pre = new int[][] { array(1, 0) };
    int[][] pre = new int[][]
            {array(0, 2), array(1, 2), array(2, 0)};
//                { array(0, 1), array(1, 0) };
    int[] out = findOrder(nCourses, pre);

    printArray(out);
  }

  class Node {
    int index;
    boolean visited;
    boolean expanded;
    Set<Integer> edges = new HashSet<>();

    Node(int index) {
      this.index = index;
    }
  }
}
