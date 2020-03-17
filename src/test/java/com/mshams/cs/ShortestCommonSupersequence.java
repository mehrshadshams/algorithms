package com.mshams.cs;

import java.util.*;

public class ShortestCommonSupersequence {
  private final int length;
  private final Set<String> supersequences;

  public ShortestCommonSupersequence(String a, String b) {
    BottomUp strategy = new BottomUp(a, b);
    length = strategy.length;
    supersequences = strategy.supersequences;
  }

  public int length() {
    return length;
  }

  public Collection<String> supersequences() {
    return supersequences;
  }

  private class TopBottom {
    private final int length;

    TopBottom(String a, String b) {
      int m = a.length(), n = b.length();
      length = findLength(a, b, m, n);
      // supersequences = new HashSet<>(findSupersequences(a, b, dp, m, n));
    }

    private int findLength(String a, String b, int m, int n) {
      if (m == 0 || n == 0) {
        return m + n;
      }
      if (a.charAt(m - 1) == b.charAt(n - 1)) {
        return 1 + findLength(a, b, m - 1, n - 1);
      }

      return Integer.min(findLength(a, b, m - 1, n), findLength(a, b, m, n - 1));
    }
  }

  private class BottomUp {
    private final int length;
    private final Set<String> supersequences;

    BottomUp(String a, String b) {
      int m = a.length(), n = b.length();
      int[][] dp = findLength(a, b);
      length = dp[m][n];
      supersequences = new HashSet<>(findSupersequences(a, b, dp, m, n));
    }

    private List<String> findSupersequences(String a, String b, int[][] dp, int m, int n) {
      if (m == 0) {
        return Arrays.asList(b.substring(0, n));
      }
      if (n == 0) {
        return Arrays.asList(a.substring(0, m));
      }
      if (a.charAt(m - 1) == b.charAt(n - 1)) {
        List<String> scs = findSupersequences(a, b, dp, m - 1, n - 1);
        for (int i = 0; i < scs.size(); i++) {
          scs.set(i, scs.get(i) + a.charAt(m - 1));
        }
        return scs;
      } else if (dp[m - 1][n] <= dp[m][n - 1]) {
        List<String> scs = findSupersequences(a, b, dp, m - 1, n);
        for (int i = 0; i < scs.size(); i++) {
          scs.set(i, scs.get(i) + a.charAt(m - 1));
        }
        return scs;
      } else if (dp[m - 1][n] > dp[m][n - 1]) {
        List<String> scs = findSupersequences(a, b, dp, m, n - 1);
        for (int i = 0; i < scs.size(); i++) {
          scs.set(i, scs.get(i) + b.charAt(n - 1));
        }
        return scs;
      } else {
        List<String> top = findSupersequences(a, b, dp, m - 1, n);
        List<String> left = findSupersequences(a, b, dp, m, n - 1);

        List<String> result = new ArrayList<>();
        for (String s : top) {
          result.add(s + a.charAt(m - 1));
        }
        for (String s : left) {
          result.add(s + b.charAt(n - 1));
        }
        return result;
      }
    }

    private int[][] findLength(String a, String b) {
      int m = a.length(), n = b.length();
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++) {
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
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
          }
        }
      }

      return dp;
    }
  }
}
