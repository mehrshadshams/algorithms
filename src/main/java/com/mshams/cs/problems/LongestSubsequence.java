package com.mshams.cs.problems;

import com.mshams.cs.datastructures.searching.Binary;

import java.util.*;

/**
 * https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string/#code-challenge
 */
public class LongestSubsequence {
    public static String find(String word, String[] dict) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            final List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        List<String> list = Arrays.asList(dict);
        list.sort((o1, o2) -> -1 * Integer.compare(o1.length(), o2.length()));

        String longestSubsequece = null;
        int longest = 0;
        for (String d : list) {
            int index = 0;
            int totalMatches = 0;
            for (char c : d.toCharArray()) {
                if (!map.containsKey(c)) {
                    break;
                }

                final List<Integer> indices = map.get(c);

                int j = Binary.ceiling(indices.toArray(new Integer[0]), index);
                if (j != -1) {
                    totalMatches++;
                    index = indices.get(j) + 1;
                } else
                    break;
            }

            if (totalMatches > longest) {
                longest = totalMatches;
                longestSubsequece = d;
            }
        }

        return longestSubsequece;
    }
}
