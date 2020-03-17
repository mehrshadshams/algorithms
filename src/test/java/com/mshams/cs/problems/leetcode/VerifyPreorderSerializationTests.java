package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyPreorderSerializationTests {
  @Test
  public void test1() {
    VerifyPreorderSerialization ser = new VerifyPreorderSerialization();
    Assertions.assertTrue(ser.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
  }

  @Test
  public void test2() {
    VerifyPreorderSerialization ser = new VerifyPreorderSerialization();
    Assertions.assertFalse(ser.isValidSerialization("1,#"));
  }

  @Test
  public void test3() {
    VerifyPreorderSerialization ser = new VerifyPreorderSerialization();
    Assertions.assertFalse(ser.isValidSerialization("9,#,#,1"));
  }
}
