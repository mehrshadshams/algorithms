/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    private static final int CLOSE = 0;
    private static final int OPEN = 1;

    private final int[] board;
    private final WeightedQuickUnionUF unionUF;
    private final int n;
    private int openCount;

    public Percolation(int n) {
        this.n = n;
        board = new int[n * n + 2];
        Arrays.fill(board, CLOSE);

        unionUF = new WeightedQuickUnionUF(board.length);

        for (int i = 1; i <= n; i++) {
            unionUF.union(0, i);
            unionUF.union(board.length - 1, board.length - 1 - i);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        ensureRowCol(row, col);

        if (!isOpen(row, col)) {
            final int index = (row - 1) * n + col;
            board[index] = OPEN;
            openCount += 1;
            int[][] dir = {
                new int[] { -1, 0 },
                new int[] { 1, 0 },
                new int[] { 0, -1 },
                new int[] { 0, 1 },
            };
            for (int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];
                if (r >= 1 && c >= 1 && r <= n && c <= n && isOpen(r, c)) {
                    unionUF.union((row - 1) * n + col, (r - 1) * n + c);
                }
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        ensureRowCol(row, col);

        final int index = (row - 1) * n + col;
        return board[index] == OPEN;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return !isOpen(row, col);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionUF.connected(0, board.length - 1);
    }

    private void ensureRowCol(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

    }
}
