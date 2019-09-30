package com.mshams.cs.problems;

import com.mshams.cs.applications.Point2D;

import java.util.ArrayList;
import java.util.List;

public class MinimumRectangle {
    private static boolean isRectangle(List<Point2D> points) {
        return Point2D.distanceSquared(points.get(0), points.get(2)) ==
                Point2D.distanceSquared(points.get(1), points.get(3));
    }

    public double minAreaFreeRect(int[][] points) {
        if (points.length < 4) {
            return 0;
        }

        List<Point2D> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list.add(new Point2D(points[i][0], points[i][1]));
        }

        list.sort(Point2D.X_Y_ORDER);

        double minArea = Double.MAX_VALUE;
        boolean hasRect = false;

        for (int i = 0; i <= points.length - 4; i++) {
            List<Point2D> temp = list.subList(i, i + 4);

//            Vector v1 = new Vector(temp.get(0), temp.get(1));
//            Vector v2 = new Vector(temp.get(1), temp.get(3));
//            Vector v3 = new Vector(temp.get(0), temp.get(2));
//            Vector v4 = new Vector(temp.get(2), temp.get(3));
//
//            boolean isRect = Vector.dot(v1, v2) == 0 && Vector.dot(v3, v4) == 0;

            boolean isRect = isRectangle(temp);

            if (isRect) {
                //double area = v1.magnitude() * v2.magnitude();
                double area = Point2D.distance(temp.get(0), temp.get(1)) * Point2D.distance(temp.get(0), temp.get(3));
                minArea = Math.min(minArea, area);
                hasRect = true;
            }
        }

        return hasRect ? minArea : 0;
    }

}