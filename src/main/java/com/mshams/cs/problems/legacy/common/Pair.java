package com.mshams.cs.problems.legacy.common;

public class Pair<T, V> {
  private final T first;
  private final V second;

  private Pair(T first, V second) {
    this.first = first;
    this.second = second;
  }

  public static <A, B> Pair<A, B> of(A a, B b) {
    return new Pair<>(a, b);
  }

  public T getFirst() {
    return first;
  }

  public V getSecond() {
    return second;
  }
}
