package com.mshams.cs.algs4;

import static com.mshams.cs.algs4.StdArray.exch;

public class Quick3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
