package com.mshams.cs.problems.legacy;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
@SuppressWarnings("Duplicates")
public class FindMedianFromDataStream extends Problem {
  private PriorityQueue<Integer> min = new PriorityQueue<>();
  private PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

  public void addNum(int num) {
    max.offer(num);
    if (max.size() > 0) {
      min.offer(max.poll());
    }
    if (max.size() < min.size()) {
      max.offer(min.poll());
    }
  }

  public double findMedian() {
    return max.size() > min.size() ? (double) max.peek() : ((double) (min.peek() + max.peek())) / 2;
  }

  @Override
  void run() {
    addNum(-1);
    addNum(-2);
    print(findMedian());
    addNum(-3);
    print(findMedian());
    addNum(-4);
    print(findMedian());
    addNum(-5);
    print(findMedian());
  }
}
