package com.mshams.cs.problems.leetcode;

public class RankIntStream {
  private RankNode root = null;

  public void track(int x) {
    if (root == null) {
      root = new RankNode(x);
    } else {
      root.insert(x);
    }
  }

  public int findRank(int x) {
    return root.rank(x);
  }

  private class RankNode {
    private RankNode left, right;
    private int data;
    private int size = 0;

    RankNode(int data) {
      this.data = data;
    }

    int rank(int x) {
      return rank(root, x);
    }

    private int rank(RankNode node, int x) {
      if (node == null) return 0;
      if (x >= node.data) {
        return node.size - 1 - size(node.right);
      } else {
        return rank(node.left, x);
      }
    }

    void insert(int x) {
      if (x < data) {
        left = insert(left, x);
      } else {
        right = insert(right, x);
      }
      size = size(left) + size(right) + 1;
    }

    private RankNode insert(RankNode node, int x) {
      if (node == null) {
        return new RankNode(x);
      } else if (x < node.data) {
        node.left = insert(node.left, x);
        node.size += 1;
        return node;
      } else {
        node.right = insert(node.right, x);
        node.size += 1;
        return node;
      }
    }

    private int size(RankNode node) {
      return node == null ? 0 : node.size;
    }
  }
}
