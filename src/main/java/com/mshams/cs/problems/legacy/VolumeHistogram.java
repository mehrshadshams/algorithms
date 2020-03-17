package com.mshams.cs.problems.legacy;

public class VolumeHistogram extends Problem {

  public int getVolume(int[] histogram) {
    int volume = 0;

    int[] leftMax = new int[histogram.length];
    int[] rightMax = new int[histogram.length];
    int[] delta = new int[histogram.length];

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < histogram.length; i++) {
      max = Math.max(max, histogram[i]);
      leftMax[i] = max;
    }

    max = Integer.MIN_VALUE;
    for (int i = histogram.length - 1; i >= 0; i--) {
      max = Math.max(max, histogram[i]);
      rightMax[i] = max;
    }

    for (int i = 0; i < histogram.length; i++) {
      int min = Math.min(leftMax[i], rightMax[i]);
      delta[i] = Math.abs(min - histogram[i]);
      volume += delta[i];
    }

    return volume;
  }

  @Override
  void run() {
    System.out.println(getVolume(new int[]{0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1}));
  }
}
