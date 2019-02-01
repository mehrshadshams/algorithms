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
}
