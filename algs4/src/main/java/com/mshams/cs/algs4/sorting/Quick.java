package com.mshams.cs.algs4.sorting;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.mshams.cs.algs4.utils.StdRandom;

public class Quick {
    public static int[] sort(int[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1, false);
        return array;
    }

    public static int[] randomizedSort(int[] array) {
        sort(array, 0, array.length - 1, true);
        return array;
    }

    private static void sort(int[] array, int p, int r, boolean randomized) {
        if (p < r) {
            int q = randomized ? randomizedPartition(array, p, r) : partition(array, p, r);
            sort(array, p, q - 1, randomized);
            sort(array, q + 1, r, randomized);
        }
    }

    private static int randomizedPartition(int[] array, int p, int r) {
        int i = p + new Random().nextInt(r - p);
        ArrayUtils.swap(array, i, r);
        return partition(array, p, r);
    }

    private static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r - 1; j++) {
            if (array[j] <= x) {
                i++;
                ArrayUtils.swap(array, i, j);
            }
        }
        ArrayUtils.swap(array, i + 1, r);
        return i + 1;
    }
}
