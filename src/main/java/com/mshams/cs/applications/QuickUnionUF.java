package com.mshams.cs.applications;

public class QuickUnionUF implements UF {
  private final int[] parent;
  private int count;

  public QuickUnionUF(int n) {
    count = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  @Override
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  @Override
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP != rootQ) {
      parent[rootP] = rootQ;
      count--;
    }
  }

  @Override
  public int find(int p) {
    validate(p);
    while (p != parent[p]) {
      p = parent[p];
    }
    return p;
  }

  @Override
  public int count() {
    return count;
  }

  private void validate(int index) {
    final int n = parent.length;
    if (index < 0 || index >= n) {
      throw new IllegalArgumentException("index " + index + " is not between 0 and " + (n - 1));
    }
  }
}
