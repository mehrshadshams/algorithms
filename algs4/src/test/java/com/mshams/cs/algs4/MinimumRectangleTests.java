package com.mshams.cs.algs4;

import com.mshams.cs.algs4.problems.MinimumRectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumRectangleTests {
    @Test
    void test() {
        int[][] input = {{1,2},{2,1},{1,0},{0,1}};

        MinimumRectangle sol = new MinimumRectangle();
        double area = sol.minAreaFreeRect(input);

        Assertions.assertEquals(2.0, area);
    }
}
