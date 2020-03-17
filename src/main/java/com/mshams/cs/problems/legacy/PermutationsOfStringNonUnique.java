package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class PermutationsOfStringNonUnique extends Problem {
  public List<String> perms(String str) {
    List<String> result = new ArrayList<>();
    Map<Character, Integer> freq = buildFreq(str);
    perms("", str.length(), freq, result);

    return result;
  }

  private void perms(String prefix, int remaining, Map<Character, Integer> map,
                     List<String> result) {
    if (remaining == 0) {
      result.add(prefix);
      return;
    }

    for (Character ch : map.keySet()) {
      int count = map.get(ch);
      if (count > 0) {
        map.put(ch, count - 1);
        perms(prefix + ch, remaining - 1, map, result);
        map.put(ch, count);
      }
    }
  }

  private Map<Character, Integer> buildFreq(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : str.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    return map;
  }

  @Override
  void run() {
    printArray(perms("abcd"));
  }
}
