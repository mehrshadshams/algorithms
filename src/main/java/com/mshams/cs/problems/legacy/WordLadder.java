package com.mshams.cs.problems.legacy;

import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/842/
 * TODO
 */
public class WordLadder extends Problem {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    Set<Word> dict = new HashSet<>();
    for (String w : wordList) {
      dict.add(new Word(w));
    }
    Queue<Item> queue = new java.util.LinkedList<>();
    queue.add(new Item(beginWord, 1));
    while (!queue.isEmpty()) {
      Item next = queue.poll();
      if (endWord.equals(next.word)) {
        return next.len;
      }

      for (Word w : dict) {
        if (!w.visited && isAdjacent(w.word, next.word)) {
          queue.add(new Item(w.word, next.len + 1));
          w.visited = true;
        }
      }
    }

    return 0;
  }

  private boolean isAdjacent(String w1, String w2) {
    int diff = Math.abs(w1.length() - w2.length());
    if (diff > 0) {
      return false;
    }
    int count = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        count++;
        if (count > 1) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  void run() {
    System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
  }

  private class Word {
    boolean visited;
    private String word;

    Word(String word) {
      this.word = word;
    }
  }

  private class Item {
    private String word;
    private int len;

    Item(String w, int len) {
      this.word = w;
      this.len = len;
    }
  }
}
