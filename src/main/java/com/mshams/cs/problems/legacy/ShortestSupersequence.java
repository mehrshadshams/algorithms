package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.Range;

import java.util.Arrays;
import java.util.List;

public class ShortestSupersequence extends Problem {

  public Range shortest(List<Integer> list, List<Integer> shorter) {
    int[][] nexts = new int[shorter.size()][list.size()];
    for (int i = 0; i < shorter.size(); i++) {
      Arrays.fill(nexts[i], -1);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      int x = list.get(i);
      int idx = shorter.indexOf(x);
      if (idx >= 0) {
        nexts[idx][i] = i;
      }
      for (int j = 0; j < shorter.size(); j++) {
        if (j != idx) {
          if (i + 1 < list.size() && nexts[j][i + 1] != -1) {
            nexts[j][i] = nexts[j][i + 1];
          }
        }
      }
    }

    Range range = null;
    int[][] diffs = getDiffs(nexts);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < diffs.length; i++) {
      if (diffs[1][i] < minDiff) {
        minDiff = diffs[1][i];
        int max = diffs[0][i];
        range = new Range(i, max);
      }
    }

    return range;
  }

  private int[][] getDiffs(int[][] nexts) {
    int[][] diffs = new int[2][nexts[0].length];
    for (int i = 0; i < diffs.length; i++) {
      int max = getMax(nexts, i);
      int diff = Math.abs(i - max);
      diffs[0][i] = max;
      diffs[0][i] = diff;
    }
    return diffs;
  }

  private int getMax(int[][] nexts, int i) {
    int max = Integer.MIN_VALUE;
    for (int j = 0; j < nexts.length; j++) {
      max = Math.max(max, nexts[j][i]);
    }
    return max;
  }

  private void fill(int[][] arr, int index, int value) {
    int[] temp = arr[index];
    for (int i = 0; i <= index; i++) {
      if (temp[i] == -1) {
        temp[i] = value;
      }
    }
  }

  @Override
  void run() {
    List<Integer> shorter = Arrays.asList(1, 5, 9);
    List<Integer> longer = Arrays.asList(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7);

    System.out.println(shortest(longer, shorter));
  }
}
