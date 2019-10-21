package com.mshams.cs.datastructures.searching;

public class Binary {
    public static int indexOf(Comparable[] values, Comparable x) {
        int k = rank(values, x);
        if (k < values.length && x.compareTo(values[k]) == 0) return k;
        return -1;
    }

    /**
     * Returns the index of largest key in this symbol table less than or equal to {@code key}.
     * @param values
     * @param x
     * @return
     */
    public static int floor(Comparable[] values, Comparable x) {
        int i = rank(values, x);
        if (i == values.length) return -1;
        if (i == 0) return -1;
        return i - 1;
    }

    /**
     * Returns the index of smallest key in this symbol table greater than or equal to x
     * @param values
     * @param x
     * @return
     */
    public static int ceiling(Comparable[] values, Comparable x) {
        int i = rank(values, x);
        if (i == values.length) return -1;
        return i;
    }

    public static int rank(Comparable[] values, Comparable x) {
        int lo = 0, hi = values.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = x.compareTo(values[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }

        return lo;
    }
}
