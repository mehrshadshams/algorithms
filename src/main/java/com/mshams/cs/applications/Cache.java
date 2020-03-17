package com.mshams.cs.applications;

public interface Cache {
  int get(int key);
  void put(int key, int value);
}
