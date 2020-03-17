package com.mshams.cs.problems.legacy;

import java.util.Arrays;

public class HouseRobber extends Problem {
  public int rob(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return rob(nums, 0, 0, memo);
  }

  int rob(int nums[], int index, int total, int[] memo) {
    if (index >= nums.length) {
      return 0;
    }

    if (memo[index] > -1) {
      return memo[index];
    }

    int sum1 = nums[index] + rob(nums, index + 2, total, memo);
    int sum2 = rob(nums, index + 1, total, memo);

    memo[index] = total + Math.max(sum1, sum2);

    return memo[index];
  }

  @Override
  void run() {
    System.out.println(rob(new int[]{1, 2, 3, 1}));
    System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
  }
}
