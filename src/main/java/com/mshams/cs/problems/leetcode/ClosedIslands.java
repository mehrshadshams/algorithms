package com.mshams.cs.problems.leetcode;

public class ClosedIslands {
  int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public int closedIsland(int[][] grid) {
    int total = 0;
    int border = 0;
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          if (dfs(grid, i, j)) {
            border++;
          }
          total++;
        }
      }
    }
    return total - border;
  }

  boolean dfs(int[][] grid, int r, int c) {
    grid[r][c] = -1;
    int m = grid.length, n = grid[0].length;
    boolean res = false;
    for (int[] d : DIR) {
      int r2 = r + d[0];
      int c2 = c + d[1];
      if (r2 >= 0 && r2 < m && c2 >= 0 && c2 < n && grid[r2][c2] == 0) {
        res |= dfs(grid, r2, c2);
      }
      if (r2 == 0 || r2 == m - 1 || c2 == 0 || c2 == n - 1 && grid[r2][c2] == 0) {
        res = true;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
    };
    ClosedIslands closedIslands = new ClosedIslands();
    int res = closedIslands.closedIsland(grid);
  }
}
