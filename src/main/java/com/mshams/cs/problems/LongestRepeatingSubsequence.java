package com.mshams.cs.problems;

/**
 * Finding the longest subsequence of a string that occurs at least twice
 * Complexity:
 * - Top bottom, no memo: Time O(2^n) Space O(1)
 * - Bottom up., DP: Time O(n^2) Space O(n^2)
 */
public class LongestRepeatingSubsequence {
  public String lrs(String s) {
    int m = s.length();
    int[][] dp = new int[m + 1][m + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= m; j++) {
        if (i != j && s.charAt(i - 1) == s.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return findLRS(s, dp, m, m);
  }

  private String findLRS(String s, int[][] dp, int m, int n) {
    if (m == 0 || n == 0) {
      return "";
    }

    if (m != n && s.charAt(m - 1) == s.charAt(n - 1)) {
      return findLRS(s, dp, m - 1, n - 1) + s.charAt(m - 1);
    }

    if (dp[m - 1][n] > dp[m][n - 1]) {
      return findLRS(s, dp, m - 1, n);
    }

    return findLRS(s, dp, m, n - 1);
  }
}
