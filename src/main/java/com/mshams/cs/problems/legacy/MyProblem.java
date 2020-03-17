package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyProblem {
  public static void main(String[] args) {
    // XXXXXXXX
    // XOOXXOOX
    // XXXXXXXX";
    String s = "XOOXXXXXXOOXXOOXXXXXXXXX";
    ArrayList<ArrayList<Character>> list = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      ArrayList<Character> a = new ArrayList<>();
      for (int j = 0; j < 8; j++) {
        a.add(s.charAt(i * 8 + j));
      }
      list.add(a);
    }

    MyProblem p = new MyProblem();
    p.solve(list);

    String out = "";
    for (int i = 0; i < 3; i++) {
      ArrayList<Character> a = list.get(i);
      for (int j = 0; j < 8; j++) {
        out += String.valueOf(a.get(j));
      }
      System.out.println(out);
      out = "";
    }


  }

  private void visit(ArrayList<ArrayList<Character>> a, Map<Integer, Boolean> map, int index) {
//        if (map.containsKey(index)) {
//            return;
//        }

    if (a == null) {
      return;
    }

    if (a.size() == 0 || a.get(0).size() == 0) {
      return;
    }

    int m = a.size();
    int n = a.get(0).size();
    int row = index / n;
    int col = index % n;
    Character c = a.get(row).get(col);

    if (c == 'B') {
      return;
    }

    map.put(index, true);

    a.get(row).set(col, 'B');

    // try right
    if (col < n - 1) {
      visit(a, map, toIndex(row, col + 1, n));
    }

    // try bottom
    if (row < m - 1) {
      visit(a, map, toIndex(row + 1, col, n));
    }

    // try left
    if (col > 0) {
      visit(a, map, toIndex(row, col - 1, n));
    }

    // try top
    if (row > 0) {
      visit(a, map, toIndex(row - 1, col, n));
    }

    a.get(row).set(col, c);

    if (c == 'O') {
      // check to see if surround all are X
      boolean rightX = false;
      boolean leftX = false;
      boolean topX = false;
      boolean bottomX = false;
      if (col < n - 1) {
        if (a.get(row).get(col + 1) == 'X') {
          rightX = true;
        }
      }
      if (col > 0) {
        if (a.get(row).get(col - 1) == 'X') {
          leftX = true;
        }
      }
      if (row < m - 1) {
        if (a.get(row + 1).get(col) == 'X') {
          bottomX = true;
        }
      }
      if (row > 0) {
        if (a.get(row - 1).get(col) == 'X') {
          topX = true;
        }
      }

      if (rightX && leftX && topX && bottomX) {
        a.get(row).set(col, 'X');
      }

    } else {
      // don't expand
    }

  }

  public void solve(ArrayList<ArrayList<Character>> a) {
    Map<Integer, Boolean> map = new HashMap<>();
//        visit(a, map, 0);

    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.get(0).size(); j++) {

      }
    }

  }

  public int toIndex(int row, int col, int n) {
    return row * n + col;
  }
}
