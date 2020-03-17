package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CombinationSumTests {
  @Test
  public void testCombinationSumIII() {
    CombinationSumIII sum = new CombinationSumIII();

    List<List<Integer>> out = sum.combinationSum3(2, 6);

    Assertions.assertEquals(2, out.size());
  }
}
