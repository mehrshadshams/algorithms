package com.mshams.cs.problems.legacy;

import java.util.*;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 * TODO
 */
public class CaptureRegionsOnBoard {
  int rMove[] = {-1, 1, 0, 0};
  int cMove[] = {0, 0, 1, -1};
  int n;
  int m;
  char[][] A;

  public static void main(String[] args) {
    List<Integer> l = Arrays.asList(3, 30, 34, 5, 9);
//        List<Integer> l = Arrays.asList(8, 89);
//        l.sort(new Custom());
//        for(int x : l) {
//            System.out.println(x);
//        }


    System.out.println(Integer.MAX_VALUE);
    System.out.println(46341 * 46341);
  }

  private static void print(ArrayList<ArrayList<Character>> list) {
    String out = "";
    for (int i = 0; i < list.size(); i++) {
      ArrayList<Character> a = list.get(i);
      for (int j = 0; j < a.size(); j++) {
        out += String.valueOf(a.get(j));
      }
      System.out.println(out);
      out = "";
    }
  }

  private static void print(char[][] list) {
    String out = "";
    for (int i = 0; i < list.length; i++) {
      char[] a = list[i];
      for (int j = 0; j < a.length; j++) {
        out += String.valueOf(a[j]);
      }
      System.out.println(out);
      out = "";
    }
  }

  public void solve(ArrayList<ArrayList<Character>> a) {
    A = new char[a.size()][a.get(0).size()];
    n = a.size();
    m = a.get(0).size();
    for (int i = 0; i < a.size(); i++) {
      ArrayList<Character> temp = a.get(i);
      for (int j = 0; j < temp.size(); j++) {
        A[i][j] = temp.get(j);
        if (A[i][j] == 'O') {
          A[i][j] = '-';
        }
      }
    }
    for (int i = 0; i < m; i++) {
      if (A[0][i] == '-') {
        bfs(0, i);
      }
      if (A[n - 1][i] == '-') {
        bfs(n - 1, i);
      }
    }
    for (int i = 0; i < n; i++) {
      if (A[i][0] == '-') {
        bfs(i, 0);
      }
      if (A[i][m - 1] == '-') {
        bfs(i, m - 1);
      }
    }
    for (int i = 0; i < n; i++) {
      ArrayList<Character> temp = new ArrayList<Character>();
      for (int j = 0; j < m; j++) {
        if (A[i][j] == '-') {
          temp.add('X');
        } else {
          temp.add(A[i][j]);
        }
      }
      a.remove(i);
      a.add(i, temp);
    }
  }

  public void bfs(int row, int col) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(new Node(row, col));
    while (!q.isEmpty()) {
      Node temp = q.poll();
      int r = temp.r;
      int c = temp.c;
      A[r][c] = 'O';
      for (int i = 0; i < 4; i++) {
        if (isSafe(r + rMove[i], c + cMove[i])) {
          q.add(new Node(r + rMove[i], c + cMove[i]));
        }
      }
    }
  }

  public boolean isSafe(int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < m && A[r][c] == '-';
  }

//    public static void main(String[] args) {
//        String s = "XOOXXXXXXOOXXOOXXXXXXXXX";
//        ArrayList<ArrayList<Character>> list =new ArrayList<>();
//        for (int i=0; i<3; i++) {
//            ArrayList<Character> a = new ArrayList<>();
//            for (int j=0; j<8; j++) {
//                a.add(s.charAt(i*8+j));
//            }
//            list.add(a);
//        }
//
//        CaptureRegionsOnBoard c = new CaptureRegionsOnBoard();
//        c.solve(list);
//
//        print(list);
//    }

  static class Custom implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
      if (Objects.equals(a, b)) {
        return 0;
      }

      List<Integer> l1 = toList(a);
      List<Integer> l2 = toList(b);


      int m = Math.max(l1.size(), l2.size());
      int n1 = -1;
      int n2 = -1;
      for (int i = 0; i < m; i++) {
        if (i < l1.size())
          n1 = l1.get(i);

        if (i < l2.size())
          n2 = l2.get(i);

        if (n1 > n2) {
          return -1;
        } else if (n2 > n1) {
          return 1;
        }
      }


      return 0;
    }

    private List<Integer> toList(int n) {
      List<Integer> list = new ArrayList<>();
      while (n > 0) {
        int m = n % 10;
        n = n / 10;
        list.add(0, m);
      }
      return list;
    }

  }

  public class Node {
    int r, c;

    Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
