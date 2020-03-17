package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
  private static boolean isPalindrome(String s, int start, int end) {

    if (end - start <= 0) {
      return true;
    }

    char c1 = s.charAt(start);
    char c2 = s.charAt(end);


    if (!Character.isAlphabetic(c1)) {
      return isPalindrome(s, start + 1, end);
    }
    if (!Character.isAlphabetic(c2)) {
      return isPalindrome(s, start, end - 1);
    }

    return c1 == c2 && isPalindrome(s, start + 1, end - 1);
  }

  public static int myAtoi(String str) {
    if (str == null || str.trim().length() == 0) {
      return 0;
    }

    int index = 0;
    char c1 = str.charAt(0);

    while (index < str.length()) {
      c1 = str.charAt(index);
      if (Character.isWhitespace(c1)) {
        index++;
      } else {
        break;
      }
    }

    if (c1 != '+' && c1 != '-' && !Character.isDigit(c1)) {
      return 0;
    }

    if (c1 == '+' || c1 == '-') {
      index++;
    }

    int sign = 1;
    if (c1 == '-') {
      sign = -1;
    }

    List<Integer> numbers = new ArrayList<>();
    for (int i = index; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!Character.isDigit(c)) {
        break;
      }
      numbers.add(c - '0');
    }

    Long l = 0L;
    if (numbers.size() == 0) {
      return 0;
    } else {
      int s = numbers.size();
      for (int x : numbers) {
        l += (long) ((long) Math.pow(10, s - 1) * x);
        s -= 1;
      }
    }

    l *= sign;

    if (l > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (l < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return l.intValue();
  }

  public static boolean isPalindrome(String s) {
    s = s.toLowerCase();

    int i = 0;
    int j = s.length() - 1;

    return isPalindrome(s, i, j);
  }

  public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
    String s = "Pm_mP";
    System.out.println(myAtoi("2147483648"));
//        System.out.println(isPalindrome(s));
  }
}
