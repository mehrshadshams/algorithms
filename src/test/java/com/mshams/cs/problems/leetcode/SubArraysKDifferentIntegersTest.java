package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubArraysKDifferentIntegersTest {
  @Test
  public void test1() {
    SubArraysKDifferentIntegers sol = new SubArraysKDifferentIntegers();

    int result = sol.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);

    Assertions.assertEquals(7, result);
  }
}
