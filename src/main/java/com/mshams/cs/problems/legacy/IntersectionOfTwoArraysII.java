package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 */
public class IntersectionOfTwoArraysII extends Problem {

  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> inter = new ArrayList<>();
    int i = 0;
    int j = 0;

    int[] shorter = null;
    int[] longer = null;
    if (nums1.length < nums2.length) {
      shorter = nums1;
      longer = nums2;
    } else {
      shorter = nums2;
      longer = nums1;
    }

    while (i < shorter.length && j < longer.length) {
      if (shorter[i] == longer[j]) {
        inter.add(shorter[i]);
        i++;
        j++;
      } else if (longer[j] > shorter[i]) {
        i++;
      } else {
        j++;
      }
    }

    int[] x = new int[inter.size()];
    for (i = 0; i < inter.size(); i++) {
      x[i] = inter.get(i);
    }
    return x;
  }

  @Override
  void run() {
    int[] a = {9, 5, 4};
    int[] b = {9, 8, 9, 4, 5};
    printArray(intersect(a, b));
  }
}
