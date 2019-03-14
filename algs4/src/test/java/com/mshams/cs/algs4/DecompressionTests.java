package com.mshams.cs.algs4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mshams.cs.algs4.problems.Decompression;

public class DecompressionTests {
    @Test
    void test1() {
        final String decompress = Decompression.decompress("3[abc]4[ab]c");

        Assertions.assertEquals("abcabcabcababababc", decompress);
    }

    @Test
    void test2() {
        final String decompress = Decompression.decompress("2[3[a]b]");

        Assertions.assertEquals("aaabaaab", decompress);
    }
}
