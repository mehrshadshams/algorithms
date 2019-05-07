package com.mshams.cs.algs4.problems;

public class FindRotationPoint {
    public static int find(String[] words) {
        return find(words, 0, words.length - 1);
    }

    private static int find(String[] a, int lo, int hi) {
        if (hi - lo <= 1) {
            if (a[lo].compareTo(a[hi]) > 0) {
                return hi;
            }

            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        if (a[mid - 1].compareTo(a[mid]) < 0 && a[mid].compareTo(a[mid + 1]) < 0)
            return find(a, mid, hi);
        else if (a[mid - 1].compareTo(a[mid]) > 0 && a[mid].compareTo(a[mid + 1]) > 0)
            return find(a, lo, mid);
        else if (a[mid - 1].compareTo(a[mid]) < 0 && a[mid].compareTo(a[mid + 1]) > 0)
            return mid + 1;
        else
            return mid;
    }
}
