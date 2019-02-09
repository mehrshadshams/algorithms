package com.mshams.cs.algs4;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortTests {

    @Test
    void test_insertion_sort() {
        int[] array = StdArray.range(1, 10);
        StdRandom.shuffle(array);

        final Integer[] output = Arrays.stream(array).boxed().toArray(Integer[]::new);

        Insertion.sort(output);

        Assertions.assertTrue(StdArray.isSorted(output));
    }

    @Test
    void test_selection_sort() {
        int[] array = StdArray.range(1, 10);
        StdRandom.shuffle(array);

        final Integer[] output = Arrays.stream(array).boxed().toArray(Integer[]::new);

        Selection.sort(output);

        Assertions.assertTrue(StdArray.isSorted(output));
    }

    @Test
    void test_merge_sort() {
        int[] array = StdArray.range(1, 1000);
        StdRandom.shuffle(array);

        final Integer[] output = Arrays.stream(array).boxed().toArray(Integer[]::new);

        Merge.sort(output);

        Assertions.assertTrue(StdArray.isSorted(output));
    }

    @Test
    void test_merge_bu_sort() {
        int[] array = StdArray.range(1, 1000);
        StdRandom.shuffle(array);

        final Integer[] output = Arrays.stream(array).boxed().toArray(Integer[]::new);

        MergeBU.sort(output);

        Assertions.assertTrue(StdArray.isSorted(output));
    }

    @Test
    void test_quick_sort() {
        int[] array = StdArray.range(1, 1000);
        StdRandom.shuffle(array);

        Quick.sort(array);

        Assertions.assertTrue(StdArray.isSorted(array));
    }

    @Test
    void test_quick_3_way_sort() {
        final char[] chars = "PABXWPPVPDPCYZ".toCharArray();
        final Character[] array = new Character[chars.length];
        for (int i = 0; i < chars.length; i++)
            array[i] = chars[i];

        Quick3way.sort(array);

        Assertions.assertTrue(StdArray.isSorted(array));
    }
}