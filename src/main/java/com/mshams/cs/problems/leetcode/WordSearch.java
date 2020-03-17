package com.mshams.cs.problems.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> output = new ArrayList<>();
    if (board == null || board.length == 0 || words == null || words.length == 0) return output;
    int m = board.length, n = board[0].length;
    int maxLength = 0;
    Set<String> dict = new HashSet<>();
    for (String w : words) {
      maxLength = Math.max(maxLength, w.length());
      dict.add(w);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, dict, "", i, j, maxLength, output);
      }
    }

    return output;
  }

  void dfs(char[][] board, Set<String> words, String prefix, int i, int j, int maxLength, List<String> output) {
    int m = board.length, n = board[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '*' || prefix.length() > maxLength) return;

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char c = board[i][j];
    board[i][j] = '*';

    String w = prefix + c;
    if (words.contains(w)) output.add(w);

    for (int[] d : dirs) {
      dfs(board, words, w, i + d[0], j + d[1], maxLength, output);
    }

    board[i][j] = c;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
    WordSearch wordSearch = new WordSearch();
    wordSearch.findWords(board, new String[]{"oath", "pea", "eat", "rain"});
  }
}
