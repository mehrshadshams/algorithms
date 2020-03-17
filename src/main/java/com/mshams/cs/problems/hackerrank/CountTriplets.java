package com.mshams.cs.problems.hackerrank;

import java.util.*;

public class CountTriplets {
  static long countTriplets(List<Long> arr, long r) {
    List<Map<Long, Integer>> freq = new ArrayList<>();
    Map<Long, Integer> arrayFreq = new HashMap<>();
    for (long x : arr) {
      arrayFreq.put(x, arrayFreq.getOrDefault(x, 0) + 1);
    }
    for (int i = 0; i < 3; i++) {
      freq.add(new HashMap<>());
    }
    for (long x : arrayFreq.keySet()) {
      long base = x;
      Stack<Integer> temp = new Stack<>();
      int counter = 3;
      while (x > 0 && counter > 0) {
        if (!arrayFreq.containsKey(x)) {
          break;
        }

        temp.push(arrayFreq.get(x));
        if (x / r != 0) {
          base = x / r;
        }
        x /= r;
        counter--;
      }
      int p = 0;
      if (temp.size() == 3) {
        while (!temp.isEmpty()) {
          int f = temp.pop();
          freq.get(p).put(base, freq.get(p).getOrDefault(base, 0) + f);
          p++;
        }
      }
    }
    long res = 0;
    for (long num : freq.get(0).keySet()) {
      int total = freq.get(0).get(num);
      boolean exists = true;
      for (int j = 1; j < 2; j++) {
        exists = freq.get(j).containsKey(num);
        if (!exists) {
          break;
        }
        total *= freq.get(j).get(num);
      }
      if (exists) {
        res += total;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(CountTriplets.countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));
  }
}
