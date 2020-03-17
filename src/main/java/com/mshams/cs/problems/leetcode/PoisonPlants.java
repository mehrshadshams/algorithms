package com.mshams.cs.problems.leetcode;

import java.util.*;

public class PoisonPlants {
  public int poisonousPlants(int[] p) {
    List<Deque<Integer>> list = new ArrayList<>();
    Deque<Integer> s = new ArrayDeque<>();
    s.addFirst(p[0]);
    list.add(s);

    for (int i = 1; i < p.length; i++) {
      if (p[i] < list.get(list.size() - 1).peekLast()) {
        list.get(list.size() - 1).addLast(p[i]);
      } else {
        Deque<Integer> n = new ArrayDeque<>();
        n.add(p[i]);
        list.add(n);
      }
    }

    int days = 0;
    while (list.size() > 1) {
      for (int i = list.size() - 1; i > 0; i--) {
        list.get(i).removeFirst();
        if (list.get(i).isEmpty()) {
          list.remove(i);
        }
      }

      for (int i = list.size() - 1; i > 0; i--) {
        Deque<Integer> b = list.get(i);
        Deque<Integer> a = list.get(i - 1);

        if (merge(a, b)) {
          list.remove(i);
        }
      }

      days++;
    }

    int[][] a = new int[][]{{0}};
    Arrays.sort(a, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return 0;
      }
    });

    return days;
  }

  static boolean merge(Deque<Integer> a, Deque<Integer> b) {
    if (b.peekFirst() <= a.peekLast()) {
      while (!b.isEmpty()) {
        a.addLast(b.removeFirst());
      }
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    PoisonPlants p = new PoisonPlants();
    System.out.println(p.poisonousPlants(new int[]{6, 5, 4, 10}));
  }
}
