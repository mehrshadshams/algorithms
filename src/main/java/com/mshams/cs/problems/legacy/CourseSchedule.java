package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.mshams.cs.problems.legacy.Utils.array;

public class CourseSchedule extends Problem {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Node> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new Node(i));
    }
    for (int i = 0; i < prerequisites.length; i++) {
      int current = prerequisites[i][0];
      int pre = prerequisites[i][1];
      graph.get(pre).edges.add(current);
    }

    boolean hasCycle = false;
    for (int i = 0; i < graph.size(); i++) {
      hasCycle = detectCycles(graph, i);
      if (hasCycle) {
        break;
      }
    }

    return !hasCycle;
  }

  boolean detectCycles(List<Node> nodes, int index) {
    Node node = nodes.get(index);

    if (node.expanded && !node.visited) {
      return true;
    }

    node.expanded = true;
    for (int out : node.edges) {
      boolean cycle = detectCycles(nodes, out);
      if (cycle) {
        return true;
      }
    }
    node.visited = true;

    return false;
  }

  @Override
  void run() {
    boolean f = canFinish(3, new int[][]{array(0, 1), array(0, 2), array(1, 2)});
    System.out.println(f);
  }

  class Node {
    int index;
    boolean visited = false;
    boolean expanded = false;
    Set<Integer> edges = new HashSet<>();

    Node(int index) {
      this.index = index;
    }
  }
}
