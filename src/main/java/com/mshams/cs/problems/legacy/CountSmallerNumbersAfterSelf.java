package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.List;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printList;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 * TODO
 */
public class CountSmallerNumbersAfterSelf extends Problem {

  public List<Integer> countSmaller(int[] nums) {
    List<Item> items = new ArrayList<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      items.add(new Item(nums[i], i));
    }

    List<Integer> out = new ArrayList<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      out.add(0);
    }

    sort(items, 0, items.size() - 1, out);

    return out;
  }

  void sort(List<Item> list, int start, int end, List<Integer> out) {
    if (start < end) {
      int mid = (start + end) / 2;

      sort(list, start, mid, out);
      sort(list, mid + 1, end, out);

      // merge
      int n1 = mid - start + 1;
      int n2 = end - mid;
      Item[] L = new Item[n1];
      Item[] R = new Item[n2];
      for (int i = 0; i < n1; i++) {
        L[i] = list.get(start + i);
      }
      for (int i = 0; i < n2; i++) {
        R[i] = list.get(mid + i + 1);
      }

      int i = 0;
      int j = 0;
      int k = start;

      while (i < n1 && j < n2) {
        if (L[i].number <= R[j].number) {
          list.set(k, L[i]);
          i++;
        } else {
          int index = L[i].index;
          out.set(index, out.get(index) + 1);
          list.set(k, R[j]);
          j++;
        }
        k++;
      }

      while (i < n1) {
        list.set(k, L[i]);
        i++;
        k++;
      }

      while (j < n2) {
        list.set(k, R[j]);

        j++;
        k++;
      }


    }
  }

  @Override
  void run() {
    printList(countSmaller(array(5, 2, 6, 1)));
  }

  class Item {
    int number;
    int index;

    Item(int num, int idx) {
      this.number = num;
      this.index = idx;
    }

    @Override
    public String toString() {
      return "Item{" + "number=" + number + ", index=" + index + '}';
    }
  }
}
