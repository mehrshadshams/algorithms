package com.mshams.cs.problems.skienna.chapter7;

/**
 * Skienna: Question 7-14
 * Topics: Backtracking
 */
public class PermutationOfLetters {
  public static void main(String[] args) {
    PermutationOfLetters p = new PermutationOfLetters();
    p.printPermutation("abb");
  }

  public void printPermutation(String input) {
    printPermutation(input, "");
  }

  private void printPermutation(String input, String chosen) {
    if (input.length() == 0) {
      System.out.println(chosen);
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      String p = input.substring(0, i) + input.substring(i + 1);
      printPermutation(p, chosen + c);
    }
  }
}
