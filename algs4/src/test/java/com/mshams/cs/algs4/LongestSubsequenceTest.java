package com.mshams.cs.algs4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mshams.cs.algs4.problems.LongestSubsequence;

public class LongestSubsequenceTest {
    @Test
    void test() {
        String s = "abppplee";
        String[] dict = {"able", "ale", "apple", "bale", "kangaroo"};

        String lcs = LongestSubsequence.find(s, dict);

        Assertions.assertEquals("apple", lcs);
    }
}
