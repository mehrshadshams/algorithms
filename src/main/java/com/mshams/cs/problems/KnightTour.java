package com.mshams.cs.problems;

import java.util.Arrays;

/**
 * Knight Tour (https://en.wikipedia.org/wiki/Knight%27s_tour)
 * Backtracking
 */
public class KnightTour {
    static final int N = 8;
    int[][] solution = new int[N][N];
    int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public boolean findSolution() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(solution[i], -1);
        }
        solution[0][0] = 0;
        boolean result = findSolution(0, 0, 1);
        if (result) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        } else {
            System.out.println("No solution");
            return false;
        }
    }

    private boolean isSafe(int r2, int c2) {
        return (r2 >= 0 && r2 < N && c2 >= 0 && c2 < N &&
                solution[r2][c2] == -1);
    }

    private boolean findSolution(int r, int c, int move) {
        if (move == N * N) {
            return true;
        }

        for (int k = 0; k < dx.length; k++) {
            int x2 = c + dx[k];
            int y2 = r + dy[k];
            if (isSafe(y2, x2)) {
                solution[y2][x2] = move;
                if (findSolution(y2, x2, move + 1)) {
                    return true;
                } else {
                    solution[y2][x2] = -1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        KnightTour k = new KnightTour();
        System.out.println(k.findSolution());
    }
}
