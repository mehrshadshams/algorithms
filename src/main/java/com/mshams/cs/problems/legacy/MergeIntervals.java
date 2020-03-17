package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeIntervals extends Problem {
  public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

    Stack<Interval> stack = new Stack<>();
    if (intervals.size() > 0) {
      stack.add(intervals.get(0));
    }
    for (int i = 1; i < intervals.size(); i++) {
      Interval in = intervals.get(i);
      Interval top = stack.peek();
      if (overlaps(in, top)) {
        stack.pop();
        Interval merge = merge(in, top);
        stack.add(merge);
      } else {
        stack.add(in);
      }
    }
    return new ArrayList<>(stack);
  }

  private boolean overlaps(Interval i1, Interval i2) {
    return (i1.start <= i2.start && i1.end >= i2.start) || (i2.start <= i1.start && i2.end >= i1.start);
  }

  private Interval merge(Interval interval1, Interval interval2) {
    return new Interval(Math.min(interval1.start, interval2.start), Math.max(interval1.end, interval2.end));
  }

  @Override
  void run() {

  }

  public class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }
}
