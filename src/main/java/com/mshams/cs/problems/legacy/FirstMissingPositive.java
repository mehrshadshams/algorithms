package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/832/
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,1,-1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 * <p>
 * TODO
 */
public class FirstMissingPositive extends Problem {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 1;
    }
    int k = partition(nums) + 1;

    int firstMissing = k;
    for (int i = 0; i < k; i++) {
      int temp = Math.abs(nums[i]);
      if (temp <= k) {
        nums[temp - 1] = nums[temp - 1] < 0 ? nums[temp - 1] : -nums[temp - 1];
      }
    }

    for (int i = 0; i < k; i++) {
      if (nums[i] > 0) {
        firstMissing = i;
        break;
      }
    }

    return firstMissing + 1;
  }

  private int partition(int[] a) {
    int q = -1;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > 0) {
        q++;
        swap(a, i, q);
      }
    }
    return q;
  }

  private void swap(int[] a, int i, int j) {
    if (i != j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

  @Override
  void run() {
    int[] a = array(3, 4, -1, 1);
//        int[] a = array(2, 3, -7, 6, 4, 1, -10, 15);
    System.out.println(firstMissingPositive(a));
  }
}
