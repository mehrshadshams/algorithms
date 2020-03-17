package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 * <p>
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 * Example 2:
 * <p>
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
@Complexity(ComplexityLevel.MEDIUM)
public class GreatestSumDivisibleByThree {
  public int maxSumDivThree(int[] nums) {
    int[][] dp = new int[3][nums.length + 1];
    for (int i = 0; i < 3; i++) {
      Arrays.fill(dp[i], -1);
    }

    dp[0][0] = 0;
    dp[1][0] = 0;
    dp[2][0] = 0;

    return maxSumDivThree(nums, 1, 0, dp);
  }

  private int maxSumDivThree(int[] nums, int idx, int sum, int[][] dp) {
    if (idx > nums.length) return sum;

    int mod = sum % 3;
    int mod2 = (3 - mod) % 3;

//        if (dp[mod][idx] != -1 && dp[mod2][idx] != -1) return dp[mod2][idx] + dp[mod][idx];
    if (dp[mod][idx] != -1) return dp[mod][idx];

    int s0 = maxSumDivThree(nums, idx + 1, nums[idx - 1], dp);
    int s1 = maxSumDivThree(nums, idx + 1, sum + nums[idx - 1], dp);
    int s2 = maxSumDivThree(nums, idx + 1, sum, dp);

    int r0 = s0 % 3;
    int r1 = s1 % 3;
    int r2 = s2 % 3;

    int[] rem = new int[]{r0, r1, r2};
    int[] sums = new int[]{s0, s1, s2};
//        int max = -1, maxidx = -1;
//        for (int i = 0; i < rem.length; i++) {
//            if (rem[i] == 0 && sums[i] > max) {
//                max = sums[i];
//                maxidx = i;
//            }
//        }

//        if (maxidx >= 0) {
//            dp[idx] = max;
//        } else {
//            dp[idx] = 0;
//        }

    for (int i = 0; i < rem.length; i++) {
      dp[i][idx] = Integer.max(dp[i][idx - 1], sums[i]);
    }

    return dp[0][idx - 1];
  }
}
