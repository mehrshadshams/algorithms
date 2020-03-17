package com.mshams.cs.problems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/campus-bikes-ii/
 */
public class BikeAssignment {
  public int assignBikes(int[][] workers, int[][] bikes) {
    Point[] p = new Point[10];

    List<Point> w = new ArrayList<>();
    for (int i = 0; i < workers.length; i++)
      w.add(new Point(i, workers[i][0], workers[i][1]));

    List<Point> b = new ArrayList<>();
    for (int i = 0; i < bikes.length; i++)
      b.add(new Point(i, bikes[i][0], bikes[i][1]));

    Map<Integer, Integer> dp = new HashMap<>();

    return findBest(w, b, 0, 0, new int[1 << bikes.length]);
  }

  private int findBest(List<Point> workers, List<Point> bikes, int workerId, int used, int[] dp) {
    if (workerId == workers.size()) return 0;
    if (dp[used] > 0) return dp[used];
    Point worker = workers.get(workerId);
    int minDistance = Integer.MAX_VALUE;
    for (int j = 0; j < bikes.size(); j++) {
      Point b = bikes.get(j);
        if ((used & (1 << j)) == 0) {
        used |= 1 << j;
        minDistance = Math.min(minDistance, manhattan(worker, b) +
                findBest(workers, bikes, workerId + 1, used, dp));
        used &= ~(1 << j);
      }
    }

    return dp[used] = minDistance;
  }

  private int manhattan(Point p, Point q) {
    return Math.abs(p.x - q.x) + Math.abs(p.y - q.y);
  }

  private class Point {
    int index;
    int x;
    int y;

    Point(int i, int a, int b) {
      this.index = i;
      this.x = a;
      this.y = b;
    }

    @Override
    public String toString() {
      return "[" + x + "," + y + "]";
    }
  }
}
