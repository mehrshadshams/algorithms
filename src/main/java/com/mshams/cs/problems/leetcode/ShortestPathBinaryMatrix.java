package com.mshams.cs.problems.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * <p>
 * 1091. Shortest Path in Binary Matrix
 * Medium
 * <p>
 * 180
 * <p>
 * 29
 * <p>
 * Favorite
 * <p>
 * Share
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * <p>
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * <p>
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,0]]
 * <p>
 * <p>
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * <p>
 * <p>
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 * <p>
 * <p>
 * [0,0,0]
 * [1,1,0]
 * [1,1,0]
 */
public class ShortestPathBinaryMatrix {
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
//        int n = grid.length;
//        if (grid[n - 1][n - 1] != 0 || grid[0][0] != 0) return -1;
//        Queue<Position> q = new LinkedList<>();
//        q.add(new Position(n - 1, n - 1, 0));
//        int length = 0;
//        int[] dir = new int[]{-1, 0, 1};
//        while (!q.isEmpty()) {
//            Position pos = q.poll();
//            if (pos.row == 0 && pos.col == 0)
//                return pos.length + 1;
//
//            grid[pos.row][pos.col] = -1;
//            for (int dx : dir) {
//                for (int dy : dir) {
//                    if (dx == 0 && dy == 0) {
//                        continue;
//                    }
//                    int r = pos.row + dy;
//                    int c = pos.col + dx;
//                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
//                        q.add(new Position(r, c, pos.length + 1));
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//
//    private class Position {
//        int row, col, length;
//
//        Position(int r, int c, int l) {
//            this.row = r;
//            this.col = c;
//            this.length = l;
//        }
//    }

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
    int n = grid.length;
    if (grid[n - 1][n - 1] != 0 || grid[0][0] != 0) return -1;

    int[][] H = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        H[i][j] = i + j;
      }
    }

    PriorityQueue<Position> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.f, o2.f));
    int h = H[n - 1][n - 1];
    int g = 0;
    int f = g + h;
    q.add(new Position(n - 1, n - 1, 1, f, g, h));
    int length = 0;
    int[] dir = new int[]{-1, 0, 1};
    while (!q.isEmpty()) {
      Position pos = q.poll();
      if (pos.row == 0 && pos.col == 0)
        return pos.length;

      grid[pos.row][pos.col] = -1;
      for (int dx : dir) {
        for (int dy : dir) {
          if ((dx != 0 || dy != 0)) {
            int r = pos.row + dy;
            int c = pos.col + dx;
            if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
              int g2 = pos.f + 1;
              int h2 = H[r][c];
              int f2 = 1 + h2;
              q.add(new Position(r, c, pos.length + 1, f2, g2, h2));
            }
          }
        }
      }
    }
    return -1;
  }

  private class Position {
    int row, col, length, f, g, h;

    Position(int r, int c, int l, int f, int g, int h) {
      this.row = r;
      this.col = c;
      this.length = l;
      this.f = f;
      this.g = g;
      this.h = h;
    }
  }

}
