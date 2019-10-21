package com.mshams.cs.problems.skienna.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public List<Integer[]> findPairs(int[] numbers) {
        List<Integer[]> pairs = new ArrayList<>();

        int start = 0, end = numbers.length - 1;
        while (start < numbers.length / 2) {
            pairs.add(new Integer[] { numbers[start], numbers[end] });
            start++;
            end--;
        }

        return pairs;
    }
}
