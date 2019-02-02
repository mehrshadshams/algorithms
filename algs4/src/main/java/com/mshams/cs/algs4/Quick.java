package com.mshams.cs.algs4;

public class Quick {
    public static void sort(int[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (hi <= lo)
            return;

        int k = partition(array, lo, hi);
        sort(array, lo, k - 1);
        sort(array, k + 1, hi);
    }

    private static int partition(int[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (array[++i] < array[lo])
                if (i == hi)
                    break;

            while (array[lo] < array[--j])
                if (j == lo)
                    break;

            if (i >= j)
                break;

            StdArray.exch(array, i, j);
        }

        StdArray.exch(array, lo, j);

        return j;
    }
}
