package com.mshams.cs.problems.legacy;

/**
 * https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/334/
 * TODO
 */
public class DecodeWays extends Problem {
  public int numDecodings(String s) {
//        boolean[] b = new boolean[s.length()];
//        return decode(s, 0, b);
    int[] memo = new int[s.length() + 1];
    int n = s.length();
    memo[n] = 1;
    memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
    for (int i = s.length() - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') continue;
      int total = memo[i + 1];
      if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
        total = total + memo[i + 2];
      }
      memo[i] = total;
    }
    return memo[0];
  }

  private int decode(String s, int lo, boolean[] v) {
    if (lo >= s.length()) {
      return 0;
    }

    if (s.charAt(lo) == '0') {
      return 0;
    }

    if (v[lo]) {
      return 0;
    }

    v[lo] = true;

    int total = 1;

    decode(s, lo + 1, v);

    if (lo + 2 <= s.length()) {
      int sub = Integer.parseInt(s.substring(lo, lo + 2));
      if (sub <= 26) {
        total++;
        decode(s, lo + 2, v);
      }
    }

    return total;
  }

  @Override
  void run() {
    print(numDecodings("226"));
  }
}
