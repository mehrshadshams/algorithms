package com.mshams.cs.problems.leetcode;

/**
 * http://www.algorist.com/algowiki/index.php/TADM2E_3.28
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            output[i] = L[i] * R[i];
        }

        return output;
    }
}
