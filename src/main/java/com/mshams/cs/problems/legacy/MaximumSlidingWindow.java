package com.mshams.cs.problems.legacy;

import java.util.PriorityQueue;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * TODO
 */
public class MaximumSlidingWindow extends Problem {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }
    int[] maxes = new int[nums.length - k + 1];
    PriorityQueue<Integer> p = getMax(nums, 0, k);
    maxes[0] = p.peek();
    for (int i = 1; i < maxes.length; i++) {
      int n = nums[k + i - 1];
      p.remove(nums[i - 1]);
      p.add(n);
      maxes[i] = p.peek();
    }
    return maxes;
  }

  private PriorityQueue<Integer> getMax(int[] nums, int i, int k) {
    PriorityQueue<Integer> p = new PriorityQueue<>((x, y) -> -Integer.compare(x, y));
    for (int j = 0; j < k; j++) {
      p.add(nums[j + i]);
    }
    return p;
  }

  @Override
  void run() {
    int[] nums = array(1, 3, -1, -3, 5, 3, 6, 7);
    printArray(maxSlidingWindow(nums, 3));
  }
}
