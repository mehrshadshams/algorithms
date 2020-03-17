package com.mshams.cs.problems.legacy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * TODO
 */
public class DeleteOperationForTwoStrings extends Problem {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] memo = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(memo[i], -1);
    }

    return m + n - 2 * lcs(word1, word2, m, n, memo);
  }

  public int lcs(String word1, String word2, int m, int n, int[][] memo) {
    if (m <= 0 || n <= 0) {
      return 0;
    }

    if (memo[m - 1][n - 1] >= 0) {
      return memo[m - 1][n - 1];
    }

    int val = 0;
    if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
      memo[m - 1][n - 1] = 1 + lcs(word1, word2, m - 1, n - 1, memo);
    } else {
      memo[m - 1][n - 1] = Math.max(lcs(word1, word2, m - 1, n, memo), lcs(word1, word2, m, n - 1, memo));
    }
    return memo[m - 1][n - 1];
  }

  @Override
  void run() {
    System.out.println(minDistance("sea", "eat"));
  }
}
