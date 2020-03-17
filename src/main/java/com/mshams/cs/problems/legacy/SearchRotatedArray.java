package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.array;

public class SearchRotatedArray extends Problem {

  public int search(int[] array, int x) {
    if (array.length == 0) return -1;
    int first = array[0];
    int last = array[array.length - 1];

    int mid = (array.length - 1) / 2;

    if (x > last) {
      return bst(array, x, 0, mid);
    } else if (x < first) {
      return bst(array, x, mid, array.length - 1);
    }

    return bst(array, x, 0, array.length - 1);
  }

  int bst(int[] array, int x, int low, int high) {
    if (low > high) return -1;
    int mid = (low + high) / 2;

    if (x == array[mid]) {
      return mid;
    }

    if (x > array[mid]) {
      return bst(array, x, mid + 1, high);
    } else {
      return bst(array, x, low, mid - 1);
    }
  }

  @Override
  void run() {
    System.out.println(search(array(6, 7, 8, 1, 2, 3, 4), 1));
  }
}
