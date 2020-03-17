package com.mshams.cs.problems.legacy;

public class MajorityElement extends Problem {
  public int majorityElement(int[] nums) {
    int maj = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        maj = nums[i];
        count++;
      } else if (maj == nums[i]) {
        count++;
      } else {
        count--;
      }
    }
    return maj;

  }

  @Override
  void run() {
    System.out.println(majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
  }
}
