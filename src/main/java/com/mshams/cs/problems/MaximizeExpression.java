package com.mshams.cs.problems;

import java.util.Arrays;

/**
 * Maximize the value of an expression a[s]-a[r]+a[q]-a[p] where s > r > q > p
 * Complexity: O(n)
 */
public class MaximizeExpression {
    public int maximize(int[] arr) {
        final int n = arr.length;

        int[] l1 = new int[n + 1];
        int[] l2 = new int[n];
        int[] l3 = new int[n - 1];
        int[] l4 = new int[n - 2];

        Arrays.fill(l1, Integer.MIN_VALUE);
        Arrays.fill(l2, Integer.MIN_VALUE);
        Arrays.fill(l3, Integer.MIN_VALUE);
        Arrays.fill(l4, Integer.MIN_VALUE);

        for (int i = n - 1; i >= 0; i--) {
            l1[i] = Integer.max(l1[i + 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            l2[i] = Integer.max(l2[i + 1], l1[i + 1] - arr[i]);
        }

        for (int i = n - 3; i >= 0; i--) {
            l3[i] = Integer.max(l3[i + 1], l2[i + 1] + arr[i]);
        }

        for (int i = n - 4; i >= 0; i--) {
            l4[i] = Integer.max(l4[i + 1], l3[i + 1] - arr[i]);
        }

        int[][] memo = new int[5][n + 1];
        for (int i = 1; i < 5; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return l4[0];

//        int coeff = 1;
//        for (int i = 1; i < 5; i++) {
//            for (int j = n - i; j >= 0; j--) {
//                memo[i][j] = Integer.max(memo[i][j + 1], memo[i - 1][j + 1] + arr[j] * coeff);
//            }
//            coeff *= -1;
//        }
//
//        return memo[4][0];
    }
}
