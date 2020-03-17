package com.mshams.cs.problems.legacy.common;

import java.util.HashMap;
import java.util.Map;

public class Trie {
  private TrieNode root = new TrieNode();

  public TrieNode getRoot() {
    return root;
  }

  public void add(String word) {
    root.add(word);
  }

  public boolean contains(String word) {
    return root.contains(word);
  }

  public class TrieNode {
    char value;
    boolean vocab;
    private Map<Character, TrieNode> nodes = new HashMap<>();

    TrieNode() {
    }

    TrieNode(char ch) {
      this.value = ch;
    }

    public boolean isVocab() {
      return vocab;
    }

    public void add(String word) {
      add(word, 0);
    }

    public void add(String word, int index) {
      if (index < word.length()) {
        char ch = word.charAt(index);
        TrieNode root = nodes.getOrDefault(ch, new TrieNode(ch));
        nodes.put(ch, root);
        root.add(word, index + 1);
      } else {
        vocab = true;
      }
    }

    public boolean contains(String word) {
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

    public TrieNode get(char ch) {
      return nodes.getOrDefault(ch, null);
    }
  }
}
