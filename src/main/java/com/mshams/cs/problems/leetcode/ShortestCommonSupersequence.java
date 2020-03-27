package com.mshams.cs.problems.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 */
public class ShortestCommonSupersequence {
  public String shortestCommonSupersequence(String str1, String str2) {
    int m = str1.length(), n = str2.length();
    int[][] dp = findLength(str1, str2);
    StringBuilder sb = new StringBuilder();
    build(sb, str1, str2, m, n, dp);
    return sb.reverse().toString();
  }

  void build(StringBuilder sb, String a, String b, int i, int j, int[][] dp) {
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        sb.append(a.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i][j - 1] > dp[i - 1][j]) {
        sb.append(b.charAt(j - 1));
        j--;
      } else {
        sb.append(a.charAt(i - 1));
        i--;
      }
    }
    while (i > 0) {
      sb.append(a.charAt(i--));
    }
    while (j > 0) {
      sb.append(b.charAt(j--));
    }
  }

  int[][] findLength(String a, String b) {
    int m = a.length(), n = b.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      StringBuilder sb = new StringBuilder();

      char s = (char) ('A' + i);
      dp[i][0] = i;
    }
    for (int j = 1; j <= n; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp;
  }

  public static void main(String[] args) {
    ShortestCommonSupersequence sol = new ShortestCommonSupersequence();
    System.out.println(sol.shortestCommonSupersequence("abac", "cab"));
  }
}
