package com.mshams.cs.datastructures.collections;

import com.mshams.cs.utils.StdArray;

import java.util.NoSuchElementException;

public class PQ<Key extends Comparable<Key>> {
  private Comparable[] a;
  private int n;
  private boolean minPQ;

  private PQ(int initialCapacity, boolean minPQ) {
    this.a = new Comparable[initialCapacity + 1];
    this.minPQ = minPQ;
  }

  private PQ() {
    this(1, true);
  }

  public static <T extends Comparable<T>> PQ<T> min() {
    return new PQ<>();
  }

  public static <T extends Comparable<T>> PQ<T> max() {
    return new PQ<>(1, false);
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void insert(Key k) {
    if (n >= a.length) {
      resize(a.length * 2);
    }

    a[n++] = k;

    swim(n);
  }

  public Key del() {
    if (n == 0)
      throw new NoSuchElementException();

    Key max = (Key) a[1];
    StdArray.exch(a, 1, n--);

    sink(1);

    // prevent loitering
    a[n + 1] = null;

    return max;
  }

  private void swim(int i) {
    while (i > 0 && cmp(i / 2, i)) {
      StdArray.exch(a, i, i / 2);
      i /= 2;
    }
  }

  private boolean cmp(int i, int j) {
    int cmp = a[i].compareTo(a[j]);
    return minPQ ? cmp < 0 : cmp > 0;
  }

  private void sink(int i) {
    while (2 * i <= n) {
      int j = 2 * i;
      if (j < n && cmp(j, j + 1))
        j++;
      if (!cmp(i, j))
        break;
      StdArray.exch(a, i, j);
      i = j;
    }
  }

  private void resize(int newSize) {
    Comparable[] temp = new Comparable[newSize];
    for (int i = 0; i < newSize; i++) {
      temp[i] = a[i];
    }
    this.a = temp;
  }
}
