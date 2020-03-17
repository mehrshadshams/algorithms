package com.mshams.cs.algorithms.sorting;

import com.mshams.cs.utils.StdArray;

public class Selection {
  public static void sort(Comparable[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (StdArray.less(array[j], array[min])) {
          min = j;
        }
      }
      StdArray.exch(array, i, min);
    }
  }
}
