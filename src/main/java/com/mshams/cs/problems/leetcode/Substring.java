package com.mshams.cs.problems.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Substring {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Suffix> suffixes = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      suffixes.add(new Suffix(s, i));
    }

    List<Suffix> sortedSuffixes = new ArrayList<>(suffixes);

    int n = words[0].length();

    Collections.sort(sortedSuffixes);

    List<Integer> out = new ArrayList<>();

    for (String word : words) {
      int index = binarySearch(sortedSuffixes, word);

      while (index < suffixes.size() && sortedSuffixes.get(index).substring(0, n).equals(word)) {
        Suffix suffix = sortedSuffixes.get(index);
        int suffixIndex = suffix.index;

        Set<String> wordsCopy = Arrays.stream(words).collect(Collectors.toSet());

        while (suffixIndex < suffixes.size() && !wordsCopy.isEmpty()) {
          String nextWord = suffixes.get(suffixIndex).substring(0, n);
          if (!wordsCopy.contains(nextWord)) {
            break;
          }

          wordsCopy.remove(nextWord);
          suffixIndex += 3;
        }

        while (suffixIndex >= 0 && !wordsCopy.isEmpty()) {
          String nextWord = suffixes.get(suffixIndex).substring(0, n);
          if (!wordsCopy.contains(nextWord)) {
            break;
          }

          wordsCopy.remove(nextWord);
          suffixIndex -= 3;
        }

        if (wordsCopy.isEmpty()) {
          out.add(suffixIndex);
        }

        index++;
      }
    }

    return out;
  }

  int binarySearch(List<Suffix> suffixes, String word) {
    int lo = 0, hi = suffixes.size() - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = compare(word, suffixes.get(mid));
      if (cmp < 0) hi = mid - 1;
      else if (cmp > 0) lo = mid + 1;
      else return mid;
    }
    return lo;
  }

  int compare(String word, Suffix suffix) {
    int length = Integer.min(suffix.length(), word.length());
    for (int i = 0; i < length; i++) {
      if (word.charAt(i) < suffix.charAt(i)) return -1;
      if (word.charAt(i) > suffix.charAt(i)) return +1;
    }
    return word.length() - suffix.length();
  }

  class Suffix implements Comparable<Suffix> {
    private String text;
    private int index;

    private Suffix(String text, int index) {
      this.index = index;
      this.text = text;
    }

    public int length() {
      return text.length() - index;
    }

    public int charAt(int idx) {
      return text.charAt(index + idx);
    }

    public String toString() {
      return text.substring(index);
    }

    public String substring(int i, int j) {
      return text.substring(index + i, index + j);
    }

    public int compareTo(Suffix other) {
      int n = Integer.min(this.length(), other.length());
      for (int i = 0; i < n; i++) {
        if (this.charAt(i) < other.charAt(i)) return -1;
        if (this.charAt(i) > other.charAt(i)) return 1;
      }
      return this.length() - other.length();
    }
  }

}