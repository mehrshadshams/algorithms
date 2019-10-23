package com.mshams.cs.algorithms.dp;

import com.mshams.cs.applications.WeightedInterval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Algorithm Design, Jon Kleinberg and Eva Tardos
 * Ch. 6.1
 */
public class WeightedIntervalScheduling {
    public List<WeightedInterval> findMaximumWeightedNonOverlapping(WeightedInterval[] intervals) {
        // 1. Sort the intervals
        Arrays.sort(intervals, WeightedInterval.FINISH_ASC);

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start();
            ends[i] = intervals[i].end();
        }

        // 2. For each interval find the index of previous non-overlapping interval, i.e. p(j)
        int[] p = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int k = floor(ends, starts[i]);
            p[i] = k - 1;
        }

        // 3. Find maximum weight
        int[] opt = new int[intervals.length + 1];
        opt[1] = intervals[0].weight();

        for (int i = 1; i < intervals.length; i++) {
            opt[i + 1] = Math.max(intervals[i].weight() + opt[p[i] + 1], opt[i]);
        }

        // 4. Reconstruct solution
        List<WeightedInterval> solution = new LinkedList<>();

        findSolution(solution, intervals, p, opt, intervals.length);

        return solution;
    }

    private int floor(int[] array, int x) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = Integer.compare(array[mid], x);
            if (cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private static void findSolution(List<WeightedInterval> solution, WeightedInterval[] intervals,
                                     int[] p, int[] opt, int j) {
        if (j == 0) {
            return;
        }

        int index = j - 1;

        if (intervals[index].weight() + opt[p[index] + 1] >= opt[j]) {
            solution.add(0, intervals[index]);
            findSolution(solution, intervals, p, opt, p[index] + 1);
        } else {
            findSolution(solution, intervals, p, opt, j - 1);
        }
    }

    public static void main(String[] args) {
        WeightedInterval[] intervals = {
                new WeightedInterval(0, 3, 2),
                new WeightedInterval(1, 5, 4),
                new WeightedInterval(4, 5, 4),
                new WeightedInterval(2, 7, 7),
                new WeightedInterval(6, 8, 2),
                new WeightedInterval(6, 9, 1),
        };

        WeightedIntervalScheduling problem = new WeightedIntervalScheduling();
        List<WeightedInterval> solution = problem.findMaximumWeightedNonOverlapping(intervals);

        for (WeightedInterval wi : solution) {
            System.out.println(wi.toString());
        }
    }
}
