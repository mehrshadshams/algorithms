package com.mshams.cs.problems.legacy;

public class ValidPalindrome extends Problem {
  public boolean isPalindrome(String s) {
    int l = s.length();

    int i = 0, j = l - 1;
    boolean p = true;
    while (i < l / 2) {
      i = getNext(s, i, 1);
      j = getNext(s, j, -1);

      if (i >= s.length() || j < 0) {
        return false;
      }

      char c1 = Character.toLowerCase(s.charAt(i));
      char c2 = Character.toLowerCase(s.charAt(j));
      if (c1 != c2) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }

  private int getNext(String s, int j, int offset) {
    char c = s.charAt(j);
    while (!Character.isAlphabetic(c)) {
      j += offset;
      if (j < 0 || j >= s.length()) {
        return j;
      }
      c = s.charAt(j);
    }
    return j;
  }

  @Override
  void run() {
    print(isPalindrome("A man, a plan, a canal: Panama"));
  }
}
