/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[] board;

    private final WeightedQuickUnionUF unionUF;
    private final int n;
    private int openCount;

    public Percolation(int n) {
        this.n = n;
        board = new boolean[n * n + 2];

        unionUF = new WeightedQuickUnionUF(board.length);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            final int index = rowColToIndex(row, col);
            board[index] = true;
            openCount += 1;
            int[][] dir = {
                new int[] { -1, 0 },
                new int[] { 1, 0 },
                new int[] { 0, -1 },
                new int[] { 0, 1 },
            };

            if (row == 1) {
                unionUF.union(0, index);
            } else if (row == n) {
                unionUF.union(board.length - 1, index);
            }

            for (int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];
                if (r >= 1 && c >= 1 && r <= n && c <= n && isOpen(r, c)) {
                    unionUF.union(index, rowColToIndex(r, c));
                }
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        ensureRowCol(row, col);

        final int index = rowColToIndex(row, col);
        return board[index];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return isOpen(row, col) && unionUF.connected(0, rowColToIndex(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionUF.connected(0, board.length - 1);
    }

    private int rowColToIndex(int row, int col) {
        return (row - 1) * n + col;
    }

    private void ensureRowCol(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);      // input file
        int n = in.readInt();         // n-by-n percolation system

        Percolation perc = new Percolation(n);
        System.out.println(perc.isFull(1, 1));
        System.out.println(perc.isOpen(1, 1));
    }
}
