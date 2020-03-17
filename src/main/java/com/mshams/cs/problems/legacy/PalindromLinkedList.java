package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.ListNode;

import java.util.Queue;

public class PalindromLinkedList {
  public static void main(String[] args) {
    PalindromLinkedList p = new PalindromLinkedList();
    p.test();
  }

  public boolean isPalindrome(ListNode head) {
    int size = 0;
    ListNode node = head;
    while (node != null) {
      node = node.next;
      size++;
    }

    if (size == 0 || size == 1) {
      return true;
    }

    return isPalindrome(head, 0, size).palindrome;
  }

  private PalindromeNode isPalindrome(ListNode head, int index, int size) {
    if (size % 2 == 1) {
      if (index == size / 2) {
        return new PalindromeNode(head.next, true);
      }
    } else {
      if (index == (size - 1) / 2) {
        boolean isPalin = head.val == head.next.val;
        return new PalindromeNode(head.next.next, isPalin);
      }
    }

    PalindromeNode p = isPalindrome(head.next, index + 1, size);
    boolean t = (head.val == p.node.val) && p.palindrome;

    Queue<Integer> q;


    return new PalindromeNode(p.node.next, t);
  }

  public void test() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(1);

    System.out.println(isPalindrome(head));
  }

  private class PalindromeNode {
    public ListNode node;
    public boolean palindrome;

    public PalindromeNode(ListNode node, boolean p) {
      this.node = node;
      this.palindrome = p;
    }
  }
}
