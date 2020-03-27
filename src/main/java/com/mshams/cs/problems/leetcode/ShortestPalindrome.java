package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome {
  public String shortestPalindrome(String s) {
    if (s.length() <= 1) return s;
    int n = s.length();
    String rev = new StringBuilder(s).reverse().toString();
    String p = s + "#" + rev;
    int np = p.length();
    int[] f = new int[np];
    for (int i = 1; i < np; i++) {
      int t = f[i - 1];
      while (t > 0 && p.charAt(i) != p.charAt(t)) {
        t = f[t - 1];
      }
      if (p.charAt(i) == p.charAt(t)) {
        ++t;
      }

      f[i] = t;
    }
    return rev.substring(0, n - f[np - 1]) + s;
  }

  public static void main(String[] args) {
    ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
    System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
  }
}
