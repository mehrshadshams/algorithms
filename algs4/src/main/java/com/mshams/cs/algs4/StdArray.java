package com.mshams.cs.algs4;

public class StdArray {
    public static int[] range(int start, int end) {
        if (start < 0 || end < 0 || end < start)
            throw new IllegalArgumentException();
        int[] array = new int[end - start];
        for (int i = start, j = 0; i < end; i++, j++) {
            array[j] = i;
        }
        return array;
    }

    public static boolean less(Comparable v, Comparable w) {
        //noinspection unchecked
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean isSorted(Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }

    public static boolean isSorted(Comparable[] array, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSorted(int[] array) {
        return isSorted(array, 0, array.length - 1);
    }

    public static boolean isSorted(int[] array, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
