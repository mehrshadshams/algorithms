package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.List;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646
 * TODO
 */
public class RotateArray extends Problem {
  public void rotate(int[] nums, int k) {
    List<Integer> l = new ArrayList<>();
    l.toArray();
    k = k % nums.length;
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
      i++;
      j--;
    }
  }

  @Override
  void run() {
    int[] array = array(1, 2, 3, 4, 5, 6, 7);
    rotate(array, 3);
    printArray(array);
  }
}
