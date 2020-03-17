package com.mshams.cs;

import com.mshams.cs.problems.LongestSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubsequenceTest {
  @Test
  void test() {
    String s = "abppplee";
    String[] dict = {"able", "ale", "apple", "bale", "kangaroo"};

    String lcs = LongestSubsequence.find(s, dict);

    Assertions.assertEquals("apple", lcs);
  }
}
