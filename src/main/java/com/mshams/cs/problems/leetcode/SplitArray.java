package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/split-array-largest-sum
 * <p>
 * Similar to: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * <p>
 * See {@link com.mshams.cs.algorithms.dp.PartitionProblem}
 * 410. Split Array Largest Sum
 * Hard
 * <p>
 * 1271
 * <p>
 * 73
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * <p>
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * 7 9 14 24 32
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 **/
public class SplitArray {
  public int splitArray(int[] nums, int m) {
    int n = nums.length;
    int[][] dp = new int[n + 1][m + 1];
    int[] sums = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        for (int k = 0; k < i; k++) {
          dp[i][j] = Math.min(dp[i][j], Math.max(sums[i] - sums[k], dp[k][j - 1]));
        }
      }
    }
    return dp[n][m];
  }

  /*
  public int splitArray(int[] nums, int m) {
    int[] sums = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    return splitArray(sums, 1, m, Integer.MAX_VALUE, -1);
  }

  int splitArray(int[] sums, int i, int m, int minSum, int currentMax) {
    if (m == 1) {
      int lastSum = sums[sums.length - 1] - sums[i - 1];
      return Math.min(minSum, Math.max(currentMax, lastSum));
    }

    int minMax = minSum;
    for (int j = i; j < sums.length - m; j++) {
      int s = sums[i] - sums[0];
      minMax = Math.min(minMax, splitArray(sums, j + 1, m - 1, minSum, Math.max(currentMax, s)));
    }

    return minMax;
  }
   */
}
