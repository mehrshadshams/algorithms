package com.mshams.cs.applications;

public class Interval {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }

    public boolean intersects(int lo, int hi) {
        return (lo >= start && lo < end) || (hi <= end && hi >= start);
    }
}
