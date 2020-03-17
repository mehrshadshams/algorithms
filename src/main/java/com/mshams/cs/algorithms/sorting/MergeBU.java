package com.mshams.cs.algorithms.sorting;

import com.mshams.cs.utils.StdArray;

public class MergeBU {
  public static void sort(Comparable[] array) {
    Comparable[] aux = new Comparable[array.length];
    for (int sz = 1; sz < array.length; sz = sz + sz)
      for (int lo = 0; lo < array.length - sz; lo += sz + sz) {
        int mid = lo + sz - 1;
        int hi = Math.min(lo + sz + sz - 1, array.length - 1);
        merge(array, aux, lo, mid, hi);
      }
  }

  private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = array[k];
    }

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        array[k] = aux[j++];
      else if (j > hi)
        array[k] = aux[i++];
      else if (StdArray.less(aux[j], aux[i]))
        array[k] = aux[j++];
      else
        array[k] = aux[i++];
    }
  }
}
