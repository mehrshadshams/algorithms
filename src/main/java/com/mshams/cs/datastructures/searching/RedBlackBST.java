package com.mshams.cs.datastructures.searching;

import org.apache.commons.lang3.NotImplementedException;

import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  @Override
  public Value get(Key key) {
    Node node = root;
    while (node != null) {
      int cmp = key.compareTo(node.key);
      if (cmp < 0)
        node = node.left;
      else if (cmp > 0)
        node = node.right;
      else
        return node.value;
    }
    return null;
  }

  @Override
  public void put(Key key, Value val) {
    root = put(root, key, val);
    root.color = BLACK;
  }

  @Override
  public void delete(Key key) {
    if (key == null)
      throw new IllegalArgumentException();
    if (!contains(key))
      return;

    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;

    root = delete(root, key);
    if (!isEmpty())
      root.color = BLACK;
  }

  @Override
  public boolean contains(Key key) {
    return get(key) != null;
  }

  @Override
  public int size() {
    return size(root);
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public Key min() {
    if (isEmpty())
      throw new NoSuchElementException("calls min() with empty symbol table");
    return min(root).key;
  }

  @Override
  public Key max() {
    if (isEmpty())
      throw new NoSuchElementException("calls min() with empty symbol table");
    return max(root).key;
  }

  @Override
  public Key ceiling(Key key) {
    throw new NotImplementedException("Not Implemented");
  }

  @Override
  public Key floor(Key key) {
    throw new NotImplementedException("Not Implemented");
  }

  @Override
  public int rank(Key key) {
    throw new NotImplementedException("Not Implemented");
  }

  @Override
  public Key select(int k) {
    throw new NotImplementedException("Not Implemented");
  }

  @Override
  public void deleteMin() {
    if (isEmpty())
      throw new NoSuchElementException();
    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;

    root = deleteMin(root);
    if (!isEmpty())
      root.color = BLACK;
  }

  @Override
  public void deleteMax() {
    if (isEmpty())
      throw new NoSuchElementException();

    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;

    root = deleteMax(root);
    if (!isEmpty())
      root.color = BLACK;
  }

  @Override
  public int size(Key lo, Key hi) {
    if (contains(hi))
      return rank(hi) - rank(lo) + 1;
    else
      return rank(hi) - rank(lo);
  }

  private Node put(Node x, Key key, Value value) {
    if (x == null)
      return new Node(key, value, RED, 1);

    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      x.left = put(x.left, key, value);
    else if (cmp > 0)
      x.right = put(x.right, key, value);
    else
      x.value = value;

    if (isRed(x.right) && !isRed(x.left))
      x = rotateLeft(x);
    if (isRed(x.left) && isRed(x.left.left))
      x = rotateRight(x);
    if (isRed(x.left) && isRed(x.right))
      flipColors(x);

    x.size = size(x.left) + size(x.right) + 1;

    return x;
  }

  private int size(Node node) {
    if (node == null)
      return 0;
    return 1 + size(node.left) + size(node.right);
  }

  private Node min(Node x) {
    if (x.left == null)
      return x;
    return min(x.left);
  }

  private Node max(Node x) {
    if (x.right == null)
      return x;
    return max(x.right);
  }

  private Node delete(Node h, Key key) {
    if (key.compareTo(h.key) < 0) {
      if (!isRed(h.left) && !isRed(h.left.left))
        h = moveRedLeft(h);
      h.left = delete(h.left, key);
    } else {
      if (isRed(h.left))
        h = rotateRight(h);
      if (key.compareTo(h.key) == 0 && (h.right == null))
        return null;
      if (!isRed(h.right) && !isRed(h.right.left))
        h = moveRedRight(h);
      if (key.compareTo(h.key) == 0) {
        Node x = min(h.right);
        h.key = x.key;
        h.value = x.value;
        // h.val = get(h.right, min(h.right).key);
        // h.key = min(h.right).key;
        h.right = deleteMin(h.right);
      } else
        h.right = delete(h.right, key);
    }
    return balance(h);
  }

  private void flipColors(Node node) {
    node.left.color = !node.left.color;
    node.right.color = !node.right.color;
    node.color = !node.color;
  }

  private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = x.right.color;
    x.size = size(x.left) + size(x.right) + 1;
    h.size = size(h.left) + size(h.right) + 1;

    return x;
  }

  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = x.left.color;
    x.left.color = RED;
    h.size = size(h.left) + size(h.right) + 1;
    return x;
  }

  private boolean isRed(Node node) {
    return node != null ? node.color == RED : BLACK;
  }

  private Node deleteMin(Node h) {
    if (h.left == null)
      return null;
    if (!isRed(h.left) && !isRed(h.left.left))
      h = moveRedLeft(h);
    h.left = deleteMin(h.left);
    return balance(h);
  }

  private Node moveRedLeft(Node h) {
    flipColors(h);
    if (isRed(h.right.left)) {
      h.right = rotateRight(h.right);
      h = rotateLeft(h);
      flipColors(h);
    }
    return h;
  }

  private Node deleteMax(Node h) {
    if (isRed(h.left))
      h = rotateRight(h);

    if (h.right == null)
      return null;

    if (!isRed(h.right) && !isRed(h.right.left))
      h = moveRedRight(h);

    h.right = deleteMax(h.right);

    return balance(h);
  }

  private Node moveRedRight(Node h) {
    flipColors(h);
    if (isRed(h.left.left)) {
      h = rotateRight(h);
      flipColors(h);
    }
    return h;
  }

  private Node balance(Node h) {
    if (isRed(h.right))
      h = rotateLeft(h);
    if (isRed(h.left) && isRed(h.left.left))
      h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right))
      flipColors(h);

    h.size = 1 + size(h.left) + size(h.right);
    return h;
  }

  private class Node {
    private Key key;
    private Value value;
    private Node left, right;
    private boolean color;
    private int size;

    public Node(Key key, Value value, boolean color, int size) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.size = size;
    }
  }
}
