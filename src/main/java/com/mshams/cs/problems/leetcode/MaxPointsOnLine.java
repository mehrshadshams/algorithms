package com.mshams.cs.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnLine {
  public int maxPoints(int[][] points) {
    if (points.length < 3) return points.length;
    int max = 1;
    Map<Double, Integer> map = new HashMap<>();
    for (int i = 0; i < points.length; i++) {
      int overlap = 0, vertical = 0, currentMax = 0;
      for (int j = i + 1; j < points.length; j++) {
        int[] p1 = points[i];
        int[] p2 = points[j];
        int x_diff = p1[0] - p2[0];
        int y_diff = p1[1] - p2[1];
        if (x_diff == 0 && y_diff == 0) {
          overlap++;
        } else if (x_diff == 0) {
          vertical++;
        } else {
//          int g = gcd(x_diff, y_diff);
//          if (g != 0) {
//            x_diff /= g;
//            y_diff /= g;
//          }
          //List<Integer> key = Arrays.asList(y_diff, x_diff);

          double key = (double)(y_diff) / x_diff;
          map.put(key, map.getOrDefault(key, 0) + 1);
          currentMax = Math.max(currentMax, map.get(key));
        }
        currentMax = Math.max(currentMax, vertical);
      }
      max = Math.max(max, currentMax + overlap + 1);
      map.clear();
    }
    return max;
  }

  int gcd(int x, int y) {
    if (x == 0) return y;
    if (y == 0) return x;
    x = Math.abs(x);
    y = Math.abs(y);
    while (x != y) {
      if (x == 1 || y == 1) return 1;

      if ((x & 1) == 0 && (y & 1) == 0) {
        return gcd(x >>> 1, y >>> 1) << 1;
      } else if ((x & 1) == 0 && (y & 1) != 0) {
        x = x >>> 1;
      } else if ((x & 1) != 0 && (y & 1) == 0) {
        y = y >>> 1;
      } else if (x > y) {
        x = x - y;
      } else {
        y = y - x;
      }
    }
    return x;
  }

  public static void main(String[] args) {
    MaxPointsOnLine sol = new MaxPointsOnLine();
    System.out.println(sol.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
  }
}
