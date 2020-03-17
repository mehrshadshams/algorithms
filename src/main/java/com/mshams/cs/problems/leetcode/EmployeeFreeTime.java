package com.mshams.cs.problems.leetcode;

import java.util.*;

import static com.mshams.cs.utils.StdArray.print;

public class EmployeeFreeTime {
  // Definition for an Interval.
  public static class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }

  ;

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    PriorityQueue<EmpInterval> pq = new PriorityQueue<>();
    int[] index = new int[schedule.size()];

    Stack<Interval> stack = new Stack<>();

    for (int i = 0; i < schedule.size(); i++) {
      pq.add(new EmpInterval(schedule.get(i).get(0), i));
    }

    while (!pq.isEmpty()) {
      EmpInterval empInt = pq.poll();
      int listId = empInt.empId;

      // collapse stack
      if (!stack.isEmpty()) {
        if (intersects(stack.peek(), empInt.interval)) {
          stack.push(merge(stack.pop(), empInt.interval));
        }
      }

      if (index[listId] + 1 < schedule.get(listId).size()) {
        Interval next = schedule.get(listId).get(index[listId] + 1);
        pq.add(new EmpInterval(next, listId));
        Interval free = new Interval(empInt.interval.end, next.start);
        stack.push(free);
        index[listId]++;
      } else {
        //pq.add(new EmpInterval(, listId));
        Interval free = new Interval(empInt.interval.end, Integer.MAX_VALUE);
        stack.push(free);
      }
    }

    List<Interval> out = new ArrayList<>();
    while (!stack.isEmpty()) {
      Interval x = stack.pop();
      if (x.start != Integer.MIN_VALUE && x.end != Integer.MAX_VALUE) {
        out.add(0, x);
      }
    }
    return out;
  }

  private boolean intersects(Interval a, Interval b) {
    return (a.start > b.start && a.start < b.end) ||
            (a.start < b.start && a.end > b.start);
  }

  private Interval merge(Interval a, Interval b) {
    return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
  }

  class EmpInterval implements Comparable<EmpInterval> {
    Interval interval;
    int empId;

    public EmpInterval(Interval x, int id) {
      interval = x;
      empId = id;
    }

    public int compareTo(EmpInterval e) {
      int cmp = Integer.compare(interval.start, e.interval.start);
      if (cmp == 0) return Integer.compare(interval.end, e.interval.end);
      return cmp;
    }
  }

  public static void main(String[] args) {
    List<List<Interval>> list = Arrays.asList(Arrays.asList(
            new Interval(1, 2),
            new Interval(5, 6)
            ),
            Arrays.asList(new Interval(1, 3)),
            Arrays.asList(new Interval(4, 10))
    );
    EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
    List<Interval> results = employeeFreeTime.employeeFreeTime(list);
    print(results);
  }
}
