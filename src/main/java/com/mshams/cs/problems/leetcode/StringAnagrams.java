package com.mshams.cs.problems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    // TODO: Write your code here
    Map<Character, Integer> map = new HashMap<>();
    for (char c : pattern.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int matched = 0, ws = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (map.containsKey(c)) {
        if (matched == 0) {
          ws = i;
        }
        matched++;
        map.put(c, map.get(c) - 1);
      }

      if (matched == pattern.length()) {
        resultIndices.add(ws);
      }

      if (map.getOrDefault(c, 0) == 0 && matched > 0) {
        while (matched > 0) {
          char left = str.charAt(ws++);
          map.put(left, map.get(left) + 1);
          matched--;
        }
      }
    }
    return resultIndices;
  }

  public static void main(String[] args) {
    StringAnagrams.findStringAnagrams("abbcabc", "abc");
  }
}