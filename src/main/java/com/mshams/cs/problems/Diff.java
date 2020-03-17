package com.mshams.cs.problems;

public class Diff {
  public String diff(String a, String b) {
    int m = a.length(), n = b.length();
    int[][] dp = getLCSLength(a, b);
    return diff(a, b, dp, m, n);
  }

  private String diff(String a, String b, int[][] dp, int m, int n) {
    if (m > 0 && n > 0 && a.charAt(m - 1) == b.charAt(n - 1)) {
      return diff(a, b, dp, m - 1, n - 1) + " " + a.charAt(m - 1);
    }
    // if current character of "b" not present in "a"
    else if (n > 0 && (m == 0 || dp[m][n - 1] >= dp[m - 1][n])) {
      return diff(a, b, dp, m, n - 1) + " +" + b.charAt(n - 1);
    } else if (m > 0 && (n == 0 || dp[m][n - 1] < dp[m - 1][n])) {
      return diff(a, b, dp, m - 1, n) + " -" + a.charAt(m - 1);
    } else {
      return "";
    }
  }

  private int[][] getLCSLength(String a, String b) {
    int m = a.length(), n = b.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp;
  }
}
