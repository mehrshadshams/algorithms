package com.mshams.cs.applications;

import java.util.Comparator;

public class WeightedInterval implements Comparable<WeightedInterval> {
  public static final Comparator<WeightedInterval> START_ASC = Comparator.comparingInt(o -> o.start);
  public static final Comparator<WeightedInterval> FINISH_ASC = Comparator.comparingInt(o -> o.end);

  private final int start;
  private final int end;
  private final int weight;

  public WeightedInterval(int start, int end, int w) {
    this.start = start;
    this.end = end;
    this.weight = w;
  }

  public int start() {
    return start;
  }

  public int end() {
    return end;
  }

  public int weight() {
    return weight;
  }

  public boolean intersects(int lo, int hi) {
    return (lo >= start && lo < end) || (hi <= end && hi >= start);
  }

  @Override
  public int compareTo(WeightedInterval other) {
    int diff = end - start;
    if (diff < 0) return -1;
    if (diff > 0) return +1;
    return 0;
  }

  @Override
  public String toString() {
    return "[" + start + ":" + end + ", w=" + weight + "]";
  }
}
