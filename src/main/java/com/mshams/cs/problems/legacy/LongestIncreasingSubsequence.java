package com.mshams.cs.problems.legacy;

import java.util.Arrays;

import static com.mshams.cs.problems.legacy.Utils.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/810
 */
public class LongestIncreasingSubsequence extends Problem {
  public int lengthOfLIS2(int[] nums) {

    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    memo[nums.length - 1] = 1;
    int max = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      int count = 1;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i]) {
          count = Math.max(memo[j] + 1, count);
        }
      }
      memo[i] = count;
      max = Math.max(max, count);
    }
    return memo[0];
  }

  public int lengthOfLIS(int[] nums) {
    int[] lis = new int[nums.length];
    Arrays.fill(lis, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && lis[i] < lis[j] + 1)
          lis[i] = lis[j] + 1;
      }
    }
    int max = 0;
    for (int x : lis) {
      if (x > max) max = x;
    }
    return max;
  }

  @Override
  void run() {
    System.out.println(lengthOfLIS2(array(10, 9, 2, 5, 3, 7, 101, 18)));
  }
}
