package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.matrix;
import static com.mshams.cs.problems.legacy.Utils.printArray;

public class RotateMatrix extends Problem {
  public void rotate(int[][] matrix) {
    if (matrix.length == 0) return;
    int n = matrix.length - 1;
    for (int i = 0; i < (matrix.length / 2); i++) {
      for (int j = i; j < n - i; j++) {
        int t1 = matrix[n - j][i];
        int t2 = matrix[n - i][n - j];
        int t3 = matrix[j][n - i];
        int t4 = matrix[i][j];
        matrix[i][j] = t1;
        matrix[n - j][i] = t2;
        matrix[n - i][n - j] = t3;
        matrix[j][n - i] = t4;
      }
    }
  }

  @Override
  void run() {
    int[][] M = matrix(4, 4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
    rotate(M);
    printArray(M);
  }

  public static void main(String[] args) {
    RotateMatrix rm = new RotateMatrix();
    rm.run();
  }
}
