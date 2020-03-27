package com.mshams.cs.problems.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Map<String, List<String>> wordMap = new HashMap<>();

    Set<String> temp = new HashSet<>(wordList);
    temp.add(beginWord);
    for (String w : temp) {
      for (int i = 0; i < w.length(); i++) {
        String key = w.substring(0, i) + "_" + w.substring(i + 1);
        wordMap.putIfAbsent(key, new ArrayList<>());
        wordMap.get(key).add(w);
      }
    }

    Set<String> visited = new HashSet<>();
    Queue<Path> q = new LinkedList<>();
    List<String> start = new ArrayList<>();
    start.add(beginWord);
    q.add(new Path(beginWord, start));

    List<List<String>> paths = new ArrayList<>();
    while (!q.isEmpty()) {
      Path p = q.poll();
      String word = p.node;
      if (endWord.equals(word)) {
        paths.add(new ArrayList<>(p.path));
        continue;
      }
      if (visited.contains(word)) continue;
      visited.add(word);

      for (int i = 0; i < word.length(); i++) {
        String key = word.substring(0, i) + "_" + word.substring(i + 1);
        for (String word2 : wordMap.get(key)) {
          List<String> path = new ArrayList<>(p.path);
          path.add(word2);
          q.add(new Path(word2, path));
        }
      }
    }

    return paths;
  }

  class Path {
    private String node;
    private List<String> path = new ArrayList<>();

    Path(String n, List<String> p) {
      node = n;
      path = p;
    }

    public String toString() {
      return node;
    }
  }

  public static void main(String[] args) {
    WordLadderII w = new WordLadderII();
    w.findLadders("hit", "cog",
            Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

  }
}
