package com.mshams.cs.problems.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntToRoman {
  public String intToRoman(int num) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("M", 1000);
    map.put("D", 500);
    map.put("C", 100);
    map.put("L", 50);
    map.put("X", 10);
    map.put("V", 5);
    map.put("I", 1);

    return intToRoman(num, map);
  }

  private String intToRoman(int num, Map<String, Integer> map) {
    if (num == 0) return "";

    List<Integer> tem = Arrays.stream(new int[]{1}).sorted().boxed().collect(Collectors.toList());

    for (Map.Entry<String, Integer> e : map.entrySet()) {
      String currentSymbol = e.getKey();
      int current = e.getValue();

      int div = num / current;
      if (div == 0) {
        int diff = current - num;
        if ((diff >= 0 && diff < 10)) {
          if (diff == 9 || diff == 4) {
            return intToRoman(diff) + currentSymbol;
          }
          return intToRoman(90) + currentSymbol + intToRoman(diff);
        }
      } else {
        int mod = num % current;
        return IntStream.range(0, div).mapToObj(x -> currentSymbol).collect(Collectors.joining()) + intToRoman(mod);
      }
    }

    return "";
  }
}
