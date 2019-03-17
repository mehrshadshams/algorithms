package com.mshams.cs.algs4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mshams.cs.algs4.problems.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {
    private static final String WORD1 = "ABCDGH";
    private static final String WORD2 = "AEDFHR";

    @Test
    void test_non_recursive() {
        int lcs = LongestCommonSubsequence.lcs(WORD1, WORD2);

        Assertions.assertEquals(3, lcs);
    }

    @Test
    void test_recursive() {
        int lcs = LongestCommonSubsequence.lcsRecursive(WORD1, WORD2);

        Assertions.assertEquals(3, lcs);
    }
}