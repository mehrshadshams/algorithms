package com.mshams.cs.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-way-to-form-string/
 */
public class ShortestWay {
  public static void main(String[] args) {
    ShortestWay sw = new ShortestWay();
    System.out.println(sw.shortestWay("xyz", "xzyxz"));
  }

  private static Set<Character> set(String s) {
    Set<Character> set = new HashSet<>();
    for (char c : s.toCharArray()) {
      set.add(c);
    }
    return set;
  }

  private static int isSubsequence(String a, String b, int i) {
    int j = 0;
    for (j = 0; i < a.length() & j < b.length(); i++) {
      char c = a.charAt(i);
      char d = b.charAt(j);
      if (c == d) {
        j++;
      }
    }
    if (j == b.length()) {
      return i;
    }
    return -1;
  }

  public int shortestWay(String source, String target) {
    Set<Character> a = set(source);
    Set<Character> b = set(target);

    int count = 0;
    String s = "";
    int k = 0;
    for (int i = 0; i < target.length(); ) {
      s = String.valueOf(target.charAt(i));
      k = isSubsequence(source, s, k);
      if (k < 0) {
        s = "";
        k = 0;
        count++;
      } else {
        i++;
      }
    }
    if (k > 0) {
      count++;
    }
    return count;
  }
}
