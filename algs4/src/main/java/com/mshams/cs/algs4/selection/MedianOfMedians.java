package com.mshams.cs.algs4.selection;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.mshams.cs.algs4.sorting.Insertion;

public class MedianOfMedians {
    public static int kthSmallest(int[] array, int k) {
        return kthSmallest(array, 0, array.length - 1, k);
    }

    private static int kthSmallest(int[] array, int lo, int hi, int k) {
        if (k > 0 && k <= hi - lo + 1) {
            List<int[]> sublists = new ArrayList<>();
            for (int i = lo; i <= hi; i += 5) {
                int[] sublist = new int[Math.min(5, hi + 1 - i)];
                for (int j = 0; j < sublist.length; j++) {
                    sublist[j] = array[i + j];
                }
                sublists.add(sublist);
            }

            int[] medians = new int[sublists.size()];
            for (int i = 0; i < sublists.size(); i++) {
                int[] sublist = sublists.get(i);
                Insertion.sort(sublist);
                medians[i] = median(sublist);
            }

            int pivot;
            if (medians.length <= 5) {
                Insertion.sort(medians);
                pivot = median(medians);
            } else {
                pivot = kthSmallest(medians, medians.length / 2);
            }

            int q = partition(array, lo, hi, pivot);
            if (q - lo == k - 1) {
                return array[q];
            }

            if (q - lo > k - 1) {
                return kthSmallest(array, lo, q - 1, k);
            }

            return kthSmallest(array, q + 1, hi, k - q + lo + 1);
        }

        return -1;
    }

    private static int median(int[] array) {
        if (array.length % 2 == 0)
            return array[(array.length - 1) / 2];
        return array[array.length / 2];
    }

    @SuppressWarnings("Duplicates")
    private static int partition(int[] array, int lo, int hi, int pivot) {
        for (int i = lo; i <= hi; i++) {
            if (array[i] == pivot) {
                ArrayUtils.swap(array, i, hi);
                break;
            }
        }

        int i = lo - 1;
        for (int j = lo; j <= hi - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                ArrayUtils.swap(array, i, j);
            }
        }
        ArrayUtils.swap(array, i + 1, hi);

        return i + 1;
    }
}
