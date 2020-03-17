package com.mshams.cs.problems.legacy;

import java.util.*;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class Multisearch extends Problem {

  public List<String> search(String text, List<String> words) {

    //TODO: Use Trie

    List<String> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, -2);
    }

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      List<String> keysToRemove = new ArrayList<>();
      for (String key : map.keySet()) {
        int index = map.get(key);
        if (index < 0) {
          if (c == key.charAt(0)) {
            index = -1;
          }
        }

        if (index >= -1) {
          if (c == key.charAt(index + 1)) {
            map.put(key, index + 1);
            if (index + 1 == key.length() - 1) {
              keysToRemove.add(key);
              list.add(key);
            }
          } else {
            // can't find
            map.put(key, -2);
          }
        }
      }

      removeKeys(map, keysToRemove);

    }

    return list;
  }

  private void removeKeys(Map<String, Integer> map, List<String> keysToRemove) {
    keysToRemove.forEach(k -> map.remove(k));
  }

  @Override
  void run() {
    String text = "mississippi";
    printArray(search(text, Arrays.asList("is", "ppi", "hi", "sis", "i", "ssippi")));
  }
}
