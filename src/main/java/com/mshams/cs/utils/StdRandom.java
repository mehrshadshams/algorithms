package com.mshams.cs.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class StdRandom {
  private static Random random;

  static {
    random = new Random(System.currentTimeMillis());
  }

  public static int[] random(int min, int max, int size) {
    int[] temp = new int[max - min];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = min + i;
    }

    int[] out = new int[size];
    for (int i = 0; i < size; i++) {
      final int x = i + random.nextInt(temp.length - i);
      ArrayUtils.swap(temp, i, x);

      out[i] = temp[i];
    }

    return out;
  }

  public static void shuffle(int[] a) {
    if (a == null)
      throw new IllegalArgumentException();

    for (int i = 0; i < a.length; i++) {
      int r = i + random.nextInt(a.length - i);
      int temp = a[r];
      a[r] = a[i];
      a[i] = temp;
    }
  }

  public static void shuffle(Object[] a) {
    if (a == null)
      throw new IllegalArgumentException();

    for (int i = 0; i < a.length; i++) {
      int r = i + random.nextInt(a.length - i);
      Object temp = a[r];
      a[r] = a[i];
      a[i] = temp;
    }
  }
}
