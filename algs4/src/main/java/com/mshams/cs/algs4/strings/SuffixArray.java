package com.mshams.cs.algs4.strings;

import java.util.Arrays;

public class SuffixArray {
    private Suffix[] suffixes;

    public SuffixArray(String text) {
        int n = text.length();
        suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(text, i);
        }
        Arrays.sort(suffixes);
    }

    public int length() {
        return suffixes.length;
    }

    public int lcp(int i) {
        if (i < 1 || i >= suffixes.length)
            throw new IllegalArgumentException();
        return lcpSuffix(suffixes[i], suffixes[i - 1]);
    }

    public int index(int i) {
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
        return suffixes[i].index;
    }

    private static int lcpSuffix(Suffix s, Suffix t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return i;
        }

        return n;
    }

    public class Suffix implements Comparable<Suffix> {

        private final String text;
        private final int index;

        public Suffix(String text, int i) {
            this.text = text;
            this.index = i;
        }

        public int length() {
            return text.length() - index;
        }

        public char charAt(int i) {
            return text.charAt(index + i);
        }

        @Override
        public int compareTo(Suffix that) {
            if (this == that)
                return 0;
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i))
                    return -1;
                if (this.charAt(i) > that.charAt(i))
                    return +1;
            }
            return this.length() - that.length();
        }

        @Override
        public String toString() {
            return text.substring(index);
        }
    }

    private static int lcp(String s, String t) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }

        return len;
    }
}
