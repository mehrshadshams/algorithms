package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://codelab.interviewbit.com/problems/primesum/
 */
public class PrimeSum extends Problem {
  public ArrayList<Integer> primesum(int a) {
    int[] primes = getPrimes(a);
    ArrayList<Integer> out = new ArrayList<>();
    for (int i = 0; i < primes.length; i++) {
      if (primes[i] == 1) {
        int j = a - i;
        if (primes[j] == 1) {
          out.add(i);
          out.add(j);
          break;
        }
      }
    }
    return out;
  }

  private int[] getPrimes(int a) {
    int[] nums = new int[a + 1];
    Arrays.fill(nums, 1);

    nums[0] = 0;
    nums[1] = 0;
    for (int i = 2; i < Math.sqrt(a); i++) {
      if (nums[i] == 1) {
        for (int j = 2; i * j < a; j++) {
          nums[i * j] = 0;
        }
      }
    }

    return nums;
  }

  @Override
  void run() {

  }
}
