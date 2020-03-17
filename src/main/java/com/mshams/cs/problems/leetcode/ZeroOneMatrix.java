package com.mshams.cs.problems.leetcode;

import com.mshams.cs.problems.legacy.common.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/
 * <p>
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {
  public int[][] updateMatrix(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dist = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    int[][] dirs = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          dist[i][j] = 0;
          q.add(Pair.of(i, j));
        }
      }
    }

    while (!q.isEmpty()) {
      Pair<Integer, Integer> p = q.poll();
      for (int[] d : dirs) {
        int row = p.getFirst() + d[0];
        int col = p.getSecond() + d[1];
        if (row >= 0 && row < m && col >= 0 && col < n) {
          if (dist[row][col] > dist[p.getFirst()][p.getSecond()] + 1) {
            dist[row][col] = dist[p.getFirst()][p.getSecond()] + 1;
            q.add(Pair.of(row, col));
          }
        }
      }
    }

    return dist;
  }


}