package com.mshams.cs.problems.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 */
public class RearrangeKDistinct {
  public String rearrangeString(String s, int k) {
    Map<Character, Integer> lastIdx = new HashMap<>();
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : s.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq = new
            PriorityQueue<>((o1, o2) -> {
      int cmp = Integer.compare(o2.getValue(), o1.getValue());
      if (cmp == 0) {
        return Integer.compare(lastIdx.getOrDefault(o1.getKey(), -1),
                lastIdx.getOrDefault(o2.getKey(), -1));
      }
      return cmp;
    });
    pq.addAll(freq.entrySet());
    StringBuilder sb = new StringBuilder();
    int i = 0;
    Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> e = pq.poll();
      char c = e.getKey();
      int f = e.getValue();

      int last = lastIdx.getOrDefault(c, -1);
      if (last == -1 || i - last >= k) {
        sb.append(c);
        e.setValue(f - 1);
        lastIdx.put(c, i);
        i++;
      }

      if (e.getValue() > 0) {
        queue.add(e);
      }
      if (!queue.isEmpty()) {
        e = queue.peek();
        if (i - lastIdx.get(e.getKey()) >= k)
          pq.add(queue.poll());
      }
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }

  public static void main(String[] args) {
    RearrangeKDistinct sol = new RearrangeKDistinct();
    System.out.println(sol.rearrangeString("aabbcc", 3));
  }
}
