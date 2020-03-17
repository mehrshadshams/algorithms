package com.mshams.cs.applications;

import java.util.Comparator;

public class Line {
  public static Comparator<Line> HORIZONTAL = new Horizontal();
  public static Comparator<Line> VERTICAL = new Vertical();

  private final Point2D start;
  private final Point2D end;

  public Line(Point2D start, Point2D end) {
    this.start = start;
    this.end = end;
  }

  public Point2D getStart() {
    return start;
  }

  public Point2D getEnd() {
    return end;
  }

  private static class Horizontal implements Comparator<Line> {
    @Override
    public int compare(Line o1, Line o2) {
      return Point2D.X_ORDER.compare(o1.start, o2.start);
    }
  }

  private static class Vertical implements Comparator<Line> {
    @Override
    public int compare(Line o1, Line o2) {
      return Point2D.Y_ORDER.compare(o1.start, o2.end);
    }
  }
}
