package com.mshams.cs.algs4.strings;

public class BooyerMore {
    private static final int R = 256;

    private final int[] right;
    private final String pattern;

    public BooyerMore(String pat) {
        this.pattern = pat;
        right = new int[R];
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < pat.length(); i++) {
            right[pat.charAt(i)] = i;
        }
    }

    public int search(String text) {
        int n = text.length();
        int m = pattern.length();

        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            if (text.charAt(i) == pattern.charAt(0)) {
                for (int j = m - 1; j >= 0; j--) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        skip = Math.max(1, j - right[text.charAt(i + j)]);
                        break;
                    }
                }
                if (skip == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
