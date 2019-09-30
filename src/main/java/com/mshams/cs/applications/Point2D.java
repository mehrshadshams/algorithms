package com.mshams.cs.applications;

import java.util.Comparator;

public class Point2D implements Comparable<Point2D> {
    public static final Comparator<Point2D> X_ORDER = new XOrder();
    public static final Comparator<Point2D> Y_ORDER = new YOrder();
    public static final Comparator<Point2D> X_Y_ORDER = new XYOrder();

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
    public String toString() {
        return "{" + x + "," + y + "}";
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
}
