package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.array;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class KthSmallestElement extends Problem {
  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;
    int smallest = Integer.MAX_VALUE;
    int[] ind = new int[m];
    int i = 0;
    while (i < k) {
      smallest = Integer.MAX_VALUE;
      int smallest_idx = 0;
      for (int j = 0; j < m; j++) {
        int w = ind[j];
        if (w < n) {
          int x = matrix[j][w];
          if (x < smallest) {
            smallest = x;
            smallest_idx = j;
          }
        }
      }
      ind[smallest_idx] += 1;
      i++;
    }
    return smallest;
  }

  @Override
  void run() {
    int[][] matrix = new int[][]{
            array(1, 5, 9),
            array(10, 11, 13),
            array(12, 13, 15)
    };
    kthSmallest(matrix, 8);
  }
}
