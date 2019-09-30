package com.mshams.cs.algorithms.strings;

import com.mshams.cs.utils.StdArray;
import com.mshams.cs.utils.StdRandom;

public class Quick3string {
    public static void sort(String[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1, 0);
    }

    private static void sort(String[] array, int lo, int hi, int d) {
        if (hi <= lo) return;

        int lt = lo, gt = hi;
        int v = charAt(array[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(array[i], d);
            if (t < v) StdArray.exch(array, lt++, i++);
            else if (t > v) StdArray.exch(array, i, gt--);
            else i++;
        }

        sort(array, lo, lt - 1, d);
        if (v >= 0) sort(array, lt, gt, d + 1);
        sort(array, gt + 1, hi, d);
    }

    // return the dth character of s, -1 if d = length of s
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }
}
