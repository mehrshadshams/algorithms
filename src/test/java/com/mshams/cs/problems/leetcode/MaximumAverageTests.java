package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumAverageTests {
  @Test
  public void test1() {
    MaximumSubarrayAverage sol = new MaximumSubarrayAverage();

    double avg = sol.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);

    Assertions.assertEquals(12.75, avg, 1e-2);
  }

  @Test
  public void test2() {
    MaximumSubarrayAverage sol = new MaximumSubarrayAverage();

    double avg = sol.findMaxAverage(new int[]{3, 3, 4, 3, 0}, 3);

    Assertions.assertEquals(3.33, avg, 1e-2);
  }

  @Test
  public void test3() {
    MaximumSubarrayAverage sol = new MaximumSubarrayAverage();

    double avg = sol.findMaxAverage(new int[]{5}, 1);

    Assertions.assertEquals(5, avg, 1e-2);
  }

  @Test
  public void test4() {
    MaximumSubarrayAverage sol = new MaximumSubarrayAverage();

    double avg = sol.findMaxAverage(new int[]{4, 0, 4, 3, 3}, 5);

    Assertions.assertEquals(2.8, avg, 1e-2);
  }
}
