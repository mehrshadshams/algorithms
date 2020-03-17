package com.mshams.cs.problems.legacy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class PermutationsOfString extends Problem {
  public Set<String> perms(String str) {
    return perms(str, str.length() - 1);
  }

  private Set<String> perms(String str, int index) {
    if (index == 0) {
      return Collections.singleton(String.valueOf(str.charAt(index)));
    }

    Set<String> temp = perms(str, index - 1);
    Set<String> result = new HashSet<>();
    char ch = str.charAt(index);
    for (String s : temp) {
      for (int i = 0; i < s.length(); i++) {
        result.add(s.substring(0, i) + String.valueOf(ch) + s.substring(i));
      }
      result.add(s + String.valueOf(ch));
    }

    return result;
  }

  @Override
  void run() {
    printArray(perms("abcd"));
  }
}
