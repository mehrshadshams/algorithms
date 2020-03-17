package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Algorithm;
import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mshams.cs.utils.StdArray.print;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
@Complexity(ComplexityLevel.MEDIUM)
@Algorithm("4^n/sqrt(n)")
public class GenerateParentheses {
  public List<String> generateParentheses(int n) {
    List<String> out = new ArrayList<>();
    generateParentheses(out, "", 0, 0, n);
    return out;
  }

  private void generateParentheses(List<String> list, String prefix, int left, int right, int total) {

    if (prefix.length() == 2 * total) {
      list.add(prefix);
      return;
    }
    if (left < total)
      generateParentheses(list, prefix + "(", left + 1, right, total);
    if (right < left)
      generateParentheses(list, prefix + ")", left, right + 1, total);
  }

  List<String> generateParan(int n) {
    char[] temp = new char[n * 2];
    List<String> output = new ArrayList<>();
    generate(temp, n, n, n, 0, output);
    return output;
  }

  void generate(char[] temp, int n, int left, int right, int i, List<String> output) {
//    if (right > left) return;
    if (left == 0 && right == 0) {
      output.add(String.valueOf(temp));
      return;
    }
    if (left > 0) {
      temp[i] = '(';
      generate(temp, n, left - 1, right, i + 1, output);
    }
    if (left < right) {
      temp[i] = ')';
      generate(temp, n, left, right - 1, i + 1, output);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses g = new GenerateParentheses();
    List<String> out = g.generateParan(3);
    print(out);
  }
}
