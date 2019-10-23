package com.mshams.cs.algorithms.dp;

public class EditDistance {
    private static final int MATCH = 0;
    private static final int INSERT = 1;
    private static final int DELETE = 2;

    private final String s;
    private final String t;
    private final Cell[][] m;

    EditDistance(String s, String t) {
        this.s = s;
        this.t = t;
        this.m = new Cell[s.length() + 1][t.length() + 1];

        m[0][0] = new Cell(0, -1);

        for (int i = 1; i <= s.length(); i++) {
            m[i][0] = new Cell(i, DELETE);
        }
        for (int j = 1; j <= t.length(); j++) {
            m[0][j] = new Cell(j, INSERT);
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                int[] op = new int[3];
                op[MATCH] = m[i - 1][j - 1].cost + (s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1);
                op[INSERT] = m[i][j - 1].cost + 1;
                op[DELETE] = m[i - 1][j].cost + 1;

                m[i][j] = new Cell(op[MATCH], MATCH);
                if (op[INSERT] < m[i][j].cost) {
                    m[i][j].cost = op[INSERT];
                    m[i][j].parent = INSERT;
                }
                if (op[DELETE] < m[i][j].cost) {
                    m[i][j].cost = op[DELETE];
                    m[i][j].parent = DELETE;
                }
            }
        }
    }

    public int cost() {
        return m[s.length()][t.length()].cost;
    }

    public String path() {
        return reconstructPath("", s.length(), t.length());
    }

    private String reconstructPath(String path, int i, int j) {
        if (m[i][j].parent != -1) {
            if (m[i][j].parent == MATCH) {
                String prefix = s.charAt(i - 1) == t.charAt(j - 1) ? "M" : "S";
                return reconstructPath(path, i - 1, j - 1) + prefix;
            }
            if (m[i][j].parent == INSERT) {
                return reconstructPath(path, i, j - 1) + "I";
            }
            if (m[i][j].parent == DELETE) {
                return reconstructPath(path, i - 1, j) + "D";
            }
        }

        return path;
    }

    private class Cell {
        private int cost;
        private int parent;

        Cell(int cost, int parent) {
            this.cost = cost;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance("thou-shalt-not", "you-should-not");
        System.out.println(ed.cost());
        System.out.println(ed.path());
    }
}
