package com.mshams.cs.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListComponentsTests {
  private static LinkedListComponents.ListNode createList(int... items) {
    LinkedListComponents.ListNode dummy = new LinkedListComponents.ListNode(-1);
    LinkedListComponents.ListNode head = dummy;
    for (int val : items) {
      dummy.next = new LinkedListComponents.ListNode(val);
      dummy = dummy.next;
    }

    return head.next;
  }

  @Test
  public void test1() {
    LinkedListComponents sol = new LinkedListComponents();

    LinkedListComponents.ListNode head = createList(0, 1, 2);

    int comp = sol.numComponents(head, new int[]{1, 0});

    Assertions.assertEquals(1, comp);
  }
}
