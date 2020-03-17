package com.mshams.cs.problems.legacy;

import java.util.HashSet;
import java.util.Set;

/**
 * see page 182
 */
public class DivingBoard extends Problem {

  public Set<Integer> countBoards(int k, int longer, int shorter) {
    Set<Integer> set = new HashSet<>();
    countBoards(k, longer, shorter, set, 0);
    return set;
  }

  private void countBoards(int k, int longer, int shorter, Set<Integer> set, int total) {
    if (k == 0) {
      set.add(total);
      return;
    }

    countBoards(k - 1, longer, shorter, set, total + shorter);
    countBoards(k - 1, longer, shorter, set, total + longer);
  }

  @Override
  void run() {
    System.out.println(countBoards(10, 10, 5));
  }
}
