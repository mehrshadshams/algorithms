package com.mshams.cs.problems.legacy;

public class PathPlanner {
  public void test() {
    int grid[][] = new int[5][6];
    grid[0] = new int[]{0, 1, 0, 0, 0, 0};
    grid[1] = new int[]{0, 1, 0, 0, 0, 0};
    grid[2] = new int[]{0, 1, 0, 0, 0, 0};
    grid[3] = new int[]{0, 1, 0, 0, 0, 0};
    grid[4] = new int[]{0, 0, 0, 0, 0, 0};

    int h[][] = new int[5][6];
    h[0] = new int[]{9, 8, 7, 6, 5, 4};
    h[1] = new int[]{8, 7, 6, 5, 4, 3};
    h[2] = new int[]{7, 6, 5, 4, 3, 2};
    h[3] = new int[]{6, 5, 4, 3, 2, 1};
    h[4] = new int[]{5, 4, 3, 2, 1, 0};


  }
}
