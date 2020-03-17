package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitArrayTests {
  @Test
  public void test1() {
    SplitArray sol = new SplitArray();

    int sum = sol.splitArray(new int[]{7,2,5,10,8}, 2);

    Assertions.assertEquals(18, sum);
  }
}
