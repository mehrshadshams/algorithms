package com.mshams.cs;

import com.mshams.cs.problems.IncreasingSubsequenceMaximumSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncreasingSubsequenceMaximumSumTest {
  private final int[] arr = {8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};

  @Test
  public void testTopDown() {
    IncreasingSubsequenceMaximumSum msis = new IncreasingSubsequenceMaximumSum();

    int value = msis.msisTopDown(arr);

    Assertions.assertEquals(34, value);
  }

  @Test
  public void testDP() {
    IncreasingSubsequenceMaximumSum msis = new IncreasingSubsequenceMaximumSum();

    int value = msis.msisDP(arr);

    Assertions.assertEquals(34, value);
  }
}
