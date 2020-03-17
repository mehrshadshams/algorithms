package com.mshams.cs.problems.legacy;

import java.util.*;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 * TODO
 */
public class WordSearch2 extends Problem {

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.add(word);
    }

    Set<String> matches = new HashSet<>();
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        match(board, i, j, trie.root, "", matches);
      }
    }

    return new ArrayList<>(matches);
  }

  void match(char[][] board, int i, int j, TrieNode node, String path, Set<String> matches) {
    int m = board.length;
    int n = board[0].length;

    if (i < 0 || i >= m || j < 0 || j >= n) {
      return;
    }

    char ch = board[i][j];
    if (ch == '*') {
      return;
    }

    TrieNode node2 = node.get(ch);
    if (node2 == null) {
      return;
    }

    String path2 = path + String.valueOf(ch);

    if (node2.vocab) {
      matches.add(path2);
    }

    board[i][j] = '*';

    match(board, i + 1, j, node2, path2, matches);
    match(board, i - 1, j, node2, path2, matches);
    match(board, i, j + 1, node2, path2, matches);
    match(board, i, j - 1, node2, path2, matches);

    board[i][j] = ch;
  }

  @Override
  void run() {
    char[][] board = new char[][]{
            array('a', 'b')
    };

    List<String> temp = findWords(board, array("ba"));

    printArray(temp);
  }

  class Trie {
    private TrieNode root = new TrieNode();

    void add(String word) {
      root.add(word);
    }

    boolean contains(String word) {
      return root.contains(word);
    }
  }

  class TrieNode {
    char value;
    boolean vocab;
    private Map<Character, TrieNode> nodes = new HashMap<>();

    TrieNode() {
    }

    TrieNode(char ch) {
      this.value = ch;
    }

    void add(String word) {
      add(word, 0);
    }

    void add(String word, int index) {
      if (index < word.length()) {
        char ch = word.charAt(index);
        TrieNode root = nodes.getOrDefault(ch, new TrieNode(ch));
        nodes.put(ch, root);
        root.add(word, index + 1);
      } else {
        vocab = true;
      }
    }

    boolean contains(String word) {
      return contains(word, 0);
    }

    boolean contains(String word, int index) {
      if (index < word.length()) {
        char ch = word.charAt(index);
        if (!nodes.containsKey(ch)) {
          return false;
        }

        return contains(word, index + 1);
      }
      return true;
    }

    TrieNode get(char ch) {
      return nodes.getOrDefault(ch, null);
    }
  }
}
