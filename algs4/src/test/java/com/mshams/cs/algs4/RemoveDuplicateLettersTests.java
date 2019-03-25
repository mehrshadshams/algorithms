package com.mshams.cs.algs4;

import com.mshams.cs.algs4.problems.RemoveDuplicateLetters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveDuplicateLettersTests {
    @Test
    void test_1() {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        
        String output = solution.removeDuplicateLetters("cbabc");

        Assertions.assertEquals("abc", output);
    }

    @Test
    void test_2() {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

        String output = solution.removeDuplicateLetters("cbacdcbc");

        Assertions.assertEquals("acdb", output);
    }

    @Test
    void test_3() {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

        String output = solution.removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic");

        Assertions.assertEquals("ilrhjfyzmnstwkboxuc", output);
    }
}