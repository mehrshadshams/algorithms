package com.mshams.cs.problems;

public class PermutationK {
    public void choose(char[] a, int k) {
        choose(a, a.length, k);
    }

    private void choose(char[] a, int n, int k) {
        if (k == 0) {
            for (int i = n; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            choose(a, n-1, k-1);
            swap(a, i, n-1);
        }
    }

    private void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        PermutationK p = new PermutationK();
        p.choose("abcd".toCharArray(), 2);
    }
}
