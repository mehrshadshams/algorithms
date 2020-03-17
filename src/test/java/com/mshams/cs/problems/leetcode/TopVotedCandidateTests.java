package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class TopVotedCandidateTests {
  @Test
  public void test1() {
    TopVotedCandidate tvc = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});

    int[] answers = Stream.of(3, 12, 25, 15, 24, 8).map(tvc::q).mapToInt(value -> value).toArray();

    Assertions.assertEquals(0, answers[0]);
    Assertions.assertEquals(1, answers[1]);
    Assertions.assertEquals(1, answers[2]);
    Assertions.assertEquals(0, answers[3]);
    Assertions.assertEquals(0, answers[4]);
    Assertions.assertEquals(1, answers[5]);
  }
}
