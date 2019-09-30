package com.mshams.cs.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    //    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new ArrayList<>();
//        }
//        Arrays.sort(nums);
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], new ArrayList<>());
//            }
//            map.get(nums[i]).add(i);
//        }
//        Set<Pair> set = new HashSet<>();
//        int i = 0;
//        for (;i < nums.length;) {
//            int x = nums[i];
//            int target = -x;
//            if (x <= 0) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    int y = nums[j];
//                    int z = target - y;
//                    if (map.containsKey(z)) {
//                        List<Integer> indices = map.get(z);
//                        for (int w : indices) {
//                            if (w != i && w != j) {
//                                Pair p = new Pair(x, y, z);
//                                set.add(p);
//                            }
//                        }
//                    }
//                }
//            } else {
//                break;
//            }
//            while (i < nums.length && nums[i] == x) {
//                i++;
//            }
//        }
//        List<List<Integer>> out = new ArrayList<>();
//        for (Pair p : set) {
//            out.add(p.getArray());
//        }
//        return out;
//    }
//
//    private class Pair {
//        private int[] arr;
//
//        Pair(int a, int b, int c) {
//            int[] arr = new int[]{a, b, c};
//            Arrays.sort(arr);
//            this.arr = arr;
//        }
//
//        @Override
//        public int hashCode() {
//            return Arrays.hashCode(arr);
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj == null) return false;
//            if (this == obj) return true;
//            Pair p = (Pair) obj;
//            return Arrays.equals(arr, p.arr);
//        }
//
//        public List<Integer> getArray() {
//            return Arrays.asList(arr[0], arr[1], arr[2]);
//        }
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int a = nums[i];

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int b = nums[j];
                int c = nums[k];
                if (a + b + c > 0) {
                    k--;
                } else if (a + b + c < 0) {
                    j++;
                } else {
                    out.add(Arrays.asList(a, b, c));
                    j++;
                    k--;
                }
            }
        }
        return out;
    }
}
