package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * Very important
 * https://leetcode.com/problems/remove-invalid-parentheses
 * TODO
 */
public class RemoveInvalidParentheses extends Problem {

  private Set<String> validExpressions = new HashSet<String>();

  private void recurse(
          String s,
          int index,
          int leftCount,
          int rightCount,
          int leftRem,
          int rightRem,
          StringBuilder expression) {

    // If we reached the end of the string, just check if the resulting expression is
    // valid or not and also if we have removed the total number of left and right
    // parentheses that we should have removed.
    if (index == s.length()) {
      if (leftRem == 0 && rightRem == 0) {
        this.validExpressions.add(expression.toString());
      }

    } else {
      char character = s.charAt(index);
      int length = expression.length();

      // The discard case. Note that here we have our pruning condition.
      // We don't recurse if the remaining count for that parenthesis is == 0.
      if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
        this.recurse(
                s,
                index + 1,
                leftCount,
                rightCount,
                leftRem - (character == '(' ? 1 : 0),
                rightRem - (character == ')' ? 1 : 0),
                expression);
      }

      expression.append(character);

      // Simply recurse one step further if the current character is not a parenthesis.
      if (character != '(' && character != ')') {

        this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

      } else if (character == '(') {

        // Consider an opening bracket.
        this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

      } else if (rightCount < leftCount) {

        // Consider a closing bracket.
        this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
      }

      // Delete for backtracking.
      expression.deleteCharAt(length);
    }
  }

  public List<String> removeInvalidParentheses(String s) {

    int left = 0, right = 0;

    // First, we find out the number of misplaced left and right parentheses.
    for (int i = 0; i < s.length(); i++) {

      // Simply record the left one.
      if (s.charAt(i) == '(') {
        left++;
      } else if (s.charAt(i) == ')') {
        // If we don't have a matching left, then this is a misplaced right, record it.
        right = left == 0 ? right + 1 : right;

        // Decrement count of left parentheses because we have found a right
        // which CAN be a matching one for a left.
        left = left > 0 ? left - 1 : left;
      }
    }

    this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
    return new ArrayList<String>(this.validExpressions);
  }

  /*
  public List<String> removeInvalidParentheses(String s) {
    Set<String> output = new HashSet<>();
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(s);
    visited.add(s);

    boolean found = false;
    while (!queue.isEmpty()) {
      s = queue.poll();

      if (isValid(s)) {
        output.add(s);
        found = true;
      }

      if (found) continue;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
        String t = s.substring(0, i) + s.substring(i + 1);
        if (!visited.contains(t)) {
          queue.add(t);
          visited.add(t);
        }
      }
    }

//        removeInvalidParentheses(s, 0, "", output);

    return new ArrayList<>(output);
  }

  void removeInvalidParentheses(String s, int index, String value, Set<String> output) {
    if (index >= s.length()) {
      boolean valid = isValid(value);
      if (valid) {
        output.add(value);
      }
      return;
    }

    char ch = s.charAt(index);

    removeInvalidParentheses(s, index + 1, value + ch, output);
    removeInvalidParentheses(s, index + 2, value, output);
  }

  boolean isValid(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(') count++;
      if (c == ')' && count-- == 0) return false;
    }
    return count == 0;
  }
  */

  @Override
  void run() {
    String str = "()())()";
//        str = "(a)())()";
//        str = ")(";

    List<String> output = removeInvalidParentheses(str);

    printArray(output);
  }

  class Validation {
    String output;
    boolean valid;

    Validation(String output, boolean valid) {
      this.output = output;
      this.valid = valid;
    }
  }
}
