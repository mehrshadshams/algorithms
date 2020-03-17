package com.mshams.cs.problems.legacy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramPairs {
  static Map<String, Integer> something(String str, int index, Map<String, Integer> last) {
    if (index == str.length()) {
      return last;
    }

    String c = String.valueOf(str.charAt(index));
//        if (!map.containsKey(c)) {
//            map.put(c, 1);
//        }

//        Set<String> keys = new HashSet<>(map.keySet());
//        for (String s : keys) {
//            String s2 = s + c;
//            int count = map.getOrDefault(s2, 0);
//            map.put(s2, count+1);
//        }

    Map<String, Integer> newSet = new HashMap<>();
    newSet.put(c, 1);

    for (String s : last.keySet()) {
      String s2 = sorted(s + c);
      int count = newSet.getOrDefault(s2, 0);
      newSet.put(s2, count + 1);
    }

    Map<String, Integer> set2 = something(str, index + 1, newSet);

    for (String s : set2.keySet()) {
      int count = last.getOrDefault(s, 0);
      last.put(s, count + set2.get(s));
    }

    return last;
  }

  static String sorted(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  static int sherlockAndAnagrams(String s) {
    Map<String, Integer> map = something(s, 0, new HashMap<>());
    int count = 0;
    for (String k : map.keySet()) {
      if (map.get(k) > 1) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String s = "cdcd";
    System.out.println(sherlockAndAnagrams(s));
  }
}
