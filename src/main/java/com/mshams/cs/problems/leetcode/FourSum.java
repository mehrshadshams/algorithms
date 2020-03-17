package com.mshams.cs.problems.leetcode;

import java.util.*;

public class FourSum {
  public static void main(String[] args) {
    FourSum fourSum = new FourSum();
    List<List<Integer>> fs = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    System.out.println(fs);
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length < 4) return new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    Set<List<Integer>> list = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = n - 1; j >= 0; j--) {
        int a = nums[i];
        int b = nums[j];

        int s = a + b;

        List<List<Integer>> two = twoSum(nums, i + 1, j - 1, target - s);
        if (!two.isEmpty()) {
          for (List<Integer> t : two) {
            List<Integer> temp = new ArrayList<>(t);
            temp.add(a);
            temp.add(b);

            Collections.sort(temp);
            list.add(temp);
          }
        }
      }
    }
    return new ArrayList<>(list);
  }

  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  List<List<Integer>> twoSum(int[] nums, int L, int H, int target) {
    List<List<Integer>> output = new ArrayList<>();
    for (int k = L; k <= H; k++) {
      int c = nums[k];

      List<Integer> array = new ArrayList<>();

      int lo = L, hi = H;
      int t = target - c;
      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == t) {
          if (mid == k) break;
          array = Arrays.asList(c, nums[mid]);
          break;
        } else if (nums[mid] < t) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }

      if (!array.isEmpty()) {
        output.add(array);
      }
    }
    return output;
  }
}
