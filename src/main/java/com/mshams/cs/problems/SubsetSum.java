package com.mshams.cs.problems;

import com.mshams.cs.utils.StdArray;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    List<Integer> solution = new ArrayList<>();
    public List<Integer> find(int[] nums, int s) {
        if (find(nums, nums.length, 0, s)) {
            return solution;
        }
        return new ArrayList<>();
    }

    private boolean find(int[] nums, int n, int currentSum, int sum) {
        if (currentSum == sum) {
            return true;
        }
        if (currentSum > sum) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            solution.add(x);
            StdArray.exch(nums, i, n - 1);
            if (find(nums, n-1, currentSum + x, sum)) {
                return true;
            }
            solution.remove(solution.size() - 1);
            StdArray.exch(nums, i, n - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {15, 22, 14, 26, 32, 9, 16, 8};
        SubsetSum sol = new SubsetSum();
        StdArray.print(sol.find(nums, 53));
    }
}
