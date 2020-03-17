package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreatestSumDivisibleByThreeTests {
  @Test
  public void test1() {
    GreatestSumDivisibleByThree sol = new GreatestSumDivisibleByThree();

    int sum = sol.maxSumDivThree(new int[]{3, 6, 5, 1, 8});

    Assertions.assertEquals(18, sum);
  }
}
