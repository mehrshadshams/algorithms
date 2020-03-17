package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

/**
 * https://leetcode.com/problems/single-number-ii/
 */
@Complexity(ComplexityLevel.MEDIUM)
public class SingleNumberII {
  public static void main(String[] args) {
    int[] nums = new int[]{2, 2, 3, 2};
    int one = 0;
    int two = 0;
    for (int v : nums) {
      one = one ^ v & ~two;
      two = two ^ v & ~one;
    }
    System.out.println(one);
  }
}
