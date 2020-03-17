package com.mshams.cs.datastructures.searching;

public class BTree<Key extends Comparable<Key>, Value> {
  private static final int M = 4;

  private Node root = new Node();

  public BTree() {
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node n, Key key, Value value) {
    int i = 0;
    for (; i < n.cells.length; i++) {
      Entry c = n.cells[i];
      if (c != null) {
        if (less(key, c.key)) {
          if (c.next != null) {
            c.next = put(c.next, key, value);
          } else {
            // insert here
            for (int j = n.cells.length - 1; j > i; j--) {
              n.cells[j] = n.cells[j - 1];
            }
            n.cells[i] = new Entry(key, value);
            n.count++;
            break;
          }
          break;
        } else if (eq(key, c.key)) {
          c.value = value;
          return n;
        }
      } else {
        n.cells[i] = new Entry(key, value);
        n.count++;
        break;
      }
    }
    if (n.count == M) {
      return splitNode(n);
    }

    return n;
  }

  private Node splitNode(Node n) {
    Node left = new Node();
    Node right = new Node();
    for (int i = 1, j = 0; i < n.cells.length / 2; i++, j++) {
      left.cells[j] = n.cells[i];
      left.count++;
    }
    for (int i = n.cells.length / 2 + 1, j = 0; i < n.cells.length; i++, j++) {
      right.cells[j] = n.cells[i];
      right.count++;
    }

    n.cells[0].next = left;
    n.cells[1] = n.cells[n.cells.length / 2];
    n.cells[1].next = right;
    n.count = 2;

    for (int i = 2; i < n.cells.length; i++) {
      n.cells[i] = null;
    }

    return n;
  }

  private boolean less(Comparable k1, Comparable k2) {
    return k1.compareTo(k2) < 0;
  }

  private boolean eq(Comparable k1, Comparable k2) {
    return k1.compareTo(k2) == 0;
  }

  private static class Entry {
    private Comparable key;
    private Object value;
    private Node next;

    public Entry(Comparable key, Object value) {
      this.key = key;
      this.value = value;
    }
  }

  @SuppressWarnings("unchecked")
  private static class Node {
    private int count;
    private Entry[] cells = new Entry[M];
  }
}
