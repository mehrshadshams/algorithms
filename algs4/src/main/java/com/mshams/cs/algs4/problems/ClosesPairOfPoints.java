package com.mshams.cs.algs4.problems;

import com.mshams.cs.algs4.applications.Point2D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClosesPairOfPoints {
    public static Point2D[] find(Point2D[] points) {
        Arrays.sort(points, Point2D.X_ORDER);

        return closestPair(points, 0, points.length - 1);
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

    private static Point2D[] closestPair(Point2D[] points, int lo, int hi) {
        if (hi - lo <= 3) {
            return closestPairBruteForce(points, lo, hi);
        }

        int mid = lo + (hi - lo) / 2;

        Point2D[] a = closestPair(points, lo, mid);
        Point2D[] b = closestPair(points, mid + 1, hi);
        double dl = a != null ? Point2D.distanceSquared(a[0], a[1]) : Double.MAX_VALUE;
        double dr = b != null ? Point2D.distanceSquared(b[0], b[1]) : Double.MAX_VALUE;

        double deltaSquared = Math.min(dl, dr);
        double delta = Math.sqrt(deltaSquared);

        Point2D midPoint = points[mid];

        List<Point2D> strip = new LinkedList<>();
        for (Point2D p : points) {
            if (Math.abs(p.x() - midPoint.x()) < delta) {
                strip.add(p);
            }
        }

        strip.sort(Point2D.Y_ORDER);

        Point2D[] temp = null;
        double dist = Double.MAX_VALUE;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y() - strip.get(i).y()) < delta; j++) {
                double d = Point2D.distanceSquared(strip.get(i), strip.get(j));
                if (d < dist) {
                    temp = new Point2D[]{strip.get(i), strip.get(j)};
                    dist = d;
                }
            }
        }

        if (dist < delta) {
            return temp;
        }

        if (dl < dr) {
            return a;
        }

        return b;
    }

    public static void main(String[] args) {
        int[][] P = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
        Point2D[] points = new Point2D[P.length];
        for (int i = 0; i < P.length; i++) {
            points[i] = new Point2D(P[i][0], P[i][1]);
        }

        Point2D[] pair = find(points);

        System.out.println(pair[0]);
        System.out.println(pair[1]);
        System.out.println(Point2D.distance(pair[0], pair[1]));
    }
}
