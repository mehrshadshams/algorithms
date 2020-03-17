package com.mshams.cs.problems.legacy;

import java.util.HashSet;
import java.util.Set;

import static com.mshams.cs.problems.legacy.Utils.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/833/
 * TODO
 */
public class LongestConsecutiveSequence extends Problem {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    int length = 0;
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      int count = 0;
      while (set.contains(n)) {
        count++;
        n = n - 1;
      }
      length = Math.max(length, count);
    }
    return length;
  }

  @Override
  void run() {
    int[] nums = array(100, 3, 200, 1, 4, 2);
    System.out.print(longestConsecutive(nums));
  }

  public static void main(String[] args) {
    LongestConsecutiveSequence seq = new LongestConsecutiveSequence();
    seq.run();
  }
}
