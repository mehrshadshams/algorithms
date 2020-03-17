package com.mshams.cs.problems.leetcode;

import java.util.*;

public class AlienDictionary {
  HashMap<Integer, ArrayList<Integer>> graph; //adjacency list to store the graph;

  public String alienOrder(String[] words) {
    if (words.length == 0) return "";
    int[] visited = new int[26];
    Arrays.fill(visited, -1);
    graph = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < 26; i++)
      graph.put(i, new ArrayList<Integer>());
    for (char ch : words[0].toCharArray()) visited[ch - 'a'] = 0;
    for (int i = 0; i < words.length - 1; i++) {
      String str1 = words[i];
      String str2 = words[i + 1];
      for (char ch : words[i + 1].toCharArray()) visited[ch - 'a'] = 0;
      for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
        if (str1.charAt(j) != str2.charAt(j)) {
          int a = str1.charAt(j) - 'a';
          int b = str2.charAt(j) - 'a';
          graph.get(a).add(b);
          break;
        }
      }
    }

    StringBuilder s = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (visited[i] == 0)
        if (!topologicalSort(visited, i, s))
          return "";
    }
    return s.reverse().toString();
  }

  public boolean topologicalSort(int[] visited, int src, StringBuilder s) {
    visited[src] = 1;
    for (int next : graph.get(src)) {
      if (visited[next] == 1) return false;
      if (visited[next] == 0)
        if (!topologicalSort(visited, next, s))
          return false;
    }
    visited[src] = 2;
    s.append((char) (src + 'a'));
    return true;
  }

  public static void main(String[] args) {
    AlienDictionary alienDictionary = new AlienDictionary();
    System.out.println(alienDictionary.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
  }
}
