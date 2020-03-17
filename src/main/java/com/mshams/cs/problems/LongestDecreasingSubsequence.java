package com.mshams.cs.problems;

import java.util.Arrays;

/**
 * Longest Decreasing Subsequence
 * Complexity:
 * - Top bottom, no memoization: Time O(2^n) Space O(1)
 * - Top bottom, memoization: TBD
 * - Bottom up: Time O(n^2)
 */
public class LongestDecreasingSubsequence {
  public int findLisLength(int[] array) {
    return findLisLength(array, 0, Integer.MIN_VALUE);
  }

  public int findLisLengthBottomUp(int[] array) {
    int[] dp = new int[array.length];
    dp[0] = 1;

    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i] && dp[j] < dp[i]) {
          dp[i] = dp[j];
        }
      }
      dp[i]++;
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  private int findLisLength(int[] array, int i, int prev) {
    if (i == array.length) {
      return 0;
    }

    int incl = Integer.MIN_VALUE;
    if (array[i] < prev) {
      incl = 1 + findLisLength(array, i + 1, array[i]);
    }

    int excl = findLisLength(array, i + 1, prev);

    return Math.max(incl, excl);
  }
}
