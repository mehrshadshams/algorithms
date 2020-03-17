package com.mshams.cs.problems.legacy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 */
public class LongestSubstringKDistinct extends Problem {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> chars = new HashMap<>();
    int j = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      chars.put(c, chars.getOrDefault(c, 0) + 1);
      if (chars.size() <= k) {
        max = Math.max(max, i - j + 1);
      } else {
        char c2 = s.charAt(j);
        j++;
        chars.put(c2, chars.get(c2) - 1);
        if (chars.get(c2) == 0) {
          chars.remove(c2);
        }
        max = Math.max(max, i - j + 1);
      }
    }
    return max;
  }

  @Override
  void run() {
    print(lengthOfLongestSubstringKDistinct("bacc", 2));
  }
}
