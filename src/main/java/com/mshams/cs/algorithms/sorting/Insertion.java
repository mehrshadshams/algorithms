package com.mshams.cs.algorithms.sorting;

import com.mshams.cs.utils.StdArray;

@SuppressWarnings("Duplicates")
public class Insertion {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (StdArray.less(array[j], array[j - 1])) {
                    StdArray.exch(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (StdArray.less(array[j], array[j - 1])) {
                    StdArray.exch(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
