package com.mshams.cs.problems.leetcode;

import java.util.Arrays;

public class SplitArray2 {
//  public int splitArray(int[] nums, int m) {
//    long l = 0, r = 0;
//    for (int i = 0; i < nums.length; i++) {
//      r += nums[i];
//      if (l < nums[i]) {
//        l = nums[i];
//      }
//    }
//
//    long ans = r;
//    while (l <= r) {
//      long mid = l + (r - l) / 2;
//      long sum = 0;
//      int count = 1;
//      for (int i = 0; i < nums.length; i++) {
//        if (sum + nums[i] > mid) {
//          count++;
//          sum = nums[i];
//        } else {
//          sum += nums[i];
//        }
//      }
//
//      if (count <= m) {
//        ans = Math.min(ans, mid);
//        r = mid - 1;
//      } else {
//        l = mid + 1;
//      }
//    }
//    return (int) ans;
//  }

  public int splitArray(int[] nums, int m) {
    int[][] dp = new int[nums.length + 1][m + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }

    int[] sums = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    return splitArray(sums, 1, m, Integer.MAX_VALUE, -1, dp);
  }

  int splitArray(int[] sums, int i, int m, int minSum, int currentMax, int[][] dp) {
    if (dp[i][m] != -1) return dp[i][m];
    if (m == 1) {
      int lastSum = sums[sums.length - 1] - sums[i - 1];
      return Math.min(minSum, Math.max(currentMax, lastSum));
    }

    int minMax = minSum;
    for (int j = i; j < sums.length - m + 1; j++) {
      int s = sums[j] - sums[i - 1];
      minMax = Math.min(minMax, splitArray(sums, j + 1, m - 1, minSum, Math.max(currentMax, s), dp));
    }

    dp[i][m] = minMax;
    return minMax;
  }

  public static void main(String[] args) {
    SplitArray2 sp = new SplitArray2();
    int[] arr = new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8};

            // new int[]{1,4,4}; // new int[]{7,2,5,10,8}, 2
    int m = 8;
    System.out.println(sp.splitArray(arr, m));
  }
}
