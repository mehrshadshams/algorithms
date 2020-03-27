package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum
 */
public class PartitionEqualSubset {
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    boolean[][] dp = new boolean[n + 1][(sum / 2) + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }
    for (int j = 0; j <= sum / 2; j++) {
      dp[0][j] = false;
    }

    for (int i = 1; i <= n; i++) {
      for (int s = 1; s <= sum / 2; s++) {
        dp[i][s] = dp[i - 1][s];
        if (nums[i - 1] <= s) {
          dp[i][s] |= dp[i - 1][s - nums[i - 1]];
        }
      }
    }

    return dp[n][sum / 2];
  }
}
