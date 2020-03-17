package com.mshams.cs.problems.legacy;

public class Sqrt {

  public static int sqrt(int n) {
    long mid = 0;
    if (n <= 1) {
      return n;
    }

    long min = 0;
    long max = (long) n;
    while (max - min > 1) {
      mid = (max + min) / 2;
      long pow = mid * mid;
      if (pow == n) {
        break;
      } else if (pow > n) {
        max = mid;
      } else {
        min = mid;
      }
    }

    return (int) mid;
  }

  public static void main(String[] args) {

    System.out.println(sqrt(Integer.MAX_VALUE));
  }
}
