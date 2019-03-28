package com.mshams.cs.algs4.problems;

import com.mshams.cs.algs4.applications.Point2D;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class MinimumRectangle {
    public double minAreaFreeRect(int[][] points) {
        List<Point2D> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list.add(new Point2D(points[i][0], points[i][1]));
        }

        Collections.sort(list);

        throw new NotImplementedException();
    }


}