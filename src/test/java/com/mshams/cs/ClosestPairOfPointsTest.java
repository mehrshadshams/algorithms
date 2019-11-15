package com.mshams.cs;

import com.mshams.cs.applications.Point2D;
import com.mshams.cs.problems.ClosestPairOfPoints;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClosestPairOfPointsTest {
    @Test
    public void test1() {
        int[][] P = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
        Point2D[] points = new Point2D[P.length];
        for (int i = 0; i < P.length; i++) {
            points[i] = new Point2D(P[i][0], P[i][1]);
        }

        ClosestPairOfPoints closestPairOfPoints = new ClosestPairOfPoints(points);

        Point2D[] pair = closestPairOfPoints.getPoints();
        Point2D[] pair2 = ClosestPairOfPoints.closestPairBruteForce(points);

        Assertions.assertNotNull(pair);
        Assertions.assertEquals(2, pair.length);
        Assertions.assertEquals(new Point2D(2, 3), pair[0]);
        Assertions.assertEquals(new Point2D(3, 4), pair[1]);
    }
}
