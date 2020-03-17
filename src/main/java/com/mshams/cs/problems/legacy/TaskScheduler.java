package com.mshams.cs.problems.legacy;

import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/826/
 * TODO
 */
public class TaskScheduler extends Problem {
  public int leastInterval(char[] tasks, int n) {
    List<Character> list = new ArrayList<>();
    PriorityQueue<CharCount> p = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.count, o2.count));
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : tasks) {
      int m = map.getOrDefault(c, 0);
      map.put(c, m + 1);
    }

    for (Character c : map.keySet()) {
      p.add(new CharCount(c, map.get(c)));
    }

    int i = 0;
    while (i < tasks.length) {
      boolean placed = false;

      Stack<CharCount> stack = new Stack<>();
      while (!p.isEmpty()) {
        CharCount cc = p.poll();
        if (canPlace(list, cc.character, n)) {
          cc.count--;
          list.add(cc.character);
          if (cc.count > 0) {
            p.add(cc);
          }
          placed = true;
          break;
        } else {
          stack.add(cc);
        }
      }

      while (!stack.empty()) {
        p.add(stack.pop());
      }

      if (placed) {
        i++;
      } else {
        list.add('0');
      }
    }
    return list.size();
  }

  private boolean canPlace(List<Character> list, char c, int n) {
    if (list.size() == 0) {
      return true;
    }
    int start = Math.max(0, list.size() - n);
    for (int i = start; i < list.size(); i++) {
      char nth = list.get(i);
      if (nth == c) {
        return false;
      }
    }
    return true;
  }

  @Override
  void run() {
    String pat = "AAAAAABCDEFG";

    System.out.println(leastInterval(pat.toCharArray(), 2));
  }

  public static void main(String[] args) {
    TaskScheduler taskScheduler = new TaskScheduler();
    taskScheduler.run();
  }

  private class CharCount {
    char character;
    int count;

    CharCount(char c, int count) {
      this.character = c;
      this.count = count;
    }
  }
}
