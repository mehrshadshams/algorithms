package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortestPathBinaryMatrixTests {
  @Test
  public void test1() {
    ShortestPathBinaryMatrix sbm = new ShortestPathBinaryMatrix();

    int[][] grid = new int[][]{
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
    };

    int length = sbm.shortestPathBinaryMatrix(grid);

    Assertions.assertEquals(4, length);
  }

  @Test
  public void test2() {
    ShortestPathBinaryMatrix sbm = new ShortestPathBinaryMatrix();

    int[][] grid = new int[][]{
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0}
    };

    int length = sbm.shortestPathBinaryMatrix(grid);

    Assertions.assertEquals(7, length);
  }
}
