package com.mshams.cs.algs4.sorting;

import static com.mshams.cs.algs4.utils.StdArray.exch;
import static com.mshams.cs.algs4.utils.StdArray.less;

public class Selection {
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            exch(array, i, min);
        }
    }
}
