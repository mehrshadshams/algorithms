package com.mshams.cs.algorithms.dp;

import com.mshams.cs.applications.Line;
import com.mshams.cs.applications.Point2D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * Algorithm Design, Jon Kleinberg and Eva Tardos
 * Ch. 6.3
 */
public class SegmentedLeastSquares {
    final double C = 2.0;

    public List<Line> findLeastSegments(List<Point2D> points) {
        final int n = points.size();

        double[] memo = new double[n];
        memo[0] = 0;

        double[][] errors = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                errors[i][j] = computeError(points, i, j);
            }
        }

        List<Integer> optSegments = new ArrayList<>();
        optSegments.add(0);

        for (int j = 1; j < n; j++) {
            int k = 0;
            double min = Double.POSITIVE_INFINITY;
            for (int i = 1; i < j; i++) {
                double tmp = errors[i][j] + memo[i - 1];
                if (tmp < min) {
                    min = tmp;
                    k = i;
                }
            }

            optSegments.add(k);
            memo[j] = min + C;
        }

        List<Line> segments = new LinkedList<>();

        for (int i = optSegments.size() - 1; i > 0; i--) {
            Point2D p1 = points.get(optSegments.get(i));
            Point2D p2 = points.get(optSegments.get(i - 1));

            segments.add(0, new Line(p1, p2));
        }

        return segments;
    }

    private double computeError(List<Point2D> points, int i, int j) {
        int n = (j - i) + 1;
        double xy = sum(points, i, j, p -> p.x() * p.y());
        double x = sum(points, i, j, Point2D::x);
        double y = sum(points, i, j, Point2D::y);
        double x2 = sum(points, i, j, p -> p.x() * p.x());

        final double a = (n * xy - x * y) / (n * x2 - x * x);
        final double b = (y - a * x) / n;

        return sum(points, i, j, p -> Math.pow(p.y() - a * p.x() - b, 2));
    }

    private double sum(List<Point2D> points, int i, int j, ToDoubleFunction<Point2D> func) {
        return points.subList(i, j).stream().mapToDouble(func).sum();
    }

    public class LineSegment {
        private final double a;
        private final double b;

        public LineSegment(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double a() {
            return a;
        }

        public double b() {
            return b;
        }
    }
}
