package com.mshams.cs.applications;

import java.util.Comparator;

public class Interval implements Comparable<Interval> {
  public static final Comparator<Interval> START_ASC = Comparator.comparingInt(o -> o.start);
  public static final Comparator<Interval> FINISH_ASC = Comparator.comparingInt(o -> o.end);

  private final int start;
  private final int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int start() {
    return start;
  }

  public int end() {
    return end;
  }

  public boolean intersects(int lo, int hi) {
    return (lo >= start && lo < end) || (hi <= end && hi >= start);
  }

  @Override
  public int compareTo(Interval other) {
    return Integer.compare(end, other.end);
  }
}
