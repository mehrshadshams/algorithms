package com.mshams.cs.problems.leetcode;

import com.mshams.cs.problems.legacy.FirstMissingPositive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstMissingPositiveTests {
  @Test
  public void test1() {
    FirstMissingPositive problem = new FirstMissingPositive();

    int num = problem.firstMissingPositive(new int[]{1,2,0});

    Assertions.assertEquals(3, num);
  }

  @Test
  public void test2() {
    FirstMissingPositive problem = new FirstMissingPositive();

    int num = problem.firstMissingPositive(new int[]{3, 4, 1, -1});

    Assertions.assertEquals(2, num);
  }

  @Test
  public void test3() {
    FirstMissingPositive problem = new FirstMissingPositive();

    int num = problem.firstMissingPositive(new int[]{7,8,9,11,12});

    Assertions.assertEquals(1, num);
  }

}
