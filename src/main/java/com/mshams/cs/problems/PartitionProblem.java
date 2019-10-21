package com.mshams.cs.problems;

/**
 * Skienna
 * Ch. 8.5
 */
public class PartitionProblem {
    public void partition(int[] s, int k) {
        int n = s.length;

        int[][] m = new int[n + 1][k + 1];
        int[][] d = new int[n + 1][k + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + s[i - 1];
        }

        for (int i = 1; i <= n; i++)
            m[i][1] = p[i];

        for (int j = 1; j < k; j++)
            m[1][j] = s[0];

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                m[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= (i - 1); x++) {
                    int cost = Math.max(m[x][j - 1], p[i] - p[x]);
                    if (m[i][j] > cost) {
                        m[i][j] = cost;
                        d[i][j] = x;
                    }
                }
            }
        }

        reconstructPartitions(s, d, n, k);
    }

    private void reconstructPartitions(int[] s, int[][] d, int n, int k) {
        if (k == 1) {
            print(s, 1, n);
        } else {
            reconstructPartitions(s, d, d[n][k], k - 1);
            print(s, d[n][k] + 1, n);
        }
    }

    private void print(int[] s, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(" " + s[i - 1] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PartitionProblem p = new PartitionProblem();
        p.partition(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
    }
}
