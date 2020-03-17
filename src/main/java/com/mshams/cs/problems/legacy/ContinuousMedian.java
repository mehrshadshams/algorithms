package com.mshams.cs.problems.legacy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class ContinuousMedian extends Problem {

  public double getMedian(int[] numbers) {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

    int median = numbers[0];
    min.offer(median);

    double med = median;
    for (int i = 1; i < numbers.length; i++) {
      int x = numbers[i];
      if (i == 1) {
        max.offer(x);
      } else {
        if (x > med) {
          min.offer(x);
        } else {
          max.offer(x);
        }
      }

      if (min.size() > 0 && max.size() > 0) {
        med = ((double) (min.peek() + max.peek())) / 2;

        while (!max.isEmpty() && max.peek() < med) {
          min.offer(max.poll());
        }

        while (!min.isEmpty() && min.peek() > med) {
          max.offer(min.poll());
        }
      }
    }

    return med;
  }

  @Override
  void run() {
    int[] numbers = {1, 13, 10, 2, 5, 3, 8, 9};
    System.out.println(getMedian(numbers));
  }
}
