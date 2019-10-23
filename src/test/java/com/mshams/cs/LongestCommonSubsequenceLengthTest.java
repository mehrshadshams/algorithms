package com.mshams.cs;

import com.mshams.cs.problems.LongestCommonSubsequenceLength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceLengthTest {
    private static final String WORD1 = "ABCDGH";
    private static final String WORD2 = "AEDFHR";

    @Test
    void test_non_recursive() {
        int lcs = LongestCommonSubsequenceLength.lcs(WORD1, WORD2);

        Assertions.assertEquals(3, lcs);
    }

    @Test
    void test_recursive() {
        int lcs = LongestCommonSubsequenceLength.lcsRecursive(WORD1, WORD2);

        Assertions.assertEquals(3, lcs);
    }
}
