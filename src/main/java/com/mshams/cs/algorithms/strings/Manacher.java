package com.mshams.cs.algorithms.strings;

public class Manacher {
  private int[] p;
  private String s;
  private char[] t;

  public Manacher(String s) {
    this.s = s;
    preprocess();
    p = new int[t.length];

    int center = 0, right = 0;
    for (int i = 1; i < t.length - 1; i++) {
      int mirror = 2 * center - i;
      if (right > i) {
        p[i] = Math.min(right - i, p[mirror]);
      }

      while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
        p[i]++;
      }

      if (i + p[i] > right) {
        center = i;
        right = i + p[i];
      }
    }
  }

  public int[] getP() {
    return p;
  }

  // longest palindromic substring
  public String longestPalindromicSubstring() {
    int length = 0;   // length of longest palindromic substring
    int center = 0;   // center of longest palindromic substring
    for (int i = 1; i < p.length - 1; i++) {
      if (p[i] > length) {
        length = p[i];
        center = i;
      }
    }
    return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
  }

  // longest palindromic substring centered at index i/2
  public String longestPalindromicSubstring(int i) {
    int length = p[i + 2];
    int center = i + 2;
    return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
  }

  private void preprocess() {
    t = new char[s.length() * 2 + 3];
    t[0] = '$';
    t[s.length() * 2 + 2] = '@';
    for (int i = 0; i < s.length(); i++) {
      t[2 * i + 1] = '#';
      t[2 * i + 2] = s.charAt(i);
    }
    t[s.length() * 2 + 1] = '#';
  }
}
