package com.mshams.cs.problems.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {
//  public List<String> wordBreak(String s, List<String> wordDict) {
//    List<String> out = new ArrayList<>();
//    Set<String> dict = new HashSet<>(wordDict);
//    findWords(s, 0, new ArrayList<>(), dict, out);
//    return out;
//  }
//
//  void findWords(String s, int i, List<String> partial,
//                 Set<String> dict, List<String> output) {
//    if (i >= s.length()) {
//      output.add(String.join(" ", partial));
//      return;
//    }
//    for (int k = i; k <= s.length(); k++) {
//      String sub = s.substring(i, k);
//      if (dict.contains(sub)) {
//        partial.add(sub);
//        findWords(s, k, partial, dict, output);
//        partial.remove(partial.size() - 1);
//      }
//    }
//
//  }

  Map<Integer, List<String>> dp;

  public List<String> wordBreak(String s, List<String> wordDict) {
    dp = new HashMap<>();

    return generate(s, 0, new HashSet<>(wordDict));
  }

  private List<String> generate(String s, int i, Set<String> dict) {
    if (dp.containsKey(i)) return dp.get(i);
    LinkedList<String> res = new LinkedList<>();
    if (i == s.length()) {
      res.add("");
    }
    for (int end = i + 1; end <= s.length(); end++) {
      if (dict.contains(s.substring(i, end))) {
        List<String> list = generate(s, end, dict);
        for (String val : list) {
          res.add(s.substring(i, end) + (val.equals("") ? "" : " ") + val);
        }
      }
    }
    dp.put(i, res);
    return res;
  }

  public static void main(String[] args) {
    WordBreakII wordBreak = new WordBreakII();
    List<String> output = wordBreak.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
  }
}
