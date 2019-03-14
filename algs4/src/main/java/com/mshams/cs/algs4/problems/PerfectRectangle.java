package com.mshams.cs.algs4.problems;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/perfect-rectangle/
 */
public class PerfectRectangle {
    public static boolean isRectangleCover(int[][] rectangles) {
        PriorityQueue<Rectangle> pq = new PriorityQueue<>();
        for (int i=0; i<rectangles.length; i++) {
            int[] r = rectangles[i];
            pq.offer(new Rectangle(r[0], r[1], r[2], r[3]));
        }

        Rectangle last = null;
        while (!pq.isEmpty()) {
            Rectangle r = pq.poll();
            if (last != null) {
                if (r.intersects(last)) {
                    return false;
                }

                if (Math.abs(r.left - last.right) > 0 && Math.abs(r.bottom - last.top) > 0) {
                    return false;
                }
            }
            last = r;
        }

        return true;
    }
    private static class Rectangle implements Comparable<Rectangle> {
        int left;
        int bottom;
        int top;
        int right;

        Rectangle(int left, int bottom, int right, int top) {
            this.left = left;
            this.bottom = bottom;
            this.top = top;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + left + ", " + bottom + ", " + top + ", " + right + ']';
        }

        boolean intersects(Rectangle r) {
            if ((left >= r.left && left < r.right) || (right >= r.left && right < r.right)) {
                if ((bottom >= r.bottom && bottom < r.top) || (top >= r.bottom && top < r.top)) {
                    return true;
                }
            }
            return false;
        }

        public int compareTo(Rectangle r) {
            if (left == r.left && right == r.right && bottom == r.bottom && top == r.top) {
                return 0;
            }

            if (left < r.left) {
                return -1;
            } else if (left > r.left) {
                return 1;
            } else {
                if (bottom < r.bottom) {
                    return -1;
                } else if (bottom > r.bottom) {
                    return 1;
                } else {
                    if (right < r.right) {
                        return -1;
                    } else if (right > r.right) {
                        return 1;
                    } else {
                        if (top < r.top) {
                            return -1;
                        }
                    }
                }
            }

            return 1;
        }
    }
}
