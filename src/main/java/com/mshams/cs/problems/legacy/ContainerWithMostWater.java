package com.mshams.cs.problems.legacy;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/830/
 */
public class ContainerWithMostWater extends Problem {
  public int maxArea(int[] height) {
//        int maxArea = 0;
//
//        int start = 0;
//        int end = height.length - 1;
//
//        int maxLeftIndex = -1;
//        int maxRightIndex = -1;
//
//        while (end > start) {
//            int area1 = getArea(height, start, end);
//            int area2 = 0;
//            int area3 = 0;
//
//            if (maxLeftIndex >= 0 && maxRightIndex >= 0) {
//                area2 = getArea(height, maxLeftIndex, end);
//                area3 = getArea(height, start, maxRightIndex);
//            }
//
//            int area = Math.max(area3, Math.max(area1, area2));
//            if (area == area1 && area > maxArea) {
//                maxLeftIndex = start;
//                maxRightIndex = end;
//                maxArea = area1;
//            }
//            if (area == area2 && area > maxArea) {
//                maxRightIndex = end;
//                maxArea = area;
//            }
//            if (area == area3 && area > maxArea) {
//                maxLeftIndex = start;
//                maxArea = area;
//            }
//
//            start++;
//            end--;
//        }
//        return maxArea;
    int max = 0;
    int i = 0, j = height.length - 1;
    while (i < j) {
      int width = j - i;
      int h = Math.min(height[i], height[j]);
      max = (max < h * width) ? h * width : max;
      if (height[i] > height[j]) {
        j--;
      } else {
        i++;
      }
    }
    return max;

  }

  private int getArea(int[] nums, int i, int j) {
    int d = Math.abs(j - i);
    int h = Math.min(nums[i], nums[j]);
    return h * d;
  }

  @Override
  void run() {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(maxArea(new int[] { 2,3,4,5,18,17,6 }));
  }
}
