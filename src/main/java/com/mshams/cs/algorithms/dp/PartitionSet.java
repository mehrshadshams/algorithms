package com.mshams.cs.algorithms.dp;

import java.util.Arrays;

/**
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 */
public class PartitionSet {

  static boolean canPartition(int[] num) {
    int sum = Arrays.stream(num).sum();
    if (sum % 2 != 0) return false;

    final int n = num.length;
    sum /= 2;

    boolean[][] dp = new boolean[n][sum + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    for (int s = 1; s <= sum; s++) {
      dp[0][s] = s == num[0] ? true : false;
    }

    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        if (dp[i - 1][s]) {
          dp[i][s] = dp[i - 1][s];
        } else {
          if (num[i] <= s) {
            dp[i][s] = dp[i - 1][s - num[i]];
          }
        }
      }
    }

    return dp[n - 1][sum];
  }
}
