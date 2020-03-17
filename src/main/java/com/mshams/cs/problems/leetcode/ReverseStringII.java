package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 */
public class ReverseStringII {
  public void reverseWords(char[] s) {
    int n = s.length;

    int start = 0, end = 0;
    reverse(s, 0, n);

    for (int i = 0; i < n; i++) {
      if (s[i] == ' ') {
        reverse(s, start, i);
        start = i + 1;
      }
    }
    reverse(s, start, n);
  }

  private void reverse(char[] s, int start, int end) {
    while (start < end - 1) {
      char tmp = s[start];
      s[start] = s[end - 1];
      s[end - 1] = tmp;
      start++;
      end--;
    }
  }
}
