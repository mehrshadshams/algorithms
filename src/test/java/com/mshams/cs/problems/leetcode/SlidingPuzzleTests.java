package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlidingPuzzleTests {
  @Test
  public void test1() {
    int[][] board = new int[][]{{1, 2, 3}, {4, 0, 5}};

    SlidingPuzzle slidingPuzzle = new SlidingPuzzle();

    Assertions.assertEquals(1, slidingPuzzle.slidingPuzzle(board));
  }

  @Test
  public void test2() {
    int[][] board = new int[][]{{1, 2, 3}, {5, 4, 0}};

    SlidingPuzzle slidingPuzzle = new SlidingPuzzle();

    Assertions.assertEquals(-1, slidingPuzzle.slidingPuzzle(board));
  }

  @Test
  public void test3() {
    int[][] board = new int[][]{{4, 1, 2}, {5, 0, 3}};

    SlidingPuzzle slidingPuzzle = new SlidingPuzzle();

    Assertions.assertEquals(5, slidingPuzzle.slidingPuzzle(board));
  }
}
