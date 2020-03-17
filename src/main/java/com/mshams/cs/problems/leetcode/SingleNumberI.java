package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

/**
 * https://leetcode.com/problems/single-number/
 */
@Complexity(ComplexityLevel.EASY)
public class SingleNumberI {
  public static void main(String[] args) {
    int[] nums = new int[]{4, 1, 2, 2, 1};
    int one = 0;
    for (int v : nums) {
      one = one ^ v;
    }
    System.out.println(one);
  }
}
