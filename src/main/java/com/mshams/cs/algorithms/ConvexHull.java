package com.mshams.cs.algorithms;

import com.mshams.cs.applications.Point2D;
import org.apache.commons.lang3.NotImplementedException;

import java.util.*;

/**
 * Convex Hull (divide and conquer)
 * Complexity: O(n * log n)
 */
public class ConvexHull {
  public List<Point2D> grahamScan(List<Point2D> points) {
    GrahamScan gs = new GrahamScan(points);

    List<Point2D> hull = gs.hull();

    assert isConvex(hull);

    return hull;
  }

  public List<Point2D> divideAndConquer(List<Point2D> points) {
    Collections.sort(points);
    return divide(points);
  }

  private List<Point2D> divide(List<Point2D> points) {
    final int n = points.size();

    if (n <= 5) {
      return bruteHull(points);
    }

    double minX = points.get(0).x();
    double maxX = points.get(n - 1).x();
    double middleX = minX + (maxX - minX) / 2;

    List<Point2D> left = divideAndConquer(points.subList(0, n / 2));
    List<Point2D> right = divideAndConquer(points.subList(n / 2 + 1, n));

    return merge(left, right, middleX);
  }

  private List<Point2D> merge(List<Point2D> left, List<Point2D> right, double middleX) {
//        int i = left.size() - 1, j = 0;
//        int p = left.size(), q = right.size();
//        double lastY = Double.MIN_VALUE;
//        while (i >= 0 || j < right.size()) {
//            Point2D a = left.get(i);
//            Point2D b = right.get(j);
//
//            double m = (a.y() - b.y()) / (a.x() - b.x());
//            double bb = a.y() - m * a.x();
//
//            double y = m * middleX + bb;
//            if (y > lastY) {
//                lastY = y;
//                j = (j + 1) % q;
//            } else {
//                i = (i - 1) % q;
//            }
//        }

    throw new NotImplementedException("Incomplete");
  }

  private List<Point2D> bruteHull(List<Point2D> points) {
    List<Point2D> hull = new ArrayList<>();
    int n = points.size();
    int p = 1, q;
    do {
      hull.add(points.get(p));
      q = (p + 1) % n;
      for (int i = 0; i < n; i++) {
        if (Point2D.ccw(points.get(p), points.get(i), points.get(q)) > 0) {
          q = i;
        }
      }
      p = q;
    } while (p != 1);
    return hull;
  }

  private boolean isConvex(Collection<Point2D> hull) {
    final int n = hull.size();
    if (n <= 2) {
      return true;
    }

    Point2D[] points = hull.toArray(new Point2D[1]);

    for (int i = 0; i < n; i++) {
      if (Point2D.ccw(points[i], points[(i + 1) % n], points[(i + 2) % n]) < 0) {
        return false;
      }
    }

    return true;
  }

  private static class GrahamScan {
    private Stack<Point2D> hull = new Stack<>();

    public GrahamScan(List<Point2D> points) {
      Collections.sort(points);

      points.subList(1, points.size()).sort(points.get(0).polarOrder());

      hull.push(points.get(0));

      final int n = points.size();

      int k1;
      for (k1 = 1; k1 < n; k1++) {
        if (!points.get(0).equals(points.get(k1))) {
          break;
        }
      }

      if (k1 == n) {
        return;
      }

      int k2;
      for (k2 = k1 + 1; k2 < n; k2++) {
        if (Point2D.ccw(points.get(0), points.get(k1), points.get(k2)) != 0) {
          break;
        }
      }

      hull.push(points.get(k2 - 1));

      for (int i = k2; i < n; i++) {
        Point2D top = hull.pop();
        while (Point2D.ccw(hull.peek(), top, points.get(i)) < 0) {
          top = hull.pop();
        }
        hull.push(top);
        hull.push(points.get(i));
      }
    }

    public List<Point2D> hull() {
      return new ArrayList<>(this.hull);
    }
  }
}
