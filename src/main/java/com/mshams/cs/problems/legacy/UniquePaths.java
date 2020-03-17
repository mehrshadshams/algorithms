package com.mshams.cs.problems.legacy;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/
 */
public class UniquePaths extends Problem {
  public int uniquePaths(int m, int n) {
    int[][] memo = new int[m][n];
    for (int i = 0; i < m; i++) {
      int[] row = new int[n];
      Arrays.fill(row, -1);
      memo[i] = row;
    }

//        int[][] memo = new int[m][n];
//        for (int i=0; i<m; i++) {
//            int[] row = new int[n];
//            Arrays.fill(row, 1);
//            memo[i] = row;
//        }
//
//        for (int i=1; i<m; i++) {
//            for (int j=1; j<n; j++) {
//                memo[i][j] = memo[i-1][j] + memo[i][j-1];
//            }
//        }
//
//        return memo[m-1][n - 1];

    return uniquePaths(0, 0, m, n, memo);
  }

  private int uniquePaths(int i, int j, int m, int n, int[][] memo) {
    if (i >= m || j >= n) {
      return 0;
    }

    if (i == m - 1 && j == n - 1) {
      memo[i][j] = 0;
      return 1;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    int paths = uniquePaths(i + 1, j, m, n, memo) +
            uniquePaths(i, j + 1, m, n, memo);
    memo[i][j] = paths;

    return paths;
  }

  @Override
  void run() {

  }
}
