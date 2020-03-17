package com.mshams.cs.datastructures.searching;

public class SquareRoot {
  public static void main(String[] args) {
    SquareRoot a = new SquareRoot();
    System.out.println(a.sq(300));
  }

  public int sq(int x) {
    int a = 1, b = a * 2;
    int b2 = b * b;

    while (a < b) {
      if (b2 < x) {
        a = b;
        b *= 2;
        b2 = b * b;
      } else if (b2 > x) {
        b = a + (b - a) / 2;
        b2 = b * b;
      } else if (b2 == x) {
        break;
      }
    }

    return b;
  }
}
