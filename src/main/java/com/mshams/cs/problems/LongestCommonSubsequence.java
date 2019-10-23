package com.mshams.cs.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class LongestCommonSubsequence {
    public Collection<String> findLCS(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        List<String> solutions = findSolutions(dp, a, b, m, n);

        return new HashSet<>(solutions);
    }

    private List<String> findSolutions(int[][] dp, String a, String b, int m, int n) {
        if (m <= 0 || n <= 0) {
            List<String> q = new ArrayList<>();
            q.add("");
            return q;
        }

        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            List<String> temp = findSolutions(dp, a, b, m - 1, n - 1);
            char c = a.charAt(m - 1);
            for (int i = 0; i < temp.size(); i++) {
                temp.set(i, temp.get(i) + c);
            }

            return temp;
        } else if (dp[m - 1][n] > dp[m][n - 1]) {
            return findSolutions(dp, a, b, m - 1, n);
        } else if (dp[m][n - 1] > dp[m - 1][n]) {
            return findSolutions(dp, a, b, m, n - 1);
        } else {
            List<String> top = findSolutions(dp, a, b, m - 1, n);
            List<String> left = findSolutions(dp, a, b, m, n - 1);

            top.addAll(left);

            return top;
        }
    }
}
