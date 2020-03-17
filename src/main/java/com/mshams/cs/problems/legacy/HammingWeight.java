package com.mshams.cs.problems.legacy;

public class HammingWeight extends Problem {
  public int hammingWeight(int n) {
    int c = 0;
    for (int i = 0; i < 32; i++) {
      c += n & 1;
      n = n >> 1;
    }
    return c;
  }

  @Override
  void run() {
    hammingWeight(2);
  }
}
