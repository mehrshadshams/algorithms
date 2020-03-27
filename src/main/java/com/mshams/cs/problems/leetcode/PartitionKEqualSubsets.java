package com.mshams.cs.problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets
 */
public class PartitionKEqualSubsets {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if (sum % k != 0) return false;

    Arrays.sort(nums);

    boolean[] taken = new boolean[nums.length];

    return canPartition(nums, 0, k, 0, sum / k, taken);
  }

  private boolean canPartition(int[] nums, int j, int k, int running, int sum,
                               boolean[] taken) {
    if (running == sum) {
      if (j == k - 2) return true;

      return canPartition(nums, j + 1, k, 0, sum, taken);
    }

    for (int i = 0; i < nums.length; i++) {
      if (taken[i]) continue;
      int s = running + nums[i];
      if (s <= sum) {
        taken[i] = true;
        boolean result = canPartition(nums, j, k, s, sum, taken);
        taken[i] = false;
        if (result) {
          return true;
        }
      }
    }
    return false;
  }
}
