package com.mshams.cs.problems.legacy;

public class RegularExpMatching extends Problem {

  public boolean isMatch(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    }

    boolean firstMatch = s.length() > 0 &&
            (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?');
    if (p.length() >= 2 && p.charAt(1) == '*') {
      return isMatch(s, p.substring(2)) ||
              firstMatch && isMatch(s.substring(1), p);
    } else {
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
  }

  @Override
  void run() {
    String text = "aab";
    String p = "c*a*b";
    System.out.println(isMatch(text, p));
  }
}
