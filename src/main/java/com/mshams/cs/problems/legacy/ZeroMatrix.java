package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.matrix;
import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class ZeroMatrix extends Problem {
  public void zero(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    boolean firstRowHasZero = false;
    boolean firstColHasZero = false;
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        firstRowHasZero = true;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        firstColHasZero = true;
        break;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
          break;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        nullifyCol(matrix, j);
      }
    }

    if (firstColHasZero) {
      nullifyCol(matrix, 0);
    }
    if (firstRowHasZero) {
      nullifyRow(matrix, 0);
    }
  }

  private void nullifyRow(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }

  private void nullifyCol(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  @Override
  void run() {
    int[][] M = matrix(4, 4, 1, 2, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
    printArray(M);
    zero(M);
    printArray(M);
  }
}
