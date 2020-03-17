package com.mshams.cs.problems.legacy;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/
 */
public class SearchForRange extends Problem {
  public int[] searchRange(int[] nums, int target) {
    int firstIndex = binarySearch(nums, target, 0, nums.length - 1, false);
    int lastIndex = -1;
    if (firstIndex >= 0) {
      lastIndex = binarySearch(nums, target, firstIndex + 1, nums.length - 1, true);
      if (lastIndex < 0) {
        lastIndex = firstIndex;
      }
    }

    return new int[]{firstIndex, lastIndex};
  }

  private int binarySearch(int[] nums, int target, int start, int end, boolean last) {
    if (end < start) {
      return -1;
    }
    int mid = (start + end) / 2;
    int midValue = nums[mid];
    if (!last) {
      if (midValue < target) {
        return binarySearch(nums, target, mid + 1, end, last);
      } else if (midValue > target) {
        return binarySearch(nums, target, start, mid - 1, last);
      } else {
        int index = binarySearch(nums, target, start, mid - 1, last);
        if (index == -1) {
          return mid;
        } else {
          return index;
        }
      }
    } else {
      // looking for last occurence
      if (midValue < target) {
        return binarySearch(nums, target, mid + 1, end, last);
      } else if (midValue > target) {
        return binarySearch(nums, target, start, mid - 1, last);
      } else {
        int index = binarySearch(nums, target, mid + 1, end, last);
        if (index == -1) {
          return mid;
        } else {
          return index;
        }
      }
    }
  }

  @Override
  void run() {
    int[] range = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    System.out.println(range[0] + " " + range[1]);

    range = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    System.out.println(range[0] + " " + range[1]);

  }
}
