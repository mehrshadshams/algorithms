package com.mshams.cs.problems.legacy;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
 */
public class JumpGame extends Problem {
  public boolean canJump(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return canJump(nums, memo, 0);
  }

  private boolean canJump(int[] nums, int[] memo, int index) {
    if (index >= nums.length) {
      return false;
    }

    if (index == nums.length - 1) {
      return true;
    }

    if (memo[index] != -1) {
      return memo[index] == 1;
    }

    boolean c = false;
    for (int i = Math.min(nums[index], nums.length - index); i > 0; i--) {
      c |= canJump(nums, memo, index + i);
      if (c) {
        break;
      }
    }

    memo[index] = c ? 1 : 0;
    return memo[index] == 1;
  }

  @Override
  void run() {

  }
}
