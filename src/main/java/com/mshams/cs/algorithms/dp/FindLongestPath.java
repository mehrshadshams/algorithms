package com.mshams.cs.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class FindLongestPath {
  public static void main(String[] args) {
    int M[][] =
            {
                    {10, 13, 14, 21, 23},
                    {11, 9, 22, 2, 3},
                    {12, 8, 1, 5, 4},
                    {15, 24, 7, 6, 20},
                    {16, 17, 18, 19, 25}
            };

    FindLongestPath lp = new FindLongestPath();

    String path = lp.findLongestPath(M);

    System.out.println(path);
  }

  public String findLongestPath(int[][] m) {
    Map<String, String> memo = new HashMap<>();
    String path;
    String res = "";
    long longestSize = Integer.MIN_VALUE;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        path = findLongestPath(m, i, j, memo);
        long size = path.chars().filter(ch -> ch == '-').count();
        if (size > longestSize) {
          longestSize = size;
          res = path;
        }
      }
    }
    return res;
  }

  public int findLongestPathLength(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.fill(dp[i], -1);

    int longest = -1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j] != -1) {
          longest = Integer.max(longest, dp[i][j] = dfs(matrix, i, j, dp));
        }
      }
    }

    return longest;
  }

  private int dfs(int[][] matrix, int i, int j, int[][] dp) {
    int m = matrix.length, n = matrix[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n) return -1;
    if (dp[i][j] != -1) return dp[i][j];

    throw new RuntimeException("");
  }

  private String findLongestPath(int[][] m, int i, int j, Map<String, String> memo) {
    if (i < 0 || i >= m.length || j < 0 || j >= m[0].length) {
      return null;
    }

    String key = i + "|" + j;

    if (!memo.containsKey(key)) {
      String path = null;
      if (i > 0 && (m[i - 1][j] - m[i][j] == 1)) {
        path = findLongestPath(m, i - 1, j, memo);
      }
      if (j > 0 && m[i][j - 1] - m[i][j] == 1) {
        path = findLongestPath(m, i, j - 1, memo);
      }
      if (j + 1 < m[0].length && m[i][j + 1] - m[i][j] == 1) {
        path = findLongestPath(m, i, j + 1, memo);
      }
      if (i + 1 < m.length && m[i + 1][j] - m[i][j] == 1) {
        path = findLongestPath(m, i + 1, j, memo);
      }

      path = path == null ? String.valueOf(m[i][j]) : m[i][j] + " - " + path;
      memo.put(key, path);
    }

    return memo.get(key);
  }
}
