/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_RATIO = 1.96;

    private final int trials;
    private final double[] fractions;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.trials = trials;

        final int n2 = n * n;

        fractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                int next = StdRandom.uniform(n2);
                int row = (next / n) + 1;
                int col = (next % n) + 1;

                if (percolation.isFull(row, col)) {
                    percolation.open(row, col);
                }
            }

            double frac = (double) percolation.numberOfOpenSites() / n2;
            fractions[i] = frac;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_RATIO * stddev()) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_RATIO * stddev()) / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int t = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, t);

        System.out.println("mean = " + percolationStats.mean());
        System.out.println("stddev = " + percolationStats.stddev());
        System.out.println("95% confidence interval = [" +
                                   percolationStats.confidenceLo() + ", " +
                                   percolationStats.confidenceHi() + "]");
    }
}
