package com.mshams.cs.algs4.utils;

import java.util.Random;

public class StdRandom {
    private static Random random;

    static {
        random = new Random(System.currentTimeMillis());
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
