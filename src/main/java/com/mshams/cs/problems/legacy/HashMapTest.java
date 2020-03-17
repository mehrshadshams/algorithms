package com.mshams.cs.problems.legacy;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
  static void checkMagazine(String[] magazine, String[] note) {
    Map<Character, Integer> chars = new HashMap<>();
    for (String s : magazine) {
      for (char c : s.toCharArray()) {
        int count = chars.getOrDefault(c, 0);
        chars.put(c, count + 1);
      }
    }

    boolean can = true;
    for (String s : note) {
      for (char c : s.toCharArray()) {
        int count = chars.getOrDefault(c, 0);
        if (count == 0) {
          can = false;
          break;
        } else {
          chars.put(c, count - 1);
        }
      }
      if (!can) {
        break;
      }
    }

    System.out.println(can ? "Yes" : "No");
  }

}
