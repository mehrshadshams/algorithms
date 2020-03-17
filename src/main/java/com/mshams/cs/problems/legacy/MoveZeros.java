package com.mshams.cs.problems.legacy;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567
 */
public class MoveZeros extends Problem {
  public void moveZeroes(int[] nums) {
    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[pos++] = nums[i];
      }
    }
    while (pos < nums.length) {
      nums[pos++] = 0;
    }
  }

  @Override
  void run() {

  }
}
