package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

public class BikeAssignmentTest {
  @Test
  public void test1() {
    BikeAssignment sol = new BikeAssignment();

    int[][] workers = new int[][]{{0, 0}, {2, 1}};
    int[][] bikes = new int[][]{{1, 2}, {3, 3}};

    int result = sol.assignBikes(workers, bikes);

    Assertions.assertEquals(6, result);
  }

  @Test
  public void test2() {
    Map<Integer, Long> collect = "abcdea".chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    for (Map.Entry<Integer, Long> kv : collect.entrySet()) {
      System.out.println((char) kv.getKey().intValue() + " : " + kv.getValue());
      StringBuilder sb = new StringBuilder();

    }
  }
}
