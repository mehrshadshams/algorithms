package com.mshams.cs.problems;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Bitonic Sequence
 * Complexity: Time O(n^2) Space O(n^2)
 */
public class LongestBitonicSequence {
    public int[] lbs(int[] array) {
        int n = array.length;

        List<Integer>[] I = new List[n];
        for (int i = 0; i < n; i++) {
            I[i] = new ArrayList<>();
        }

        I[0].add(array[0]);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (I[i].size() < I[j].size() && array[i] > array[j]) {
                    I[i] = new ArrayList<>(I[j]);
                }
            }
            I[i].add(array[i]);
        }

        List<Integer>[] D = new List[n];
        for (int i = 0; i < n; i++) {
            D[i] = new ArrayList<>();
        }

        D[n - 1].add(array[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (D[i].size() < D[j].size() && array[i] > array[j]) {
                    D[i] = new ArrayList<>(D[j]);
                }
            }
            D[i].add(0, array[i]);
        }

        int peakIndex = 0;
        for (int i = 0; i < n; i++) {
            if (I[i].size() + D[i].size() > I[peakIndex].size() + D[peakIndex].size()) {
                peakIndex = i;
            }
        }

        List<Integer> lbs = new ArrayList<>(I[peakIndex]);
        lbs.addAll(D[peakIndex].subList(1, D[peakIndex].size()));

        return Ints.toArray(lbs);
    }
}
