package com.mshams.cs.problems.leetcode;

import com.mshams.cs.algorithms.strings.Manacher;
import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 */
@Complexity(ComplexityLevel.HARD)
public class PalindromePairs {
  private class PalindromePairsManacher {
    private String reverseString(String str) {
      char[] c = new char[str.length()];
      for (int i = 0; i < str.length(); i++) {
        c[i] = str.charAt(str.length() - i - 1);
      }
      return new String(c);
    }

    public boolean isPalindrome(String a, String b) {
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

    private char charAt(String a, String b, int index) {
      if (index < a.length()) {
        return a.charAt(index);
      }
      return b.charAt(index - a.length());
    }

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
  }

  private class PalindromePairsTrie {
    class TrieNode {
      public TrieNode[] children = new TrieNode[26];
      public int wordIndex = -1;
      public List<Integer> palindromeList = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
      final List<List<Integer>> result = new ArrayList<>();
      if (words.length == 0) return result;
      TrieNode root = new TrieNode();
      for (int i = 0; i < words.length; i++) {
        addWord(root, words[i], i);
      }

      for (int i = 0; i < words.length; i++) {
        search(words[i], i, result, root);
      }
      return result;
    }

    private void search(String word, int wordIndex, List<List<Integer>> result, TrieNode node) {
      if (word == null) return;
      TrieNode cur = node;
      for (int i = 0; i < word.length(); i++) {
        if (isPalindrome(word, i, word.length() - 1) && cur.wordIndex > -1 && cur.wordIndex != wordIndex) {
          result.add(Arrays.asList(wordIndex, cur.wordIndex));
        }

        final int charIndex = word.charAt(i) - 'a';
        if (cur.children[charIndex] == null) return;

        cur = cur.children[charIndex];
      }

      for (int x : cur.palindromeList) {
        if (x == wordIndex) continue;
        result.add(Arrays.asList(wordIndex, x));
      }
    }

    private void addWord(TrieNode root, String word, int wordIndex) {
      if (word == null) return;
      int length = word.length();
      TrieNode cur = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        if (isPalindrome(word, 0, i)) {
          cur.palindromeList.add(wordIndex);
        }
        final int charIndex = word.charAt(i) - 'a';
        if (cur.children[charIndex] == null) {
          cur.children[charIndex] = new TrieNode();
        }
        cur = cur.children[charIndex];
      }
      cur.wordIndex = wordIndex;
      cur.palindromeList.add(wordIndex);
    }

    private boolean isPalindrome(String w, int left, int right) {
      while (left < right) {
        if (w.charAt(left++) != w.charAt(right--)) {
          return false;
        }
      }
      return true;
    }
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    PalindromePairsTrie palindromePairsTrie = new PalindromePairsTrie();
    return palindromePairsTrie.palindromePairs(words);
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
