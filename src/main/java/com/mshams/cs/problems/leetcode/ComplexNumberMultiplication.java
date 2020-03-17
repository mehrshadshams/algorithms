package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/complex-number-multiplication/
 * <p>
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class ComplexNumberMultiplication {
  public String complexNumberMultiply(String a, String b) {
    ComplexExp c1 = ComplexExp.parse(a);
    ComplexExp c2 = ComplexExp.parse(b);
    return ComplexExp.mul(c1, c2).toString();
  }

  private static class ComplexExp {
    private int a;
    private int b;

    ComplexExp(int a, int b) {
      this.a = a;
      this.b = b;
    }

    static ComplexExp mul(ComplexExp e1, ComplexExp e2) {
      int a = e1.a * e2.a;
      int c = e1.b * e2.b;
      int b = e1.a * e2.b + e1.b * e2.a;
      return new ComplexExp(a - c, b);
    }

    static ComplexExp parse(String s) {
      String[] parts = s.split("\\+");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));

      return new ComplexExp(a, b);
    }

    public String toString() {
      return String.valueOf(a) + "+" + String.valueOf(b) + "i";
    }
  }
}
