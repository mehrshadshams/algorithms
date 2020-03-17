package com.mshams.cs.problems.legacy;

public class LinkedListPalindrome extends Problem {

  Result recurse(CustomLinkedList.SinglyLinkedListNode head, int length) {
    if (length == 0) {
      return new Result(head.data, false);
    } else if (length == 1) {
      return new Result(head.data, true);
    }

    Result temp = recurse(head.next, length - 2);
    if (!temp.palin) {
      return temp;
    }

    return new Result(head.data, head.data == temp.value);
  }

  @Override
  void run() {
    CustomLinkedList.SinglyLinkedList list = new CustomLinkedList.SinglyLinkedList();
    list.insertNode(0);
    list.insertNode(1);
    list.insertNode(2);
    list.insertNode(2);
    list.insertNode(0);

    Result res = recurse(list.head, 5);

    System.out.println(res.palin);
  }

  class Result {
    int value;
    boolean palin;

    Result(int value, boolean palin) {
      this.value = value;
      this.palin = palin;
    }
  }
}
