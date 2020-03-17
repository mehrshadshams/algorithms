package com.mshams.cs.problems.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Abbreviation {
  static String abbreviation(String a, String b) {
    Map<List<Integer>, Boolean> dp = new HashMap<>();
    return matches(a, b, 0, 0, dp) ? "YES" : "NO";
  }

  private static boolean matches(String a, String b, int i, int j, Map<List<Integer>, Boolean> dp) {
    if (i == a.length()) return j == b.length();
    if (j == b.length()) {
      while (i < a.length()) {
        if (Character.isUpperCase(a.charAt(i)))
          return false;
        i++;
      }
      return true;
    }
    List<Integer> key = Arrays.asList(i, j);
    if (dp.containsKey(key)) return dp.get(key);
    char c1 = a.charAt(i);
    char c2 = b.charAt(j);
    if (c1 == c2) {
      boolean result = matches(a, b, i + 1, j + 1, dp);
      dp.put(key, result);
      return result;
    }
    if (Character.isUpperCase(c1)) return false;
    boolean withUpper = false;
    if (Character.toUpperCase(c1) == c2)
      withUpper = matches(a, b, i + 1, j + 1, dp);
    if (withUpper) {
      dp.put(key, true);
      return true;
    }
    boolean result = matches(a, b, i + 1, j, dp);
    dp.put(key, result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Abbreviation.abbreviation("bbAaa", "A"));
  }
}
