package com.mshams.cs.algs4.problems;

/**
 * https://codingbat.com/prob/p192570
 */
public class Remove {
    public char charAt(String s, int i) {
        return Character.toString(s.charAt(i)).toLowerCase().charAt(0);
    }

    public String withoutString(String base, String remove) {
        int R = 256;
        int M = remove.length();
        int[][] dfa = new int[R][M];
        dfa[charAt(remove, 0)][0] = 1;
        for (int i = 1, x = 0; i < M; i++) {
            for (int j = 0; j < R; j++) {
                dfa[j][i] = dfa[j][x];
            }
            dfa[charAt(remove, i)][i] = i + 1;
            x = dfa[charAt(remove, i)][x];
        }

        String out = "";
        int m = base.length();
        int i = 0, j = 0;
        int k = 0;
        for (; i < m; i++) {
            char c = charAt(base, i);
            j = dfa[c][j];
            if (j == M) {
                out += base.substring(k, i - M + 1);
                j = 0;
                k = i + 1;
            }
        }
        if (j == M) {
            out += base.substring(k, i - M);
        } else {
            out += base.substring(k);
        }
        return out;
    }

}
