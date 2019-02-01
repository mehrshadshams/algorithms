package com.mshams.cs.algs4;

import java.util.Arrays;

public class Selection extends SortBase {
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[i])) {
                    min = j;
                }
            }
            exch(array, i, min);
        }
    }
}
