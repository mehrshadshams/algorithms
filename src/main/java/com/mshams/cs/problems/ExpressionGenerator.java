package com.mshams.cs.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class ExpressionGenerator {
  public List<String> addOperators(String num, int target) {
    List<String> expressions = new ArrayList<>();
    generate(num, 0, 0, target, new ArrayList<>(), new ArrayList<>(), expressions);
    return expressions;
  }

  void generate(String num, int i, int current, int target, List<Integer> operands, List<Character> operators, List<String> exps) {
    current = current * 10 + Character.getNumericValue(num.charAt(i));
    if (i == num.length() - 1) {
      operands.add(current);
      int result = evaluate(operands, operators);
      if (result == target) {
        exps.add(createExpression(operands, operators));
      }
      operands.remove(operands.size() - 1);
      return;
    }
    if (current > 0) {
      generate(num, i + 1, current, target, operands, operators, exps);
    }

    // *
    operands.add(current);
    operators.add('*');
    generate(num, i + 1, 0, target, operands, operators, exps);
    operators.remove(operators.size() - 1);
    operands.remove(operands.size() - 1);

    // +
    operands.add(current);

    operators.add('+');
    generate(num, i + 1, 0, target, operands, operators, exps);
    operators.remove(operators.size() - 1);

    operators.add('-');
    generate(num, i + 1, 0, target, operands, operators, exps);
    operators.remove(operators.size() - 1);

    operands.remove(operands.size() - 1);
  }

  int evaluate(List<Integer> operands, List<Character> operators) {
    Stack<Integer> nums = new Stack<>();
    int operandIndex = 0;
    nums.add(operands.get(operandIndex++));
    for (char operator : operators) {
      if (operator == '*') {
        nums.push(nums.pop() * operands.get(operandIndex++));
      } else {
        nums.push(operands.get(operandIndex++));
      }
    }

    for (char operator : operators) {
      if (operator == '-') {
        int a = nums.pop();
        int b = nums.pop();
        nums.push(b - a);
      } else if (operator == '+') {
        nums.push(nums.pop() + nums.pop());
      }
    }
    return nums.pop();
  }

  private String createExpression(List<Integer> operands, List<Character> operators) {
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    sb.append(operands.get(idx++));
    for (char op : operators) {
      sb.append(op);
      sb.append(operands.get(idx++));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ExpressionGenerator eg = new ExpressionGenerator();
    printArray(eg.addOperators("00", 0));
  }
}
