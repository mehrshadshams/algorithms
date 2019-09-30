package com.mshams.cs;

import com.mshams.cs.problems.FindRotationPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindRotationPointTests {
    @Test
    void test_small_list() {
        int actual = FindRotationPoint.find(new String[]{"cape", "cake"});
        assertEquals(1, actual);
    }

    @Test
    void test_medium_list() {
        int actual = FindRotationPoint.find(new String[]{"grape", "orange", "plum",
                "radish", "apple"});
        assertEquals(4, actual);
    }

    @Test
    void test_large_list() {
        int actual = FindRotationPoint.find(new String[]{"ptolemaic", "retrograde", "supplant",
                "undulate", "xenoepist", "asymptote",
                "babka", "banoffee", "engender",
                "karpatka", "othellolagkage"});

        assertEquals(5, actual);
    }
}
