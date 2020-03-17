package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.ListNode;

/**
 * TODO
 */
public class RemoveNthNodeFromEndOfList extends Problem {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    if (fast == null) {
      head = head.next;
    } else {
      while (fast != null) {
        fast = fast.next;
        if (fast == null) {
          slow.next = slow.next.next;
        } else {
          slow = slow.next;
        }
      }
    }

    return head;
  }

  @Override
  void run() {

  }
}
