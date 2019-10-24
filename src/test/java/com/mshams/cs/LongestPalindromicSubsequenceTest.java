package com.mshams.cs;

import com.mshams.cs.problems.LongestPalindromicSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPalindromicSubsequenceTest {
    @Test
    public void test1() {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence("ABBDCACB");

        Assertions.assertEquals(5, lps.length());
        Assertions.assertEquals("BCACB", lps.lps());
    }
}
