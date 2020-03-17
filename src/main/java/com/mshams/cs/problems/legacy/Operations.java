package com.mshams.cs.problems.legacy;

public class Operations extends Problem {

  public int negate(int n) {
    int sign = n > 0 ? -1 : 1;
    int neg = 0;
    while (n > 0) {
      neg += sign;
      n += sign;
    }
    return neg;
  }

  public int subtract(int a, int b) {
    return a + negate(b);
  }

  public int multiply(int a, int b) {
    if (a < b) {
      int t = a;
      a = b;
      b = t;
    }

    int sign = 1;
    if ((a < 0 || b < 0) && !(a < 0 && b < 0)) {
      sign = -1;
    }

    int mul = 0;
    for (int x = 0; x < Math.abs(b); x++) {
      mul += a;
    }

    return sign < 0 ? negate(mul) : mul;
  }


  @Override
  void run() {

  }
}
