package com.mshams.cs.problems;

import com.mshams.cs.utils.StdArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset problem
 * Complexity:
 * - Backtracking: O(2^n)
 * - Dynamic Programming: Time O(n * S) Space O(n * S)
 */
public class SubsetSum {
    private static final int TOP = 0;
    private static final int LEFT = 1;

    private List<Integer> solution = new ArrayList<>();

    public List<Integer> findDP(int[] arr, int sum) {
        final int m = arr.length;
        boolean[][] dp = new boolean[m + 1][sum + 1];
        int[][] bt = new int[m + 1][sum + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    bt[i][j] = TOP;
                } else {
                    if (dp[i - 1][j - arr[i - 1]]) {
                        dp[i][j] = true;
                        bt[i][j] = LEFT;
                    } else if (dp[i - 1][j]) {
                        dp[i][j] = true;
                        bt[i][j] = TOP;
                    }
                }
            }
        }

        if (dp[m][sum]) {
            findSolution(arr, m, bt, sum);
            return solution;
        }

        return new ArrayList<>();
    }

    private boolean findSolution(int[] arr, int j, int[][] bt, int sum) {
        if (j == 0) return true;
        int p = bt[j][sum];
        if (p == LEFT) {
            solution.add(arr[j - 1]);
            return findSolution(arr, j - 1, bt, sum - arr[j - 1]);
        }
        return findSolution(arr, j - 1, bt, sum);
    }

    public List<Integer> findBacktracking(int[] arr, int sum) {
        solution = new ArrayList<>();
        if (find(arr, arr.length, sum, 0)) {
            return solution;
        }

        return new ArrayList<>();
    }

    private boolean find(int[] arr, int n, int sum, int currentSum) {
        if (sum == currentSum) return true;
        if (currentSum > sum) return false;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            solution.add(x);
            StdArray.exch(arr, i, n - 1);

            if (find(arr, n - 1, sum, currentSum + x)) {
                return true;
            }

            solution.remove(solution.size() - 1);
            StdArray.exch(arr, i, arr.length - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        final int[] nums = {15, 22, 14, 26, 32, 9, 16, 8};
        final int sum = 53;
        SubsetSum sol = new SubsetSum();
//        StdArray.print(sol.findBacktracking(nums, sum));
        System.out.println(sol.findDP(nums, sum));
    }
}
