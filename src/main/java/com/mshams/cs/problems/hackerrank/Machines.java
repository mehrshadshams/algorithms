package com.mshams.cs.problems.hackerrank;

import java.util.Arrays;

public class Machines {
  static long minTime(long[] machines, long goal) {
    Arrays.sort(machines);
    long low = (long) ((double) goal / ((double) machines.length / machines[0]));
    long high = (long) ((double) goal / ((double) machines.length / machines[machines.length - 1])) + 1;
    while (low < high) {
      long numDays = low + (high - low) / 2;
      long total = getProducts(machines, numDays);
      if (total == goal) return numDays;
      if (total > goal) {
        high = numDays - 1;
      } else {
        low = numDays + 1;
      }
    }
    return low;
  }

  static long getProducts(long[] machines, long numDays) {
    long products = 0L;
    for (long m : machines) {
      products += numDays / m;
    }
    return products;
  }

  public static void main(String[] args) {
    System.out.println(Machines.minTime(new long[]{2, 3}, 5));
  }
}
