package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FreqStackTests {
  @Test
  public void test1() {
    FreqStack fs = new FreqStack();
    int[] numbers = new int[]{5, 7, 5, 7, 4, 5};
    for (int n : numbers) {
      fs.push(n);
    }

    Assertions.assertEquals(5, fs.pop());
    Assertions.assertEquals(7, fs.pop());
    Assertions.assertEquals(5, fs.pop());
    Assertions.assertEquals(4, fs.pop());
  }
}
