package com.mshams.cs.problems.kleinbergtardos.chapter6;

import java.util.ArrayList;
import java.util.List;

public class IndependentSetInSimpleGraph {
  public List<Integer> findSet(int[] graph) {
    // here we assume graph is connected and simple, meaning each node is connected to the next one

    int[] dp = new int[graph.length + 1];

    dp[1] = graph[0];
    dp[2] = graph[1];

    for (int i = 2; i < graph.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + graph[i]);
    }

    List<Integer> output = new ArrayList<>();
    for (int i = dp.length - 1; i > 1; ) {
      if (dp[i] == dp[i - 2] + graph[i]) {
        output.add(0, i);
        i -= 2;
      } else {
        i--;
      }
    }

    return output;
  }
}
