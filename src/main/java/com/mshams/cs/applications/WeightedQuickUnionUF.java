package com.mshams.cs.applications;

public class WeightedQuickUnionUF implements UF {
  private final int[] parent;
  private final int[] sz;
  private int count;

  public WeightedQuickUnionUF(int n) {
    count = n;
    parent = new int[n];
    sz = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      sz[i] = 1;
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
    if (rootP == rootQ) return;
    if (sz[rootP] < sz[rootQ]) {
      parent[rootP] = rootQ;
      sz[rootQ] += sz[rootP];
    } else {
      parent[rootQ] = rootP;
      sz[rootP] += sz[rootQ];
    }
    count--;
  }

  @Override
  public int find(int p) {
    validate(p);
    while (p != parent[p]) {
      // Path compression
      //parent[p] = parent[parent[p]];
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
