package com.mshams.cs.algs4.applications;

public class Vector {
    private final double dx;
    private final double dy;

    public Vector(Point2D p0, Point2D p1) {
        dx = p1.x() - p0.x();
        dy = p1.y() - p0.y();
    }

    public double x() {
        return dx;
    }

    public double y() {
        return dy;
    }

    public double magnitudeSquared() {
        return dx * dx + dy * dy;
    }

    public static double dot(Vector v1, Vector v2) {
        return v1.dx * v2.dx + v1.dy * v2.dy;
    }
}
