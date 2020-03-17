package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.ListNode;

public class LinkedListCycle extends Problem {

  public boolean hasCycle(ListNode head) {
    boolean hasCycle = false;

    ListNode walker = head;
    ListNode runner = head;
    while (!hasCycle && walker != null && runner != null && runner.next != null) {
      walker = walker.next;
      runner = runner.next.next;
      hasCycle = walker == runner;
    }

    return hasCycle;
  }

  @Override
  void run() {

  }
}
