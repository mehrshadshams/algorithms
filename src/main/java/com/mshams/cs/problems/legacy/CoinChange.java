package com.mshams.cs.problems.legacy;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange extends Problem {
  public int coinChange(int[] coins, int amount) {
    return coinChange(coins, amount, new int[amount]);
  }

  public int coinChange(int[] coins, int rem, int[] memo) {
    if (rem < 0)
      return -1;
    if (rem == 0)
      return 0;
    if (memo[rem - 1] != 0)
      return memo[rem - 1];
    int min = Integer.MAX_VALUE;
    for (int c : coins) {
      int res = coinChange(coins, rem - c, memo);
      if (res >= 0 && res < min) {
        min = 1 + res;
      }
    }
    memo[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return memo[rem - 1];
  }

  @Override
  void run() {

  }
}
