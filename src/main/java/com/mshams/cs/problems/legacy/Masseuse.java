package com.mshams.cs.problems.legacy;

public class Masseuse extends Problem {

  public int maxMinutes(int[] minutes) {
    int[] memo = new int[minutes.length];
    return maxMinutes(minutes, memo, 0, 0);
  }

  public int maxMinutesIterative(int[] minutes) {
    int[] memo = new int[minutes.length + 2];
    for (int i = minutes.length - 1; i >= 0; i--) {
      int with = minutes[i] + memo[i + 2];
      int without = memo[i + 1];
      memo[i] = Math.max(with, without);
    }
    return memo[0];
  }

  private int maxMinutes(int[] minutes, int[] memo, int index, int total) {
    if (index >= minutes.length) {
      return 0;
    }

    if (memo[index] == 0) {
      int with = minutes[index] + maxMinutes(minutes, memo, index + 2, total);
      int without = maxMinutes(minutes, memo, index + 1, total);

      memo[index] = total + Math.max(with, without);
    }

    return memo[index];
  }

  @Override
  void run() {
    int[] array = {30, 15, 60, 75, 45, 15, 15, 45};
    //{75, 105, 120, 75, 90, 135};
    System.out.println(maxMinutesIterative(array));
  }
}
