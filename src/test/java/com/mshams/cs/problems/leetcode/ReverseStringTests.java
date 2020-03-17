package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseStringTests {
  @Test
  public void test1() {
    ReverseStringII reverseString = new ReverseStringII();

    char[] seq = "the sky is blue".toCharArray();
    // bluethe sky is
//        "blue the sky is"

    reverseString.reverseWords(seq);

    Assertions.assertEquals("blue is sky the", new String(seq));
  }
}
