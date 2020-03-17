package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntToRomanTests {
  @Test
  public void test1() {
    String roman = new IntToRoman().intToRoman(3);

    Assertions.assertEquals("III", roman);
  }
}
