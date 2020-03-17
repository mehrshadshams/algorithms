package com.mshams.cs;

import com.mshams.cs.problems.LongestRepeatingSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestRepeatingSubsequenceTest {
  @Test
  public void test1() {
    LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();

    Assertions.assertEquals("ATCG", lrs.lrs("ATACTCGGA"));
  }
}
