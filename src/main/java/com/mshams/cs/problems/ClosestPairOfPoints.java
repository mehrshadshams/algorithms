package com.mshams.cs.problems;

import com.mshams.cs.applications.Point2D;

import java.util.Arrays;

public class ClosestPairOfPoints {
  private double bestDistance;
  private Point2D best1;
  private Point2D best2;

  public ClosestPairOfPoints(Point2D[] points) {
//        if (points.length < 1) {
//            return;
//        }
//
//        if (points.length == 2) {
//            best1 = points[0];
//            best2 = points[1];
//            return;
//        }
//
//        Point2D[] pointsByX = Arrays.copyOf(points, points.length);
//        Point2D[] pointsByY = Arrays.copyOf(points, points.length);
//
//        Arrays.sort(pointsByX, Point2D.X_ORDER);
//        Arrays.sort(pointsByY, Point2D.Y_ORDER);
//
//        Point2D[] aux = new Point2D[points.length];
//
//        closest(pointsByX, pointsByY, aux, 0, points.length - 1);

    if (points == null) throw new IllegalArgumentException("constructor argument is null");
    for (int i = 0; i < points.length; i++) {
      if (points[i] == null) throw new IllegalArgumentException("array element " + i + " is null");
    }

    int n = points.length;
    if (n <= 1) return;

    // sort by x-coordinate (breaking ties by y-coordinate)
    Point2D[] pointsByX = new Point2D[n];
    for (int i = 0; i < n; i++)
      pointsByX[i] = points[i];
    Arrays.sort(pointsByX, Point2D.X_ORDER);

    // check for coincident points
    for (int i = 0; i < n - 1; i++) {
      if (pointsByX[i].equals(pointsByX[i + 1])) {
        bestDistance = 0.0;
        best1 = pointsByX[i];
        best2 = pointsByX[i + 1];
        return;
      }
    }

    // sort by y-coordinate (but not yet sorted)
    Point2D[] pointsByY = new Point2D[n];
    for (int i = 0; i < n; i++)
      pointsByY[i] = pointsByX[i];

    // auxiliary array
    Point2D[] aux = new Point2D[n];

    closest(pointsByX, pointsByY, aux, 0, n - 1);
  }

  public static Point2D[] closestPairBruteForce(Point2D[] points) {
    return closestPairBruteForce(points, 0, points.length);
  }

  private static Point2D[] closestPairBruteForce(Point2D[] points, int m, int n) {
    Point2D[] out = null;
    double dist = Double.MAX_VALUE;
    for (int i = m; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        double d = Point2D.distanceSquared(points[i], points[j]);
        if (d < dist) {
          dist = d;
          out = new Point2D[]{points[i], points[j]};
        }
      }
    }

