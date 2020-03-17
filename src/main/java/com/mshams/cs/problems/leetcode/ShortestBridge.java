package com.mshams.cs.problems.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
public class ShortestBridge {
  int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int shortestBridge(int[][] A) {
    int m = A.length, n = A[0].length;
    int[][] comps = getComponents(A);

    Queue<Pos> q = new LinkedList<>();
    Set<Integer> target = new HashSet<>();
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (comps[row][col] == 1) {
          q.add(new Pos(row, col, 0));
        } else {
          target.add(row * n + col);
        }
      }
    }

    while (!q.isEmpty()) {
      Pos p = q.poll();
      if (target.contains(p.row * n + p.col)) {
        return p.depth - 1;
      }
      for (int[] d : DIR) {
        int r = p.row + d[0];
        int c = p.col + d[1];
        if (r >= 0 && r < m && c >= 0 && c < n && comps[r][c] != 1) {
          q.add(new Pos(r, c, p.depth + 1));
          comps[r][c] = 1;
        }
      }
    }

    throw null;
  }

  private int[][] getComponents(int[][] a) {
    int m = a.length, n = a[0].length;
    int[][] colors = new int[m][n];
    int t = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (colors[i][j] == 0 && a[i][j] == 1) {
          // dfs
          Stack<Pos> stack = new Stack<>();
          stack.push(new Pos(i, j));
          while (!stack.isEmpty()) {
            Pos p = stack.pop();
            for (int[] d : DIR) {
              int y2 = p.row + d[0];
              int x2 = p.col + d[1];
              if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < m && a[y2][x2] == 1 && colors[y2][x2] == 0) {
                colors[y2][x2] = t;
                stack.push(new Pos(y2, x2));
              }
            }
          }
        }
      }
    }
    return colors;
  }

  class Pos {
    int row;
    int col;
    int depth;

    Pos(int r, int c) {
      row = r;
      col = c;
    }

    Pos(int r, int c, int d) {
      row = r;
      col = c;
      depth = d;
    }
  }
}
