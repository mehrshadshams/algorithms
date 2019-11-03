package com.mshams.cs;

import com.mshams.cs.problems.LongestIncreasingSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {
    private final static int[] NUMS = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

    @Test
    public void testTopBottom() {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        int lis = solution.findLisLength(NUMS);

        Assertions.assertEquals(6, lis);
    }
}
