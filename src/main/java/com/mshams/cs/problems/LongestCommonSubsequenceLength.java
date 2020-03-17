package com.mshams.cs.problems;

public class LongestCommonSubsequenceLength {
  public static int lcs(String a, String b) {
    final int m = a.length();
    final int n = b.length();
    //int[][] x = new int[m + 1][n + 1];
    int[] x = new int[n + 1];

    for (int i = 0; i <= m; i++) {
      int[] temp = new int[n + 1];
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          //x[i][j] = 0;
          temp[j] = 0;
        } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
          //x[i][j] = x[i - 1][j - 1] + 1;
          temp[j] = x[j - 1] + 1;
        } else {
          int max;
          if (x[j] > temp[j - 1]) {
            max = x[j];
          } else {
            max = temp[j - 1];
          }
          //x[i][j] = Math.max(x[i - 1][j], x[i][j - 1]);
          temp[j] = max; // Math.max(x[j], temp[j - 1]);
        }
      }
      x = temp;
    }

    //return x[m][n];
    return x[n];
  }

  public static int lcsRecursive(String a, String b) {
    return lcsRecursive(a, b, a.length() - 1, b.length() - 1);
  }

  private static int lcsRecursive(String a, String b, int i, int j) {
    if (i < 0 || j < 0) return 0;
    if (a.charAt(i) == b.charAt(j)) return 1 + lcsRecursive(a, b, i - 1, j - 1);
    return Math.max(lcsRecursive(a, b, i - 1, j), lcsRecursive(a, b, i, j - 1));
  }
}
