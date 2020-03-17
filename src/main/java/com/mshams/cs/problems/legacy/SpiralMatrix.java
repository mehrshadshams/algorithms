package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.List;

import static com.mshams.cs.problems.legacy.Utils.printList;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/828/
 */
public class SpiralMatrix extends Problem {
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new ArrayList<>();
    }
    int m = matrix.length;
    int n = matrix[0].length;

    int i0 = 0;
    int i1 = m - 1;
    int j0 = 0;
    int j1 = n - 1;

    List<Integer> list = new ArrayList<>();
    int index = 0;
    int i = i0;
    int j = j0;

    int counter = 0;
    while (index < m * n) {
      int num = matrix[i][j];
      list.add(num);

      if (counter == 0) {
        j++;
        if (j > j1) {
          j = j1;
          counter++;
          i0++;
          i = i0;
        }
      } else if (counter == 1) {
        i++;
        if (i > i1) {
          i = i1;
          j1--;
          j = j1;
          counter++;
        }
      } else if (counter == 2) {
        j--;
        if (j < j0) {
          counter++;
          j = j0;
          i1--;
          i = i1;
        }
      } else {
        i--;
        if (i < i0) {
          i = i0;
          j0++;
          j = j0;
          counter = 0;
        }
      }

      index++;
    }
    return list;
  }

  @Override
  void run() {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    printList(spiralOrder(matrix));
  }
}
