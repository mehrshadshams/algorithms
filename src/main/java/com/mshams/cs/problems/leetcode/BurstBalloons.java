package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {
  public int maxCoins(int[] nums) {
    int[] n = new int[nums.length + 2];
    n[0] = 1;
    n[nums.length - 1] = 1;
    for (int i = 1; i <= nums.length; i++) {
      n[i] = nums[i - 1];
    }
    return maxCoins(n, 0, n.length - 1);
  }

  int maxCoins(int[] nums, int left, int right) {
    if (left + 1 == right) return 0;
    int max = 0;
    for (int i = left + 1; i < right; i++) {
      int p = nums[left] * nums[i] * nums[right];
      max = Math.max(max, p + maxCoins(nums, left, i) + maxCoins(nums, i, right));
    }
    return max;
  }

  public static void main(String[] args) {
    BurstBalloons bb = new BurstBalloons();
    System.out.println(bb.maxCoins(new int[]{3, 1, 5, 8}));
  }
}
