package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/making-a-large-island
 * <p>
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * <p>
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 * <p>
 * Input: [[1, 1], [1, 0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 * <p>
 * Input: [[1, 1], [1, 1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 */
public class MakeLargeIsland {
  //    public int largestIsland(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[][] components = new int[m][n];
//        int compId = 0;
//        for (int r = 0; r < m; r++) {
//            for (int c = 0; c < n; c++) {
//                components[r][c] = dfs(grid, r, c);
//            }
//        }
//
//    }
//
//    private int dfs(int[][] grid, int row, int col) {
//        int m = grid.length, n = grid[0].length;
//
//    }
  static void minimumSwaps(int[] q) {
    int count = 0;
    for (int i = 0; i < q.length; i++) {
      int diff = Math.abs(q[i] - i + 1);
      if (diff > 2) {
        System.out.println("Too chaotic");
        return;
      }
      count += diff;
    }
    System.out.println(count / 2);
  }

  public static void main(String[] args) {
    MakeLargeIsland.minimumSwaps(new int[]{2,1,5,3,4});
  }
}
