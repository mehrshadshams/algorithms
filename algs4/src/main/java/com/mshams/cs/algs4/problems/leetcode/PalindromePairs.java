package com.mshams.cs.algs4.problems.leetcode;

import com.mshams.cs.algs4.interfaces.Complexity;
import com.mshams.cs.algs4.strings.Manacher;

import java.util.*;
import java.util.stream.Collectors;

import static com.mshams.cs.algs4.interfaces.ComplexityLevel.HARD;

@Complexity(HARD)
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            indexMap.put(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int iw = 0; iw < words.length; ++iw) {
            String w = words[iw];
            Manacher m = new Manacher(w); // O(w.size())
            int[] pLength = m.getP();
            String rev = reverseString(w); // O(w.size())
            for (int i = 0; i < pLength.length; ++i) {
                if (i == pLength[i]) {
                    String key = rev.substring(0, rev.length() - pLength[i]);
                    int it = indexMap.getOrDefault(key, -1); // NOTE that creating a temporary string and matching strings are O(K) complexity
                    // i != 0 -> it->first.size() < w.size()
                    if (it != -1 && (i > 0 || it < iw)) {
                        result.add(Arrays.asList(it, iw));
                    }
                }
                if (i + pLength[i] == 2 * w.length()) {
                    String key = rev.substring(pLength[i]);
                    int it = indexMap.getOrDefault(key, -1);
                    if (it != -1 && (key.length() != w.length() || it < iw)) {
                        result.add(Arrays.asList(iw, it));
                    }
                }
            }
        }
        return result;
    }

    private static String reverseString(String str) {
        char[] c = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(str.length() - i - 1);
        }
        return new String(c);
    }

    public static boolean isPalindrome(String a, String b) {
        int i = 0, j = a.length() + b.length() - 1;

        while (i < j) {
            char x = '\0', y = '\0';

            x = charAt(a, b, i);
            y = charAt(a, b, j);
            i++;
            j--;
            if (x != y) return false;
        }
        return true;
    }

    private static char charAt(String a, String b, int index) {
        if (index < a.length()) {
            return a.charAt(index);
        }
        return b.charAt(index - a.length());
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs pp = new PalindromePairs();
        List<List<Integer>> result = pp.palindromePairs(words);
        String str = result.stream().map(t -> "[" + t.get(0) + "," + t.get(1) + "]").collect(Collectors.joining(","));
        System.out.println(str);
        //Manacher m = new Manacher("adbbbbdp");
    }
}
