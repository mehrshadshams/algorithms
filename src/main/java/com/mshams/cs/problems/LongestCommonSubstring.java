package com.mshams.cs.problems;

/**
 * Complexity - Time O(n^2) Space O(m * n)
 * Space complexity can be improved to O(n)
 * More efficient solution is to use SuffixTree O(m + n)
 */
public class LongestCommonSubstring {
    public String findLongestCommonSubstring(String a, String b) {
        int maxLength = -1;
        int endingIndex = 0;

        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endingIndex = i;
                    }
                }
            }
        }

        return a.substring(endingIndex - maxLength, endingIndex);
    }
}
