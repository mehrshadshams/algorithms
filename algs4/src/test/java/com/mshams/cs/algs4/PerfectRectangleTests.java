package com.mshams.cs.algs4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.mshams.cs.algs4.problems.PerfectRectangle;

public class PerfectRectangleTests {
    @Test
    void test_basic() {
        int[][] rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};

        final boolean rectangleCover = PerfectRectangle.isRectangleCover(rectangles);

        Assertions.assertTrue(rectangleCover);
    }

    @Test
    void test_non_perfect() {
        int[][] rectangles = new int[][]{{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}};

        final boolean cover = PerfectRectangle.isRectangleCover(rectangles);

        Assertions.assertFalse(cover);
    }

    @Test
    void test_non_perfect_2() {
        int[][] rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}};

        final boolean cover = PerfectRectangle.isRectangleCover(rectangles);

        Assertions.assertFalse(cover);
    }

    @Test
    void test_non_perfect_3() {
        int[][] rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}};

        final boolean cover = PerfectRectangle.isRectangleCover(rectangles);

        Assertions.assertFalse(cover);
    }
    
    @Test @Disabled
    void test() {
        int[][] rectangles = new int[][]{{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}};

        final boolean cover = PerfectRectangle.isRectangleCover(rectangles);

        Assertions.assertTrue(cover);
    }
}
