package com.mshams.cs.problems.legacy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingInt {
  public static int missing(List<Integer> a, int size) {
    for (int i = 0; i < size; i++) {
      int ind = Math.abs(a.get(i)) - 1;
      if (Math.abs(a.get(i)) - 1 < size && a.get(Math.abs(a.get(i)) - 1) > 0) {
        a.set(Math.abs(a.get(i)) - 1, -a.get(Math.abs(a.get(i)) - 1));

      }
    }
    for (int i = 0; i < size; i++) {
      if (a.get(i) > 0) {
        return i + 1;
      }

    }
    return size + 1;
  }

  public static void main(String[] args) {
    int[] arr = {3, 4, -1, 1};
    FindMissingInt solution = new FindMissingInt();
    int missing = solution.firstMissingPositive(IntStream.of(arr).boxed().collect(Collectors.toList()));
    System.out.println(missing);
  }

  public int firstMissingPositive(List<Integer> arr) {
    int pindex = 0;
    int pivot = 0;
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) > pivot) {
        int temp = arr.get(i);
        arr.set(i, arr.get(pindex));
        arr.set(pindex, temp);
        pindex++;
      }
    }
    return missing(arr, pindex);
/*		System.out.println(pindex);
		for(int i=0; i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		return 1;*/
  }
}
