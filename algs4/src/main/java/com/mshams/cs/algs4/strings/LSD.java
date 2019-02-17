package com.mshams.cs.algs4.strings;

public class LSD {
    public static void sort(String[] a, int maxLength) {
        final int n = a.length;
        final int R = 256;
        String[] aux = new String[n];

        for (int w = maxLength - 1; w >= 0; w--) {
            int[] count = new int[R + 1];
            for (String s : a) {
                count[s.charAt(w) + 1] += 1;
            }

            for (int i = 0; i < R; i++) {
                count[i + 1] += count[i];
            }

            for (String s : a) {
                aux[count[s.charAt(w)]++] = s;
            }

            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }
}
