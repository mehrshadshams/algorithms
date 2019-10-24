package com.mshams.cs.problems;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.reverse;

/**
 * Longest Palindromic Subsequence
 * Complexity
 *  - recursive without memoization time: O(2^n) space: O(1)
 *  - recursive with memoization time: O(n ^ 2) space: O(n ^ 2)
 *  - dynamic programming: time: O(n ^ 2) space: O(n ^ 2)
 */
public class LongestPalindromicSubsequence {
    private final int length;
    private final String lps;
    private final int[][] dp;
    private final Map<String, Integer> memo = new HashMap<>();

    public LongestPalindromicSubsequence(String s) {
        dp = new int[s.length() + 1][s.length() + 1];

        String t = reverse(s);
//        this.length = findLPS(s, 0, s.length() - 1);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        this.length = dp[s.length()][s.length()];
        this.lps = findLPS(s, t, dp, s.length(), s.length());
    }

    private String findLPS(String s, String t, int[][] dp, int m, int n) {
        if (m == 0 || n == 0) return "";

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return findLPS(s, t, dp, m - 1, n - 1) + s.charAt(m - 1);
        }

        if (dp[m - 1][n] > dp[m][n - 1]) {
            return findLPS(s, t, dp, m - 1, n);
        }

        return findLPS(s, t, dp, m, n - 1);
    }

    private int findLPSLength(String s, int i, int j) {
        if (i < j) return 0;
        if (i == j) {
            return 1;
        }

        String key = i + "|" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo.put(key, 2 + findLPSLength(s, i + 1, j - 1));
        } else {
            memo.put(key, Math.max(findLPSLength(s, i + 1, j), findLPSLength(s, i, j - 1)));
        }

        return memo.get(key);
    }

    public int length() {
        return length;
    }

    public String lps() {
        return lps;
    }
}
