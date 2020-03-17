package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;
import com.mshams.cs.utils.interfaces.Tricky;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
@Complexity(ComplexityLevel.MEDIUM)
@Tricky
public class KthLargestElement {
  public int findKthLargest(int[] nums, int k) {
    int n = nums.length;
    if (k > n) return -1;
    int k2 = n - k;
    int lo = 0;
    int hi = n - 1;
    while (lo < hi) {
      int p = partition(nums, lo, hi);
      if (p < k2)
        lo = p + 1;
      else if (p > k2)
        hi = p - 1;
      else
        return nums[k2];
    }

    return nums[k2];
  }

  int partition(int[] a, int lo, int hi) {
    int pivot = a[lo];
    int i = lo + 1, j = hi;
    while (i < j) {
      while (a[i] < pivot) {
        if (i == hi)
          break;
        i++;
      }
      while (a[j] > pivot) {
        if (i == lo)
          break;
        j--;
      }
      if (i >= j)
        break;
      swap(a, i, j);
    }
    swap(a, lo, j);
    return j;
  }
}
