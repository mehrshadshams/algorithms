package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.array;

/**
 * TODO
 */
public class HouseRobberII extends Problem {
  public int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];

    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  int rob(int[] nums, int lo, int hi) {
    int include = 0, exclude = 0;
    for (int j = lo; j <= hi; j++) {
      int i = include, e = exclude;
      include = e + nums[j];
      exclude = Math.max(e, i);
    }
    return Math.max(include, exclude);
  }

  @Override
  void run() {
    print(rob(array(1, 3, 1, 3, 100)));
  }
}
