package com.mshams.cs.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/wildcard-matching
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    Map<List<String>, Boolean> dp = new HashMap<>();
    p = fixPattern(p);
    if ("".equals(p)) return "".equals(s);
    return isMatchHelper(s, p, dp);
  }

  private String fixPattern(String p) {
    StringBuilder pat = new StringBuilder();
    for (int i = 0; i < p.length(); i++) {
      if (i > 0 && p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
        continue;
      }
      pat.append(p.charAt(i));
    }
    return pat.toString();
  }

  private boolean isMatchHelper(String s, String p, Map<List<String>, Boolean> dp) {
    List<String> key = Arrays.asList(s, p);
    if (dp.containsKey(key)) return dp.get(key);

    boolean res = false;
    if (p.equals(s) || "*".equals(p)) {
      res = true;
    } else if ("".equals(p) || "".equals(s)) {
      res = false;
    } else if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
      res = isMatchHelper(s.substring(1), p.substring(1), dp);
    } else if (p.charAt(0) == '*') {
      res = isMatchHelper(s.substring(1), p, dp) || isMatchHelper(s, p.substring(1), dp);
    }

    StringBuilder sb;


    dp.put(key, res);
    return res;
  }

  public boolean isMatch2(String s, String p) {
    if (s.equals(p) || "*".equals(p)) return true;
    if ("".equals(s) || "".equals(p)) return false;
    char sc = s.charAt(0);
    char pc = p.charAt(0);
    if (sc == pc || pc == '?')
      return isMatch2(s.substring(1), p.substring(1));
    else if (pc == '*')
      return isMatch2(s.substring(1), p) || isMatch2(s, p.substring(1));
    return false;
    
  }

  public static void main(String[] args) {
    WildcardMatching wm = new WildcardMatching();
    boolean result = wm.isMatch2("acdcb", "a*c?b");
    System.out.println(result);
  }
}
