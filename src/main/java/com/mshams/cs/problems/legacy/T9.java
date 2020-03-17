package com.mshams.cs.problems.legacy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class T9 extends Problem {
  String[] alpha = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public Set<String> getWords(String number, Set<String> dict) {
    // use tries
    Set<String> candidates = new HashSet<>();

    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);

      int val = Character.getNumericValue(c);
      char[] chars = alpha[val].toCharArray();

      Set<String> a = new HashSet<>();
      for (char c2 : chars) {
        Set<String> temp = findWords(i == 0 ? dict : candidates, c2, i);
        a.addAll(temp);
      }

      candidates = a;
    }

    return candidates;
  }

  private Set<String> findWords(Set<String> dict, char c, int index) {
    Set<String> set = new HashSet<>();
    for (String word : dict) {
      if (index < word.length() && word.charAt(index) == c) {
        set.add(word);
      }
    }
    return set;
  }

  @Override
  void run() {
    Set<String> dict = new HashSet<>(Arrays.asList("tree", "used", "useful"));
    printArray(getWords("8733", dict));
  }
}
