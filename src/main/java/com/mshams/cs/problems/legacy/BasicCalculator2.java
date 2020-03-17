package com.mshams.cs.problems.legacy;

import java.util.List;
import java.util.Stack;

public class BasicCalculator2 extends Problem {
  public int calculate(String s) {
    List<String> postfix = toPostfix(s);

    Stack<Integer> stack = new Stack<>();
    int result = 0;
    String lastNumber = "";
    for (int i = 0; i < postfix.size(); i++) {
      int op = -1;
      String c = postfix.get(i);
      if (c.length() == 1) {
        op = isOperator(c.charAt(0));
      }

      if (op >= 0) {
        int c1 = stack.pop();
        int c2 = stack.pop();
        int out = apply(c2, c1, c.charAt(0));
        result = out;
        stack.push(out);
      } else {
        stack.push(Integer.valueOf(c));
      }
    }

    return result;
  }

  private int apply(int n1, int n2, char op) {
    if (op == '+') {
      return n1 + n2;
    } else if (op == '-') {
      return n1 - n2;
    } else if (op == '*') {
      return n1 * n2;
    } else {
      return n1 / n2;
    }
  }

  private List<String> toPostfix(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    Stack<String> output = new Stack<>();
    String lastNum = "";
    for (char c : chars) {
      if (c != ' ') {
        int order = isOperator(c);
        if (order >= 0) {
          output.push(lastNum);
          lastNum = "";

          if (!stack.isEmpty()) {
            char lastOp = stack.peek();
            int lastOpOrder = isOperator(lastOp);
            if (lastOpOrder < order) {
              stack.pop();
              output.push(String.valueOf(lastOp));
            }
          }
          stack.push(c);
        } else {
          lastNum += String.valueOf(c);
        }
      }
    }

    while (!stack.isEmpty()) {
      if (!lastNum.isEmpty()) {
        output.push(lastNum);
        lastNum = "";
      }
      output.push(String.valueOf(stack.pop()));
    }

    return output;
  }

  private int isOperator(char c) {
    char[] ops = new char[]{'/', '*', '-', '+'};
    int index = -1;
    for (int i = 0; i < ops.length; i++) {
      if (ops[i] == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  @Override
  void run() {
    String exp = "1*2-3/4+5*6-7*8+9/10";
    System.out.println(calculate(exp));
  }
}
