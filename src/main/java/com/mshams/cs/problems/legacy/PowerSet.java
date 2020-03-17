package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mshams.cs.problems.legacy.Utils.printArray;

public class PowerSet extends Problem {
  public List<List<Integer>> powerset(List<Integer> set) {
    return powerset(set, 0);
  }

  private List<List<Integer>> powerset(List<Integer> set, int index) {
    if (index == set.size()) {
      List<List<Integer>> list = new ArrayList<>();
      list.add(new ArrayList<>());
      return list;
    }
    int current = set.get(index);
    List<List<Integer>> subset = powerset(set, index + 1);
    List<List<Integer>> temp = new ArrayList<>();
    for (List<Integer> x : subset) {
      List<Integer> y = new ArrayList<>(x);
      y.add(current);
      temp.add(y);
    }
    subset.addAll(temp);
    return subset;
  }

  @Override
  void run() {
    List<Integer> set = Arrays.asList(1, 2, 3);
    printArray(powerset(set));
  }
}