    return out;
  }

  private static void merge(Point2D[] a, Point2D[] aux, int lo, int mid, int hi) {
    // copy to aux[]
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    // merge back to a[]
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) a[k] = aux[j++];
      else if (j > hi) a[k] = aux[i++];
      else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
      else a[k] = aux[i++];
    }
  }

  private static Point2D[] closestPair(Point2D[] pointsX, Point2D[] pointsY, Point2D[] aux, int lo, int hi) {
    if (hi - lo <= 3) {
      Point2D[] p1 = closestPairBruteForce(pointsX, lo, hi);
      Point2D[] p2 = closestPairBruteForce(pointsY, lo, hi);
      double dist1 = Point2D.distanceSquared(p1[0], p1[0]);
      double dist2 = Point2D.distanceSquared(p2[0], p2[1]);
      return (dist1 < dist2 ? p1 : p2);
    }

    int mid = lo + (hi - lo) / 2;

    Point2D median = pointsX[mid];
    Point2D[] a = closestPair(pointsX, pointsY, aux, lo, mid);
    Point2D[] b = closestPair(pointsX, pointsY, aux, mid + 1, hi);

    double dl = a != null ? Point2D.distanceSquared(a[0], a[1]) : Double.MAX_VALUE;
    double dr = b != null ? Point2D.distanceSquared(b[0], b[1]) : Double.MAX_VALUE;

    double deltaSquared = Math.min(dl, dr);


//        Point2D midPoint = points[mid];
//
//        List<Point2D> strip = new LinkedList<>();
//        for (Point2D p : points) {
//            if (Math.abs(p.x() - midPoint.x()) < delta) {
//                strip.add(p);
//            }
//        }
//
//        strip.sort(Point2D.Y_ORDER);
//
//        Point2D[] temp = null;
//        double dist = Double.MAX_VALUE;
//        for (int i = 0; i < strip.size(); i++) {
//            for (int j = i + 1; j < strip.size() && (strip.get(j).y() - strip.get(i).y()) < delta; j++) {
//                double d = Point2D.distanceSquared(strip.get(i), strip.get(j));
//                if (d < dist) {
//                    temp = new Point2D[]{strip.get(i), strip.get(j)};
//                    dist = d;
//                }
//            }
//        }
//
//        if (dist < delta) {
//            return temp;
//        }
//
//        if (dl < dr) {
//            return a;
//        }

    return b;
  }

    /*private double closest(Point2D[] pointsX, Point2D[] pointsY, Point2D[] aux, int lo, int hi) {
        if (hi <= lo) return Double.POSITIVE_INFINITY;
        int mid = lo + (hi - lo) / 2;
        Point2D median = pointsX[mid];

        double delta1 = closest(pointsX, pointsY, aux, lo, mid);
        double delta2 = closest(pointsX, pointsY, aux, mid + 1, hi);

        double delta = Double.min(delta1, delta2);

        merge(pointsY, aux, lo, mid, hi);

        int m = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pointsY[i].x() - median.x()) < delta) {
                aux[m++] = pointsY[i];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m && (aux[j].y() - aux[i].y() < delta); j++) {
                double distance = aux[i].distanceTo(aux[j]);
                if (distance < delta) {
                    bestDistance = delta;
                    best1 = aux[i];
                    best2 = aux[j];
                }
            }
        }

        return delta;
    }*/

  public Point2D[] getPoints() {
    return new Point2D[]{best1, best2};
  }

  public double distance() {
    return bestDistance;
  }

  private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int lo, int hi) {
    if (hi <= lo) return Double.POSITIVE_INFINITY;

    int mid = lo + (hi - lo) / 2;
    Point2D median = pointsByX[mid];

    // compute closest pair with both endpoints in left subarray or both in right subarray
    double delta1 = closest(pointsByX, pointsByY, aux, lo, mid);
    double delta2 = closest(pointsByX, pointsByY, aux, mid + 1, hi);
    double delta = Math.min(delta1, delta2);

    // merge back so that pointsByY[lo..hi] are sorted by y-coordinate
    merge(pointsByY, aux, lo, mid, hi);

    // aux[0..m-1] = sequence of points closer than delta, sorted by y-coordinate
    int m = 0;
    for (int i = lo; i <= hi; i++) {
      if (Math.abs(pointsByY[i].x() - median.x()) < delta)
        aux[m++] = pointsByY[i];
    }

    // compare each point to its neighbors with y-coordinate closer than delta
    for (int i = 0; i < m; i++) {
      // a geometric packing argument shows that this loop iterates at most 7 times
      for (int j = i + 1; (j < m) && (aux[j].y() - aux[i].y() < delta); j++) {
        double distance = aux[i].distanceTo(aux[j]);
        if (distance < delta) {
          delta = distance;
          if (distance < bestDistance) {
            bestDistance = delta;
            best1 = aux[i];
            best2 = aux[j];
            // StdOut.println("better distance = " + delta + " from " + best1 + " to " + best2);
          }
        }
      }
    }
    return delta;
  }
}
