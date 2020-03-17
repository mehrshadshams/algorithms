package com.mshams.cs.problems.legacy;

import java.util.Collection;
import java.util.List;

public class Utils {
  public static <T> void printArray(T[] array) {
    for (T t : array) {
      System.out.print(t + " ");

    }
    System.out.println();
  }

  public static <T> void printArray(Collection<T> array) {
    for (T t : array) {
      System.out.print(t + " ");

    }
    System.out.println();
  }

  public static void printArray(int[] array) {
    for (int t : array) {
      System.out.print(t + " ");

    }
    System.out.println();
  }

  public static void printArray(char[][] array) {
    for (char[] t : array) {
      for (char c : t) {
        System.out.print(c + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void printArray(int[][] array) {
    for (int[] t : array) {
      for (int c : t) {
        System.out.print(c + "\t    ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static <T> void printList(List<T> list) {
    for (T t : list) {
      System.out.print(t + " ");
    }
    System.out.println();
  }


  public static int[] array(int... items) {
    return items;
  }

  public static char[] array(char... items) {
    return items;
  }

  public static String[] array(String... items) {
    return items;
  }

  public static int[][] matrix(int w, int h, int... items) {
    int[][] m = new int[h][w];
    for (int i = 0; i < w * h; i++) {
      int r = i / h;
      int c = i % w;
      m[r][c] = items[i];
    }
    return m;
  }
}
