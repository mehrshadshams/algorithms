package com.mshams.cs.algorithms.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartitionSetTests {
  @Test
  public void test1() {
    Assertions.assertTrue(PartitionSet.canPartition(new int[]{1, 2, 3, 4}));
  }

  @Test
  public void test2() {
    Assertions.assertTrue(PartitionSet.canPartition(new int[]{1, 1, 3, 4, 7}));
  }

  @Test
  public void test3() {
    Assertions.assertFalse(PartitionSet.canPartition(new int[]{2, 3, 4, 6}));
  }
}
