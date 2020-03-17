package com.mshams.cs.problems.legacy;

public class CustomLinkedList {

  static boolean hasCycle(SinglyLinkedListNode head) {
    if (head == null) {
      return false;
    }

    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast || (slow != null && fast != null && slow.data == fast.data)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insertNode(1);
    list.insertNode(1);
    list.insertNode(3);
    list.insertNode(1);
    list.insertNode(2);
    list.insertNode(3);

    System.out.println(hasCycle(list.head));
  }

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }
}
