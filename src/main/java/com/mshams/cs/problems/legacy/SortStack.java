package com.mshams.cs.problems.legacy;

import java.util.Arrays;
import java.util.Stack;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class SortStack extends Problem {
  public Stack<Integer> sort(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<>();

    while (!stack.isEmpty()) {
      int value = stack.pop();

      insert(value, temp, stack);
    }

    return temp;
  }

  void insert(int value, Stack<Integer> temp, Stack<Integer> orig) {
    if (temp.isEmpty()) {
      temp.push(value);
      return;
    }

    int counter = 0;
    while (!temp.isEmpty() && temp.peek() > value) {
      int top = temp.pop();
      orig.add(top);
      counter++;
    }
    temp.add(value);

    for (int i = 0; i < counter; i++) {
      temp.push(orig.pop());
    }
  }

  @Override
  void run() {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(1, 8, 2, 3, 5, 4));
    stack = sort(stack);

    printArray(stack);
  }
}
