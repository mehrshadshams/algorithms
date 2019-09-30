package com.mshams.cs.applications;

public class QuickFindUF implements UF {
    private final int[] id;
    private int count;

    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);

        return id[p] == id[q];
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);

        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }

        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        return id[p];
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int index) {
        final int n = id.length;
        if (index < 0 || index >= n) {
            throw new IllegalArgumentException("index " + index + " is not between 0 and " + (n - 1));
        }
    }
}
