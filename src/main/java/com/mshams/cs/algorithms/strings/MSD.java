package com.mshams.cs.algorithms.strings;

public class MSD {
  private static final int R = 256;

  public static void sort(String[] a, int maxLength) {
    String[] aux = new String[a.length];
    sort(a, aux, maxLength, 0, a.length - 1, 0);
  }

  private static void sort(String[] a, String[] aux, int maxLength, int lo, int hi, int w) {
    if (hi <= lo)
      return;

    int[] count = new int[R + 2];

    // compute frequencies
    for (int i = lo; i <= hi; i++) {
      int c = charAt(a[i], w);
      count[c + 2]++;
    }

    // transform counts to indicies
    for (int i = 0; i < R + 1; i++) {
      count[i + 1] += count[i];
    }

    // distribute
    for (int i = lo; i <= hi; i++) {
      int c = charAt(a[i], w);
      aux[count[c + 1]++] = a[i];
    }

    // copy back
    for (int i = lo; i <= hi; i++) {
      a[i] = aux[i];
    }

    // recursively sort for each character (excludes sentinel -1)
    for (int i = 0; i < R; i++) {
      sort(a, aux, maxLength, lo + count[i], lo + count[i + 1] - 1, w + 1);
    }
  }

  private static int charAt(String s, int d) {
    if (d < s.length())
      return s.charAt(d);
    return -1;
  }
}
