package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Respace extends Problem {

  public String run(String text, Set<String> dict) {
    Trie trie = new Trie();
    dict.forEach(trie::add);

    Trie.TrieNode node = trie.getRoot();
    StringBuilder sb = new StringBuilder();
    String lastWord = null;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      Trie.TrieNode next = node.get(c);
      if (next != null) {
        if (next.isVocab()) {
          sb.append(" " + lastWord);
          node = trie.getRoot();
        } else {
          lastWord += c;
          node = next;
        }
      } else {
        lastWord = "";
        sb.append(lastWord);
        node = trie.getRoot();
        next = node.get(c);
        if (next != null) {

        }
      }
    }

    return null;
  }

  @Override
  void run() {
    Set<String> dict = new HashSet<>(Arrays.asList("looked", "just", "like", "her", "brother"));
    System.out.println(run("jesslookedjustliketimherbrother", dict));
  }
}
