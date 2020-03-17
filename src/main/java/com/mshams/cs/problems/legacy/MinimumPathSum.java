package com.mshams.cs.problems.legacy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum extends Problem {
  public int minPathSum(int[][] grid) {
    int[][] memo = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++)
      Arrays.fill(memo[i], -1);

    return dfs(grid, 0, 0, memo);
  }

  private int dfs(int[][] grid, int i, int j, int[][] memo) {
    if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
    if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
    if (memo[i][j] >= 0) return memo[i][j];

    int bottom = dfs(grid, i + 1, j, memo);
    int right = dfs(grid, i, j + 1, memo);

    memo[i][j] = grid[i][j] + Math.min(bottom, right);
    return memo[i][j];
  }

  @Override
  void run() {
    int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };
    print(minPathSum(grid));
  }
}
