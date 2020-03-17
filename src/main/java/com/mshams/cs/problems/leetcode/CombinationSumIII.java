package com.mshams.cs.problems.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new ArrayList<>();
    find(k, n, list, new ArrayList<>(), new boolean[10], new HashSet<>());
    return list;
  }

  private void find(int k, int total, List<List<Integer>> list, List<Integer> selection, boolean[] used, Set<List<Integer>> set) {
    if (selection.size() == k && total == 0) {
      List<Integer> s = new ArrayList<>(selection);
      Collections.sort(s);
      if (!set.contains(s)) {
        set.add(s);
        list.add(s);
        return;
      }
    }
    if (total == 0) return;
    if (selection.size() >= k) return;

    for (int i = 1; i <= 9; i++) {
      if (!used[i]) {
        used[i] = true;

        selection.add(i);

        total -= i;

        find(k, total, list, selection, used, set);

        total += i;

        selection.remove(selection.size() - 1);

        used[i] = false;
      }
    }
  }
}
