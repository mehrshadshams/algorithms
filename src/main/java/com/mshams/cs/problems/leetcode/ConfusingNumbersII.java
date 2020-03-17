package com.mshams.cs.problems.leetcode;

import java.util.*;

public class ConfusingNumbersII {
  public static void main(String[] args) {
    ConfusingNumbersII c = new ConfusingNumbersII();
    int x = c.confusingNumberII(20);
  }

  public int confusingNumberII(int N) {
    Map<Integer, Integer> rotateMap = new HashMap<>();
    rotateMap.put(0, 0);
    rotateMap.put(1, 1);
    rotateMap.put(6, 9);
    rotateMap.put(8, 8);
    rotateMap.put(9, 6);


    List<Integer> digits = new ArrayList<>();
    int n = N;
    int k = -1;
    while (n > 0) {
      int rem = n % 10;
      digits.add(rem);
      n /= 10;
      k += 1;
    }
    Set<Integer> temp = new HashSet<>();
    int p = 0;
    for (int i = k; i >= 0; i--) {
      int w = digits.get(i);
      int base = (int) Math.pow(10, i);
      int q = w * base;
      for (int y : rotateMap.keySet()) {
        if (p + y * base <= N) {
          p += y * base;
          List<Integer> temp2 = new ArrayList<>();
          for (int x : temp) {
            int z = x + p;
            temp2.add(z);
          }
          temp.addAll(temp2);

          temp.add(p);
        } else {
          break;
        }
      }
    }
    int count = 0;
    for (int x : temp) {
      int r = rotate(rotateMap, x);
      if (x != r) {
        count++;
      }
    }
    return count;
  }

  private int rotate(Map<Integer, Integer> map, int n) {
    List<Integer> digits = new ArrayList<>();
    int k = -1;
    while (n > 0) {
      int rem = n % 10;
      digits.add(map.get(rem));
      n /= 10;
      k += 1;
    }
    int res = 0;
    int base = (int) Math.pow(10, k);
    for (int i = k, j = 0; i >= 0; i--, j++) {
      res += base * digits.get(j);
      base /= 10;
    }
    return res;
  }
}
