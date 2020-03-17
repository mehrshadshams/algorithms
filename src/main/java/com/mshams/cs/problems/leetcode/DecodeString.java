package com.mshams.cs.problems.leetcode;

import java.util.Stack;

public class DecodeString {
  public String decodeString(String s) {
    Stack<Repeat> stack = new Stack<>();
    int i = 0;
    stack.push(new Repeat(1));
    while (i < s.length()) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          num = num * 10 + (s.charAt(i++) - '0');
        }
        stack.push(new Repeat(num));
      } else if (c == '[') {
        i++;
      } else if (c == ']') {
        Repeat r = stack.pop();
        stack.peek().append(r.evaluate());
        i++;
      } else {
        stack.peek().append(c);
        i++;
      }
    }
    return stack.peek().evaluate();
  }

  class Repeat {
    int count;
    StringBuilder str;

    Repeat(int count) {
      this.count = count;
      this.str = new StringBuilder();
    }

    void append(char c) {
      str.append(c);
    }

    void append(String s) {
      str.append(s);
    }

    String evaluate() {
      StringBuilder out = new StringBuilder();

      String s = str.toString();
      for (int i = 0; i < count; i++) {
        out.append(s);
      }

      return out.toString();
    }
  }

  public static void main(String[] args) {
    DecodeString es = new DecodeString();
    System.out.println(es.decodeString("3[a2[c]]"));
  }
}
