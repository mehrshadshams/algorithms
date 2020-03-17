package com.mshams.cs.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
    List<List<Integer>> sums = new ArrayList<>();
    for (int i = 0, j = list.size() - 1; i < j - 1; ) {
      int a = list.get(i);
      int b = list.get(j);
      int c = -(a + b);
      int idx = Collections.binarySearch(list.subList(i + 1, j), c);
      if (idx >= 0) {
        sums.add(Arrays.asList(a, list.get(i + 1 + idx), b));
      }
      if (c > 0) {
        while (i < j && list.get(i) == a) {
          i++;
        }
      } else if (c < 0) {
        while (j > i && list.get(j) == b) {
          j--;
        }
      }

    }
    return sums;
  }

//  public List<List<Integer>> threeSum(int[] nums) {
//    Arrays.sort(nums);
//    List<List<Integer>> out = new ArrayList<>();
//    for (int i = 0; i < nums.length; i++) {
//      int j = i + 1;
//      int k = nums.length - 1;
//      int a = nums[i];
//
//      if (i > 0 && nums[i] == nums[i - 1]) {
//        continue;
//      }
//
//      while (j < k) {
//        if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
//          k--;
//          continue;
//        }
//        int b = nums[j];
//        int c = nums[k];
//        if (a + b + c > 0) {
//          k--;
//        } else if (a + b + c < 0) {
//          j++;
//        } else {
//          out.add(Arrays.asList(a, b, c));
//          j++;
//          k--;
//        }
//      }
//    }
//    return out;
//  }

  public static void main(String[] args) {
    ThreeSum ts = new ThreeSum();
    ts.threeSum(new int[]{0, 0, 0, 0});
  }
}
