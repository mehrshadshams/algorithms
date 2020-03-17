package com.mshams.cs.problems.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 */
public class FreqStack {
  private int time;
  private Map<Integer, FreqStackInternal> map = new HashMap<>();
  private PriorityQueue<FreqStackInternal> pq = new PriorityQueue<>();

  public FreqStack() {

  }

  public void push(int x) {
    if (!map.containsKey(x)) {
      FreqStackInternal f = new FreqStackInternal(x);
      map.put(x, f);
      f.push(time++);
      pq.offer(f);
    } else {
      FreqStackInternal f = map.get(x);
      pq.remove(f);
      f.push(time++);
      pq.offer(f);
    }
  }

  public int pop() {
    FreqStackInternal f = pq.poll();
    int value = f.value;
    f.pop();

    if (f.stack.isEmpty()) {
      map.remove(value);
    } else {
      pq.offer(f);
    }

    return value;
  }

  class FreqStackInternal implements Comparable<FreqStackInternal> {
    private final Stack<Integer> stack = new Stack<>();
    private final int value;

    FreqStackInternal(int value) {
      this.value = value;
    }

    int size() {
      return stack.size();
    }

    void push(int time) {
      stack.push(time);
    }

    int pop() {
      return stack.pop();
    }

    @Override
    public int compareTo(FreqStackInternal o) {
      int cmp = -Integer.compare(size(), o.size());
      if (cmp == 0) return -Integer.compare(stack.peek(), o.stack.peek());
      return cmp;
    }
  }
}
