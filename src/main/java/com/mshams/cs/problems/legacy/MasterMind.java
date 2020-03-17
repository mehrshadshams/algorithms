package com.mshams.cs.problems.legacy;

import java.util.HashMap;
import java.util.Map;

public class MasterMind extends Problem {

  public Result count(String guess, String solution) {
    int hit = 0;
    int pseudo = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < guess.length(); i++) {
      char g = guess.charAt(i);
      char s = solution.charAt(i);
      if (g == s) {
        hit++;
      } else {
        if (map.containsKey(s)) {
          map.put(s, map.get(s) - 1);
          pseudo++;
        }
        map.put(g, map.getOrDefault(g, 0) + 1);
      }
    }
    return new Result(hit, pseudo);
  }

  @Override
  void run() {

  }

  class Result {
    int hits;
    int pseudoHits;

    public Result(int hit, int pseudo) {

    }
  }
}
