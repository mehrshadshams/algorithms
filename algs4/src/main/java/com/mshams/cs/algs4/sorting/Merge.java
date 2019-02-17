package com.mshams.cs.algs4.sorting;

import static com.mshams.cs.algs4.collections.StdArray.isSorted;
import static com.mshams.cs.algs4.collections.StdArray.less;

public class Merge {
    public static Comparable[] sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        Merge.sort(array, aux, 0, array.length - 1);
        return aux;
    }

    private static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;

        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);

        merge(array, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                array[k] = aux[j++];
            else if (j > hi)
                array[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                array[k] = aux[j++];
            else
                array[k] = aux[i++];
        }
    }
}
