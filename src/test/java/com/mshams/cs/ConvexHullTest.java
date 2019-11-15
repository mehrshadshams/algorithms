package com.mshams.cs;

import com.mshams.cs.algorithms.ConvexHull;
import com.mshams.cs.applications.Point2D;
import com.mshams.cs.helpers.FileHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvexHullTest {
    @Test
    public void testGrahamScanTrivial() {
        List<Point2D> points = createTrivialPoints();

        ConvexHull ch = new ConvexHull();

        List<Point2D> hull = ch.grahamScan(points);

        Assertions.assertFalse(hull.isEmpty());

        Assertions.assertEquals(4, hull.size());
        Assertions.assertEquals(new Point2D(0, 0), hull.get(0));
        Assertions.assertEquals(new Point2D(2, 0), hull.get(1));
        Assertions.assertEquals(new Point2D(2, 2), hull.get(2));
        Assertions.assertEquals(new Point2D(0, 2), hull.get(3));
    }

    @Test
    public void testDivideAndConquerTrivial() {
        List<Point2D> points = createTrivialPoints();

        ConvexHull ch = new ConvexHull();

        List<Point2D> hull = ch.divideAndConquer(points);

        Collections.sort(hull);

        Assertions.assertFalse(hull.isEmpty());

        Assertions.assertEquals(4, hull.size());
    }

    @Test
    public void testFileGrahamScan() {
        List<Point2D> points = readPoints();

        ConvexHull ch = new ConvexHull();

        List<Point2D> hull = ch.grahamScan(points);

        Assertions.assertFalse(hull.isEmpty());
    }

    private List<Point2D> createTrivialPoints() {
        List<Point2D> points = Arrays.asList(
                new Point2D(0, 0),
                new Point2D(2, 0),
                new Point2D(2, 2),
                new Point2D(0, 2),
                new Point2D(1, 1)
        );

        Collections.shuffle(points);
        return points;
    }

    private List<Point2D> readPoints() {
        String content = FileHelpers.asString("problems/convexHull1.txt");
        String[] lines = content.split(System.lineSeparator());
        int n = Integer.parseInt(lines[0]);
        List<Point2D> points = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+");
            points.add(new Point2D(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        return points;
    }
}
