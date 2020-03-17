package com.mshams.cs.problems.legacy;

import java.util.Stack;

/**
 * TODO
 */
public class BasicCalculatorStack extends Problem {

  public double run(String exp) {
    Stack<Double> numberStack = new Stack<>();
    Stack<Operator> operatorStack = new Stack<Operator>();

    for (int i = 0; i < exp.length(); i++) {
      int nextNumber = parseNextNumber(exp, i);
      numberStack.push((double) nextNumber);

      i += String.valueOf(nextNumber).length();

      while (i < exp.length() && exp.charAt(i) == ' ') {
        i++;
      }

      if (i >= exp.length()) {
        break;
      }

      Operator nextOp = parseNextOperator(exp, i);
      i++;

      collapseStacks(nextOp, numberStack, operatorStack);

      operatorStack.push(nextOp);
    }

    collapseStacks(Operator.BLANK, numberStack, operatorStack);

    return numberStack.pop();
  }

  private void collapseStacks(Operator nextOp, Stack<Double> numberStack, Stack<Operator> operatorStack) {
    while (numberStack.size() > 2 && operatorStack.size() > 1) {
      if (nextOp.priority() < operatorStack.peek().priority()) {
        double second = numberStack.pop();
        double first = numberStack.pop();
        Operator op = operatorStack.pop();

        double result = applyOperator(first, second, op);
        numberStack.push(result);
      } else {
        break;
      }
    }
  }

  private double applyOperator(double first, double second, Operator op) {
    double result = 0;
    switch (op) {

      case ADD:
        result = first + second;
        break;
      case MUL:
        result = first * second;
        break;
      case DIV:
        result = first / second;
        break;
      case SUB:
        result = first - second;
        break;
      case BLANK:
        break;
    }
    return result;
  }

  private Operator parseNextOperator(String exp, int i) {
    return Operator.from(exp.charAt(i));
  }

  int parseNextNumber(String exp, int i) {
    String num = "";
    char c = exp.charAt(i++);

    while (c != ' ' || Character.isDigit(c)) {
      num += c;

      if (i >= exp.length()) {
        break;
      }

      c = exp.charAt(i++);
    }

    if (!"".equals(num)) {
      return Integer.valueOf(num);
    }

    return 0;
  }

  @Override
  void run() {
    String exp = "2 - 6 - 7 * 8 / 2 + 5";
    System.out.println(run(exp));
  }

  enum Operator {
    ADD, MUL, DIV, SUB, BLANK;

    public static Operator from(char ch) {
      if (ch == '+') {
        return ADD;
      } else if (ch == '*') {
        return MUL;
      } else if (ch == '-') {
        return SUB;
      } else if (ch == '/') {
        return DIV;
      } else {
        return BLANK;
      }
    }

    public int priority() {
      if (this == ADD || this == SUB) {
        return 1;
      } else if (this == MUL || this == DIV) {
        return 2;
      }
      return 0;
    }
  }
}
