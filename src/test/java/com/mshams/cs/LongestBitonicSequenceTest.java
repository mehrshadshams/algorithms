package com.mshams.cs;

import com.mshams.cs.problems.LongestBitonicSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestBitonicSequenceTest {
  @Test
  public void test1() {
    int[] arr = {4, 2, 5, 9, 7, 6, 10, 3, 1};

    LongestBitonicSequence lbs = new LongestBitonicSequence();

    int[] out = lbs.lbs(arr);

    Assertions.assertArrayEquals(new int[]{4, 5, 9, 7, 6, 3, 1}, out);
  }
}
