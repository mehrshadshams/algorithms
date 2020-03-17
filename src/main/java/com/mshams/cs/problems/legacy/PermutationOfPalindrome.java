package com.mshams.cs.problems.legacy;

public class PermutationOfPalindrome extends Problem {
  boolean isPermutation(String str) {
    str = str.toLowerCase();
    int bitVector = 0;
    for (char c : str.toCharArray()) {
      int value = getCharNumber(c);
      if (value >= 0) {
        bitVector = toggleBit(bitVector, value);
      }
    }

    return ((bitVector - 1) & bitVector) == 0;
  }

  private int toggleBit(int bitVector, int value) {
    int mask = 1 << value;
    if ((bitVector & mask) == 0) {
      bitVector |= mask;
    } else {
      bitVector &= ~mask;
    }
    return bitVector;
  }

  private int getCharNumber(char ch) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int c = Character.getNumericValue(ch);
    if (a <= c && c <= z) {
      return c - a;
    }

    return -1;
  }

  @Override
  void run() {
    System.out.println(isPermutation("Tact Coa"));
  }
}
