package com.mshams.cs.algorithms.strings;

public class KMP {
  private final int R = 256;
  private final String pattern;
  private int[][] dfa;

  public KMP(String pat) {
    pattern = pat;
    dfa = new int[R][pattern.length() + 1];

    dfa[pattern.charAt(0)][0] = 1;
    for (int i = 1, x = 0; i < pattern.length(); i++) {
      for (int j = 0; j < R; j++) {
        dfa[j][i] = dfa[j][x];
      }
      dfa[pattern.charAt(i)][i] = i + 1;
      x = dfa[pattern.charAt(i)][x];
    }
  }

  public int search(String text) {
    int m = text.length();
    int n = pattern.length();
    int i = 0, j = 0;
    for (; i < m && j < n; i++) {
      char c = text.charAt(i);
      j = dfa[c][j];
    }

    if (j == n) {
      return i - n;
    }

    return -1;
  }
}
