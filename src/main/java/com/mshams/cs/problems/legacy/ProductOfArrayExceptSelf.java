package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/827/
 * TODO
 */
public class ProductOfArrayExceptSelf extends Problem {
  public int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];
    int product = 1;
    for (int i = 0; i < nums.length; i++) {
      output[i] = product;
      product *= nums[i];
    }
    product = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      output[i] *= product;
      product *= nums[i];
    }
    return output;
  }

  @Override
  void run() {
    int[] input = new int[]{1, 2, 3, 4};
    printArray(productExceptSelf(input));
  }
}
