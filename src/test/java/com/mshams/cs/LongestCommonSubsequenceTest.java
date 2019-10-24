package com.mshams.cs;

import com.google.common.collect.Sets;
import com.mshams.cs.problems.LongestCommonSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

public class LongestCommonSubsequenceTest {
    private static final String WORD1 = "ABCBDAB";
    private static final String WORD2 = "BDCABA";

    @Test
    public void test1() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        Collection<String> result = lcs.findLCS(WORD1, WORD2);

        Assertions.assertEquals(Sets.newHashSet("BDAB", "BCAB", "BCBA"), new HashSet<>(result));
    }
}
