package com.mshams.cs.algorithms.strings;

public class RabinCarp {
    private static final int R = 256;
    private static final int Q = 997;

    private final String pattern;
    private final long patternHash;
    private final int RM;

    public RabinCarp(String pat) {
        this.pattern = pat;
        patternHash = hash(pattern, pat.length());

        int rm = 1;
        for (int i = 1; i <= pat.length() - 1; i++) {
            rm = (R * rm) % Q;
        }
        this.RM = rm;
    }

    public int search(String text) {
        if (text == null)
            throw new IllegalArgumentException();
        if (text.length() <= pattern.length())
            return text.equals(pattern) ? 0 : -1;

        int n = text.length();
        int m = pattern.length();

        long txtHash = hash(text, m);
        if (txtHash == patternHash)
            return 0;

        for (int i = m; i <= n - m; i++) {
            txtHash = (txtHash + Q - RM * text.charAt(i - m) % Q) % Q;
            txtHash = (txtHash * R + text.charAt(i)) % Q;

            // MONTE CARLO
            if (patternHash == txtHash) {
                //VEGAS
                boolean equals = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        equals = false;
                    }
                }

                if (equals) {
                    return i;
                }
            }
        }

        return -1;
    }

    private long hash(String key, int m) {
        long h = 0;
        for (int i = 0; i < m; i++) {
            h = (R * h + key.charAt(i)) % Q;
        }
        return h;
    }
}
