package com.mshams.cs.problems.legacy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbStairs extends Problem {
  public int climbStairs(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return climb(n, memo);
  }

  public int climb(int n, int[] memo) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else if (memo[n] > -1) {
      return memo[n];
    } else {
      memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
      return memo[n];
    }
  }

  @Override
  void run() {
    System.out.println(climbStairs(44));
  }
}
