package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

/**
 *
 */
@Complexity(ComplexityLevel.EASY)
public class AddStrings {
  public static void main(String[] args) {
    AddStrings addStrings = new AddStrings();
    System.out.println(addStrings.addStrings("99", "9"));
  }

  public String addStrings(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    String shorter = "", longer = "";
    if (num1.length() < num2.length()) {
      shorter = num1;
      longer = num2;
    } else {
      shorter = num2;
      longer = num1;
    }
    int i = shorter.length() - 1;
    int j = longer.length() - 1;
    int carry = 0;
    for (; i >= 0; i--, j--) {
      int x = Character.getNumericValue(shorter.charAt(i));
      int y = Character.getNumericValue(longer.charAt(j));
      int z = carry + x + y;
      carry = z / 10;
      result.insert(0, String.valueOf(z % 10));
    }
    if (j >= 0) {
      while (j >= 0) {
        int x = carry + Character.getNumericValue(longer.charAt(j));
        carry = x / 10;
        result.insert(0, String.valueOf(x % 10));
        j--;
      }
    }
    if (carry != 0) {
      result.insert(0, String.valueOf(carry));
    }
    return result.toString();
  }
}
