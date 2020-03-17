package com.mshams.cs.algorithms.sorting;

public class Counting {
  public static void sort(int[] array, int radix) {
//         CLSR Implementation
//        int[] count = new int[radix];
//        for (int i = 0; i < array.length; i++) {
//            count[array[i]] += 1;
//        }
//
//        for (int i = 1; i < radix; i++) {
//            count[i] += count[i - 1];
//        }
//
//        int[] aux = new int[array.length];
//        for (int i = 0; i < aux.length; i++) {
//            int n = array[i];
//            aux[count[n] - 1] = n;
//            count[n]--;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = aux[i];
//        }

    int[] count = new int[radix + 1];
    for (int i = 0; i < array.length; i++) {
      count[array[i] + 1] += 1;
    }

    for (int i = 0; i < radix; i++) {
      count[i + 1] += count[i];
    }

    int[] aux = new int[array.length];
    for (int i = 0; i < aux.length; i++) {
      int n = array[i];
      aux[count[n]++] = n;
    }

    for (int i = 0; i < array.length; i++) {
      array[i] = aux[i];
    }
  }
}
