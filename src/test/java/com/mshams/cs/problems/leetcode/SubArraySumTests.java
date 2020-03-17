package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubArraySumTests {
  @Test
  public void test1() {
    SubArraySum sol = new SubArraySum();

    int count = sol.subarraySum(new int[]{1, 1, 1}, 2);

    Assertions.assertEquals(2, count);
  }
}
