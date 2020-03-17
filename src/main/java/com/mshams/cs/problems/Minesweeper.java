package com.mshams.cs.problems;

import java.util.Random;

/**
 * https://techdevguide.withgoogle.com/paths/foundational/coding-question-minesweeper/#!
 */
public class Minesweeper {
  private static final int MINE = 9;

  public static Board create(int rows, int cols, int mines) {
    return new Board(rows, cols, mines);
  }

  public static class Board {
    int[][] board;

    Board(int m, int n, int mines) {
      board = new int[m][n];
      Random random = new Random(System.currentTimeMillis());
      int offset = 0;
      if (mines > (m * n) / 2) {
        offset += m * n - mines;
      }
      for (int i = 0; i < mines; i++) {
        int j = offset + i;
        int r = j / m;
        int c = j % n;
        board[r][c] = 9;
      }

      for (int i = 0; i < mines; i++) {
        int j = i + random.nextInt(m * n - i);

        swap(board, i, j);
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

        }
      }
    }

    void swap(int[][] board, int i, int j) {
      int m = board.length, n = board[0].length;
      int r = i / m;
      int c = i % n;
      int r2 = j / m;
      int c2 = j % n;

      int t = board[r][c];
      board[r][c] = board[r2][c2];
      board[r2][c2] = t;
    }
  }
}
