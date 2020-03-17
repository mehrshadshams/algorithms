package com.mshams.cs.problems.legacy.common;

import java.util.Objects;

public class Range implements Comparable<Range> {
  int start;
  int end;

  public Range(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Range range = (Range) o;
    return start == range.start && end == range.end;
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  @Override
  public int compareTo(Range o) {
    return Integer.compare((end - start), o.end - o.start);
  }

  @Override
  public String toString() {
    return "Range{" + "start=" + start + ", end=" + end + '}';
  }
}
