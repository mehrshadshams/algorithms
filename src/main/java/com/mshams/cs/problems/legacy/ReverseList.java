package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.ListNode;

public class ReverseList extends Problem {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
//        ListNode n = reverseRecursive(head);
    ListNode n = reverseIterative(head);
    return n;
  }

  private ListNode reverseIterative(ListNode head) {
    ListNode current = head;
    ListNode prev = null;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  ListNode reverseRecursive(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode out = reverseRecursive(head.next);
    out.next = head;

    return out;
  }

  @Override
  void run() {
    ListNode root = new ListNode(1);
    ListNode current = root;
    for (int i = 2; i <= 5; i++) {
      current.next = new ListNode(i);
      current = current.next;
    }
    ListNode reverse = reverseList(root);
    while (reverse != null) {
      System.out.print(reverse.val + " , ");
      reverse = reverse.next;
    }
  }
}
