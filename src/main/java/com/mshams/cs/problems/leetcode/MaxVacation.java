package com.mshams.cs.problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-vacation-days/
 */
public class MaxVacation {
  public int maxVacationDfs(int[][] flights, int[][] days) {
    int[][] memo = new int[flights.length][days.length];
    for (int i = 0; i < flights.length; i++) {
      Arrays.fill(memo[i], -1);
    }
    return maxVacationDfs(flights, days, 0, 0, memo);
  }

  private int maxVacationDfs(int[][] flights, int[][] days, int currentCity, int week, int[][] memo) {
    if (week == days[0].length) {
      return 0;
    }
    if (memo[currentCity][week] >= 0) {
      return memo[currentCity][week];
    }
    int maxVacation = 0;
    for (int i = 0; i < flights.length; i++) {
      if (flights[currentCity][i] == 1 || i == currentCity) {
        int vac = days[i][week] + maxVacationDfs(flights, days, i, week + 1, memo);
        maxVacation = Math.max(vac, maxVacation);
      }
    }
    memo[currentCity][week] = maxVacation;
    return maxVacation;
  }
}
