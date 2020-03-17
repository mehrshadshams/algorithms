package com.mshams.cs.problems.legacy;

import java.util.ArrayList;

public class Painters {
  int paintersRequired(ArrayList<Integer> L, long maxLength) {
    int painters = 1;
    long painted = maxLength;
    for (int i : L) {
      painted -= i;
      if (painted < 0) {
        painters++;
        painted = maxLength - i;
      }
    }
    return painters;
  }

  public int paint(int K, int T, ArrayList<Integer> L) {
    long upper = 0;
    long lower = 0;
    for (int i : L) {
      upper += i;
      if (i > lower) lower = i;
    }

    while (upper > lower) {
      long med = lower + (upper - lower) / 2;
      int req = paintersRequired(L, med);
      if (req <= K) {
        upper = med;
      } else {
        lower = med + 1;
      }
    }

    return (int) ((upper % 10000003L) * (long) T % 10000003L);
  }
}
