package com.mshams.cs.problems;

import com.mshams.cs.algorithms.strings.Trie;
import com.mshams.cs.utils.StdArray;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Boggle {
  public static void main(String[] args) {
    char[][] boggle = {
            {'G', 'I', 'Z'},
            {'U', 'E', 'K'},
            {'Q', 'S', 'E'}
    };

    String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO", "GEE"};

    Boggle b = new Boggle();
    StdArray.print(b.findWords(boggle, dictionary));
  }

  public Collection<String> findWords(char[][] boggle, String[] dictionary) {
    Set<String> words = new HashSet<>();
    Trie<Boolean> trie = new Trie<>();
    for (String w : dictionary) {
      trie.put(w, true);
    }

    for (int i = 0; i < boggle.length; i++) {
      for (int j = 0; j < boggle[0].length; j++) {
        findWords(boggle, trie, words, "", i, j);
      }
    }

    return words;
  }

  private void findWords(char[][] boggle, Trie<Boolean> trie, Set<String> words, String prefix,
                         int row, int col) {
    if (row < 0 || row >= boggle.length || col < 0 || col >= boggle[0].length) {
      return;
    }

    if (boggle[row][col] == '*') {
      return;
    }

    char c = boggle[row][col];

    String word = prefix + c;

    boggle[row][col] = '*';

    if (trie.contains(word)) {
      words.add(word);
    }

    int[] dx = {-1, 0, 1};
    int[] dy = {-1, 0, 1};

    for (int x : dx) {
      for (int y : dy) {
        findWords(boggle, trie, words, word, row + y, col + x);
      }
    }

    boggle[row][col] = c;
  }
}
