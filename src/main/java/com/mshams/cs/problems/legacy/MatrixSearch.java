package com.mshams.cs.problems.legacy;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
 */
public class MatrixSearch extends Problem {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m > 0) {
      int n = matrix[0].length;
      int r = 0;
      int c = n - 1;
      while (r < m && c >= 0) {
        if (matrix[r][c] == target) {
          return true;
        } else if (matrix[r][c] > target) {
          c--;
        } else {
          r++;
        }
      }
    }
    return false;
  }

  @Override
  void run() {

  }
}
