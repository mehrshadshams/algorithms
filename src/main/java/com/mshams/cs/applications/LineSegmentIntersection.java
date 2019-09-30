package com.mshams.cs.applications;

import com.mshams.cs.datastructures.searching.RedBlackBST;
import com.mshams.cs.datastructures.searching.ST;

import java.util.List;
import java.util.PriorityQueue;

public class LineSegmentIntersection {
    public LineSegmentIntersection(List<Line> lines) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (Line line : lines) {
            pq.add(new Point(line.getStart(), true));
            pq.add(new Point(line.getEnd(), false));
        }

        ST<Integer, Line> st = new RedBlackBST<>();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.start) {
                // st.put(p.point.y(), );
            }
        }
    }

    private class Point implements Comparable<Point> {
        private final Point2D point;
        private final boolean start;

        public Point(Point2D point, boolean start) {
            this.point = point;
            this.start = start;
        }

        @Override
        public int compareTo(Point other) {
            return Point2D.X_ORDER.compare(point, other.point);
        }
    }
}
