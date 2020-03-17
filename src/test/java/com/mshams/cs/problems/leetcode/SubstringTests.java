package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class SubstringTests {
  @Test
  public void test1() {
    Substring substring = new Substring();

    List<Integer> indices = substring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
    Collections.sort(indices);

    Assertions.assertArrayEquals(indices.toArray(new Integer[0]), new Integer[]{0, 9});
  }
}
