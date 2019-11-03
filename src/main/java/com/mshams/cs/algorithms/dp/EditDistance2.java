package com.mshams.cs.algorithms.dp;

/**
 * Edit Distance (Lavenstein Distance)
 * Complexity:
 * - Top down: Time O(3^n)
 * - Bottom up: Time O(m * n) Space O(m * n)
 */
public class EditDistance2 {
    public int topDown(String a, String b) {
        return topDown(a, b, a.length(), b.length());
    }

    public int bottomUp(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[m][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = minimum(
                        dp[i - 1][j - 1] + cost,
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                );
            }
        }

        return dp[m][n];
    }

    private int topDown(String a, String b, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int cost = (a.charAt(m - 1) == b.charAt(n - 1)) ? 0 : 1;

        return minimum(topDown(a, b, m - 1, n) + 1,
                topDown(a, b, m, n - 1) + 1,
                topDown(a, b, m - 1, n - 1) + cost);
    }

    private int minimum(int x, int y, int z) {
        return Integer.min(x, Integer.min(y, z));
    }
}
