package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EscapeMazeTests {
  @Test
  public void test1() {
    int[][] grid = new int[][]{{0, 1}, {1, 0}};
    int[] source = new int[]{0, 0}, target = new int[]{0, 2};

    EscapeMaze escapeMaze = new EscapeMaze();

    Assertions.assertFalse(escapeMaze.isEscapePossible(grid, source, target));
  }

  @Test
  public void test2() {
    int[][] grid = new int[][]{};
    int[] source = new int[]{0, 0}, target = new int[]{999999, 999999};

    EscapeMaze escapeMaze = new EscapeMaze();

    Assertions.assertTrue(escapeMaze.isEscapePossible(grid, source, target));
  }
}
