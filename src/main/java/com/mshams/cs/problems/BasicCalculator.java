package com.mshams.cs.problems;

import java.util.Stack;

public class BasicCalculator {
  static Operand OPEN = new Operand(-1);
  static Operand CLOSE = new Operand(-1);

  public int calculate(String s) {
    Stack<Character> operators = new Stack<>();
    Stack<Operand> operands = new Stack<>();
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) == ' ') {
        i++;
        continue;
      }
      if (s.charAt(i) == '+' || s.charAt(i) == '-') {
        operators.add(s.charAt(i++));
      } else if (s.charAt(i) == '(') {
        operands.add(OPEN);
        i++;
      } else if (s.charAt(i) == ')') {
        operands.add(evaluate(operands, operators, true));
        i++;
      } else {
        int val = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          val = val * 10 + Character.getNumericValue(s.charAt(i++));
        }
        operands.add(new Operand(val));
      }
    }
    return evaluate(operands, operators, false).value;
  }

  Operand evaluate(Stack<Operand> operands, Stack<Character> operators,
                   boolean toOpen) {
    while (!operators.isEmpty()) {
      if (toOpen && operands.peek() == OPEN) {
        operands.pop();
        break;
      }

      Operand op1 = operands.pop();

      Operand op2 = operands.pop();

      if (op2 == OPEN) {
        operands.add(op1);
        if (toOpen) break;
      }

      char op = operators.pop();

      int val = 0;
      if (op == '+')
        val = op1.value + op2.value;
      else
        val = op2.value - op1.value;

      operands.add(new Operand(val));
    }
    return operands.peek();
  }

  static class Operand {
    int value;

    Operand(int val) {
      this.value = val;
    }
  }

  public static void main(String[] args) {
    BasicCalculator calc = new BasicCalculator();
    System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));
  }
}
