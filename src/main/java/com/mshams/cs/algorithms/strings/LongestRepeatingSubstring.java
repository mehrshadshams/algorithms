package com.mshams.cs.algorithms.strings;

public class LongestRepeatingSubstring {
    private LongestRepeatingSubstring() {
    }

    public static String lrs(String text) {
        SuffixArray suffixArray = new SuffixArray(text);
        String lrs = "";
        for (int i = 0; i < suffixArray.length(); i++) {
            int length = suffixArray.lcp(i);
            if (length > lrs.length()) {
                lrs = text.substring(suffixArray.index(i), suffixArray.index(i) + length);
            }
        }

        return lrs;
    }
}
