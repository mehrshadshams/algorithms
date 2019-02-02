package com.mshams.cs.algs4;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSelectTests {

    Integer[] numbers;

    @BeforeEach
    void setup() {
        int[] array = StdArray.range(1, 10);
        StdRandom.shuffle(array);
        numbers = Arrays.stream(array).boxed().toArray(Integer[]::new);
    }

    @Test
    void test_quick_select_returns_min() {
        int min = (int) QuickSelect.select(numbers, 0);

        Assertions.assertEquals(1, min);
    }

    @Test
    void test_quick_select_returns_max() {
        int max = (int) QuickSelect.select(numbers, numbers.length - 1);

        Assertions.assertEquals(9, max);
    }

    @Test
    void test_quick_select_returns_kth() {
        int kth = (int) QuickSelect.select(numbers, 3 - 1);

        Assertions.assertEquals(3, kth);
    }

    @Test
    void test_quick_select_returns_median() {
        int median = (int) QuickSelect.select(numbers, numbers.length / 2);

        Assertions.assertEquals(5, median);
    }
}
