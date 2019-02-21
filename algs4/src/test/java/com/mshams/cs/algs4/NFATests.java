package com.mshams.cs.algs4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mshams.cs.algs4.strings.NFA;

public class NFATests {
    @Test
    void test_nfa_matches_string() {
        final String pattern = "((A*B|AC)D)";
        final String text = "AAAABD";

        final NFA nfa = new NFA(pattern);

        Assertions.assertTrue(nfa.matches(text));
    }

    @Test
    void test_nfa_does_not_match_string() {
        final String pattern = "((A*B|AC)D)";
        final String text = "AAAACD";

        final NFA nfa = new NFA(pattern);

        Assertions.assertFalse(nfa.matches(text));
    }
}
