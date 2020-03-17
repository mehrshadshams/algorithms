package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZeroOneMatrixTests {
  @Test
  public void test1() {
    int[][] matrix = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
    };

    ZeroOneMatrix sol = new ZeroOneMatrix();

    int[][] dist = sol.updateMatrix(matrix);

    Assertions.assertArrayEquals(new int[]{0, 0, 0}, dist[0]);
    Assertions.assertArrayEquals(new int[]{0, 1, 0}, dist[1]);
    Assertions.assertArrayEquals(new int[]{1, 2, 1}, dist[2]);
  }
}
