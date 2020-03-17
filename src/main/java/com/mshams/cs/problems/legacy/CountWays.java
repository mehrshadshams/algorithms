package com.mshams.cs.problems.legacy;

import java.util.Arrays;

public class CountWays extends Problem {
  public int countWays(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);

    return countWays(n, memo);
  }

  private int countWays(int n, int[] memo) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (memo[n] != -1) return memo[n];

    memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
    return memo[n];
  }

  @Override
  void run() {
    System.out.println(countWays(10));
  }
}
