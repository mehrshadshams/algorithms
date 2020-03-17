package com.mshams.cs.problems.legacy;

import java.util.Stack;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class Towers extends Problem {

  @Override
  public void run() {
    int n = 3;
    Tower[] towers = new Tower[n];
    for (int i = 0; i < 3; i++) {
      towers[i] = new Tower(i);
    }
    for (int i = n - 1; i >= 0; i--) {
      towers[0].add(i);
    }
    towers[0].moveDisks(n, towers[1], towers[2]);

    towers[2].print();
  }

  class Tower {
    private final int number;
    private final Stack<Integer> stack = new Stack<>();

    public Tower(int number) {
      this.number = number;
    }

    public void moveDisks(int n, Tower buffer, Tower destination) {
      if (n > 0) {
        moveDisks(n - 1, buffer, destination);
        moveTopTo(buffer);
        buffer.moveDisks(n - 1, destination, this);
      }
    }

    public void moveTopTo(Tower tower) {
      int n = stack.pop();
      tower.add(n);
    }

    public void add(int num) {
//            if (!stack.isEmpty() && stack.peek() <= num) {
//                System.out.println("error");
//            } else {
      stack.push(num);
//            }
    }

    void print() {
      printArray(stack);
    }

    @Override
    public String toString() {
      return number + stack.toString();
    }
  }
}
