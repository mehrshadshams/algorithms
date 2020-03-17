package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-average-subarray-ii/
 * <p>
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation:
 * when length is 5, maximum average value is 10.8,
 * when length is 6, maximum average value is 9.16667.
 * Thus return 12.75.
 * Note:
 * 1 <= k <= n <= 10,000.
 * Elements of the given array will be in range [-10,000, 10,000].
 * The answer with the calculation error less than 10-5 will be accepted.
 */
@Complexity(ComplexityLevel.HARD)
public class MaximumSubarrayAverage {
  public double findMaxAverage(int[] nums, int k) {
    int[] dp = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      dp[i] = dp[i - 1] + nums[i - 1];
    }

    double maxAvg = Double.NEGATIVE_INFINITY;
    for (int j = k; j <= nums.length; j++) {
      int[] temp = Arrays.copyOf(dp, dp.length);
      double avg = 0.0;
      if (j < nums.length) {
        for (int i = j + 1; i <= nums.length; i++) {
          temp[i] = temp[i - 1] - nums[i - k - 1] + nums[i - 1];
          avg = (double) temp[i] / k;
          maxAvg = Double.max(maxAvg, avg);
        }
      } else {
        maxAvg = Double.max(maxAvg, (double) dp[j] / j);
      }
    }

    return maxAvg;
  }
}
