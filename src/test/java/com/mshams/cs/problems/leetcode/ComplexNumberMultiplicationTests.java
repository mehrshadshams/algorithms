package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexNumberMultiplicationTests {
  @Test
  public void test1() {
    ComplexNumberMultiplication mul = new ComplexNumberMultiplication();

    String result = mul.complexNumberMultiply("1+1i", "1+1i");

    Assertions.assertEquals("0+2i", result);
  }

  @Test
  public void test2() {
    ComplexNumberMultiplication mul = new ComplexNumberMultiplication();

    String result = mul.complexNumberMultiply("1+-1i", "1+-1i");

    Assertions.assertEquals("0+-2i", result);
  }

  @Test
  public void test3() {
    ComplexNumberMultiplication mul = new ComplexNumberMultiplication();

    String result = mul.complexNumberMultiply("78+-76i", "-86+72i");

    Assertions.assertEquals("-1236+12152i", result);
  }
}
