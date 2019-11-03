package com.mshams.cs.problems;

import java.util.Arrays;

/**
 * Increasing Subsequence Maximum Sum
 */
public class IncreasingSubsequenceMaximumSum {
    public int msisTopDown(int[] arr) {
        return msisTopDown(arr, 0, Integer.MIN_VALUE, 0);
    }

    public int msisDP(int[] arr) {
        int[] sum = new int[arr.length];

        sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] < sum[j] && arr[i] > arr[j]) {
                    sum[i] = sum[j];
                }
            }
            sum[i] += arr[i];
        }

        return Arrays.stream(sum).max().getAsInt();
    }

    private int msisTopDown(int[] arr, int i, int prev, int sum) {
        if (i == arr.length) {
            return sum;
        }

        int incl = Integer.MIN_VALUE;
        if (arr[i] > prev) {
            incl = msisTopDown(arr, i + 1, arr[i], sum + arr[i]);
        }

        int excl = msisTopDown(arr, i + 1, prev, sum);

        return Math.max(incl, excl);
    }
}
