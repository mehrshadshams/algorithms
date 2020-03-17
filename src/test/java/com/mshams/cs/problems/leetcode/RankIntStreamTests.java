package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class RankIntStreamTests {
  @Test
  public void test1() {
    RankIntStream rank = new RankIntStream();
    IntStream.of(5, 1, 4, 4, 5, 9, 7, 13, 3).forEach(rank::track);

    Assertions.assertEquals(0, rank.findRank(1));
    Assertions.assertEquals(1, rank.findRank(3));
    Assertions.assertEquals(3, rank.findRank(4));
  }
}
