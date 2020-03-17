package com.mshams.cs.problems.legacy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * See page 362
 */
public class Coins extends Problem {
  int[] coins = new int[]{25, 10, 5, 1};

  public int numberOfCoins(int n) {
    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    return numberOfCoins(n, map, 0);
  }

  private int numberOfCoins(int amount, Map<Pair<Integer, Integer>, Integer> map, int index) {
    Pair<Integer, Integer> pair = new Pair<>(amount, index);
    if (map.containsKey(pair)) return map.get(pair);
    if (index >= coins.length - 1) return 1;
    int denomAmount = coins[index];
    int ways = 0;
    for (int i = 0; i * denomAmount < amount; i++) {
      int remaining = amount - i * denomAmount;
      ways += numberOfCoins(remaining, map, index + 1);
    }

    map.put(pair, ways);
    return ways;
  }

  @Override
  void run() {
    System.out.println(numberOfCoins(150));
  }
}
