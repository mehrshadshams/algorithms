package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestElementTests {
  @Test
  public void test1() {
    KthLargestElement kthLargestElement = new KthLargestElement();

    int elem = kthLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);

    Assertions.assertEquals(5, elem);
  }

  @Test
  public void test2() {
    KthLargestElement kthLargestElement = new KthLargestElement();

    int elem = kthLargestElement.findKthLargest(new int[]{-1, -1}, 2);

    Assertions.assertEquals(-1, elem);
  }

  @Test
  public void test3() {
    KthLargestElement kthLargestElement = new KthLargestElement();

    int elem = kthLargestElement.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5);

    Assertions.assertEquals(3, elem);
  }
}
