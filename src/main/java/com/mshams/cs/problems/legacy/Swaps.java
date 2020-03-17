package com.mshams.cs.problems.legacy;

public class Swaps {

  static int minimumSwaps(int[] arr) {
    int[] diff = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      int correct_index = val - 1;
      diff[i] = correct_index - i;
    }

    int swaps = 0;
    boolean isSorted = false;
    while (!isSorted) {
      MinMax minMax = findMinMax(diff);
      if (minMax == null) {
        isSorted = true;
      } else {
        // update diff
        swap(arr, diff, minMax.min, minMax.max);
        swaps++;
      }
    }
    return swaps;
  }

  private static void swap(int[] arr, int[] diff, int idx1, int idx2) {
    int value1 = arr[idx1];
    int value2 = arr[idx2];

    arr[idx1] = value2;
    arr[idx2] = value1;

    diff[idx1] = arr[idx1] - 1 - idx1;
    diff[idx2] = arr[idx2] - 1 - idx2;
  }

  private static MinMax findMinMax(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int minIndex = -1;
    int maxIndex = -1;
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (val < min) {
        min = val;
        minIndex = i;
      }
      if (val > max) {
        max = val;
        maxIndex = i;
      }
    }
    if (min == 0 && max == 0) {
      return null;
    }
    return new MinMax(minIndex, maxIndex);
  }

  public static void main(String[] args) {
    minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 8});
  }

  private static class MinMax {
    int min;
    int max;

    MinMax(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }
}
