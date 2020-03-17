package com.mshams.cs;

import com.mshams.cs.problems.Decompression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
