package com.mshams.cs.algs4.sorting;

import static com.mshams.cs.algs4.collections.StdArray.exch;
import static com.mshams.cs.algs4.collections.StdArray.less;

public class Insertion {
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) {
                    exch(array, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}