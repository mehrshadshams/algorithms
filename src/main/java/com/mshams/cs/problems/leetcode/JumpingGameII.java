package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * <p>
 * 45. Jump Game II
 * Hard
 * <p>
 * 1658
 * <p>
 * 92
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * <p>
 * You can assume that you can always reach the last index.
 */
public class JumpingGameII {
  public int jump(int[] nums) {
    if (nums.length < 2) return 0;
    int n = nums.length;
    int maxReach = nums[0], maxReachStep = nums[0];
    int jumps = 1;
    for (int i = 1; i < n; i++) {
      if (i > maxReachStep) {
        jumps++;
        maxReachStep = maxReach;
      }
      maxReach = Math.max(maxReach, i + nums[i]);
    }
    return jumps;
  }
}
