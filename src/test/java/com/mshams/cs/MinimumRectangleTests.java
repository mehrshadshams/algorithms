package com.mshams.cs;

import com.mshams.cs.problems.MinimumRectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MinimumRectangleTests {
  private static boolean equals(double a, double b) {
    return Math.abs(a - b) < 1e-5;
  }

  @Test
  @Disabled
  void test1() {
    int[][] input = {{1, 2}, {2, 1}, {1, 0}, {0, 1}};

    MinimumRectangle sol = new MinimumRectangle();
    double area = sol.minAreaFreeRect(input);

    Assertions.assertTrue(equals(2.0, area));
  }

  @Test
  @Disabled
  void test2() {
    int[][] input = {{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}};

    MinimumRectangle sol = new MinimumRectangle();
    double area = sol.minAreaFreeRect(input);

    Assertions.assertTrue(equals(1.0, area));
  }

  @Test
  @Disabled
  void test3() {
    int[][] input = {{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}};

    MinimumRectangle sol = new MinimumRectangle();
    double area = sol.minAreaFreeRect(input);

    Assertions.assertTrue(equals(0.0, area));
  }

  @Test
  @Disabled
  void test4() {
    int[][] input = {{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}};

    MinimumRectangle sol = new MinimumRectangle();
    double area = sol.minAreaFreeRect(input);

    Assertions.assertTrue(equals(2.0, area));
  }
}
