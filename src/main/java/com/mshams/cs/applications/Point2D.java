package com.mshams.cs.applications;

import java.util.Comparator;

public class Point2D implements Comparable<Point2D> {
  public static final Comparator<Point2D> X_ORDER = new XOrder();
  public static final Comparator<Point2D> Y_ORDER = new YOrder();
  public static final Comparator<Point2D> X_Y_ORDER = new XYOrder();
  public static final Comparator<Point2D> R_ORDER = new ROrder();

  private final double x;
  private final double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns true if a→b→c is a counterclockwise turn.
   *
   * @param a first point
   * @param b second point
   * @param c third point
   * @return { -1, 0, +1 } if a→b→c is a { clockwise, collinear; counterclocwise } turn.
   */
  public static int ccw(Point2D a, Point2D b, Point2D c) {
    double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    if (area2 < 0)
      return -1;
    else if (area2 > 0)
      return +1;
    else
      return 0;
  }

  public static double distanceSquared(Point2D a, Point2D b) {
    double dx = (a.x - b.x);
    double dy = (a.y - b.y);

    return dx * dx + dy * dy;
  }

  public static double distance(Point2D a, Point2D b) {
    return Math.sqrt(distanceSquared(a, b));
  }

  public double distanceTo(Point2D other) {
    return distance(this, other);
  }

  public double x() {
    return x;
  }

  public double y() {
    return y;
  }

  /**
   * Returns the polar radius of this point.
   *
   * @return the polar radius of this point in polar coordiantes: sqrt(x*x + y*y)
   */
  public double r() {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Returns the angle of this point in polar coordinates.
   *
   * @return the angle (in radians) of this point in polar coordiantes (between –&pi; and &pi;)
   */
  public double theta() {
    return Math.atan2(y, x);
  }

  @Override
  public int compareTo(Point2D that) {
    if (this.y < that.y)
      return -1;
    if (this.y > that.y)
      return +1;
    if (this.x < that.x)
      return -1;
    if (this.x > that.x)
      return +1;
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (other == null) return false;
    if (other.getClass() != this.getClass()) return false;
    Point2D that = (Point2D) other;
    return this.x == that.x && this.y == that.y;
  }

  @Override
  public int hashCode() {
    int hashX = ((Double) x).hashCode();
    int hashY = ((Double) y).hashCode();
    return 31 * hashX + hashY;
  }

  @Override
  public String toString() {
    return "{" + x + "," + y + "}";
  }

  private double angleTo(Point2D that) {
    double dx = that.x - this.x;
    double dy = that.y - this.y;
    return Math.atan2(dy, dx);
  }

  public Comparator<Point2D> polarOrder() {
    return new PolarOrder();
  }

  private static class XOrder implements Comparator<Point2D> {
    @Override
    public int compare(Point2D p, Point2D q) {
      if (p.x < q.x)
        return -1;
      if (p.x > q.x)
        return +1;
      return 0;
    }
  }

  private static class YOrder implements Comparator<Point2D> {
    @Override
    public int compare(Point2D p, Point2D q) {
      if (p.y < q.y)
        return -1;
      if (p.y > q.y)
        return +1;
      return 0;
    }
  }

  private static class XYOrder implements Comparator<Point2D> {
    @Override
    public int compare(Point2D p, Point2D q) {
      if (p.x == q.x) {
        if (p.y < q.y)
          return -1;
        if (p.y > q.y)
          return +1;
      } else if (p.x < q.x) {
        return -1;
      } else if (p.x > q.x) {
        return +1;
      }
      return 0;
    }
  }

  private static class ROrder implements Comparator<Point2D> {
    @Override
    public int compare(Point2D p, Point2D q) {
      double delta = (p.x * p.x + p.y * p.y) - (q.x * q.x + q.y * q.y);
      if (delta < 0)
        return -1;
      if (delta > 0)
        return +1;
      return 0;
    }
  }

  private class PolarOrder implements Comparator<Point2D> {

    @Override
    public int compare(Point2D q1, Point2D q2) {
      double dx1 = q1.x - x;
      double dy1 = q1.y - y;
      double dx2 = q2.x - x;
      double dy2 = q2.y - y;

      if (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
      else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
      else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
        if (dx1 >= 0 && dx2 < 0) return -1;
        else if (dx2 >= 0 && dx1 < 0) return +1;
        else return 0;
      } else return -ccw(Point2D.this, q1, q2);     // both above or below

      // Note: ccw() recomputes dx1, dy1, dx2, and dy2

    }
  }
}
