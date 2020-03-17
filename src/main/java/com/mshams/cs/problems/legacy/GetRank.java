package com.mshams.cs.problems.legacy;

import java.util.Arrays;

public class GetRank extends Problem {

  private RankNode root;

  public void add(int number) {
    RankNode node = new RankNode(number);
    if (root == null) {
      root = node;
    } else {
      root.add(node);
    }
  }

  public int getRank(int number) {
    RankNode node = find(root, number);
    return node == null ? -1 : node.getRank();
  }

  RankNode find(RankNode node, int n) {
    if (root == null)
      return null;
    if (root.data == n)
      return root;
    if (n < root.data)
      return find(node.left, n);

    return find(node.right, n);
  }

  @Override
  void run() {
    Arrays.asList(5, 1, 4, 4, 5, 9, 7, 13, 3).forEach(this::add);
    System.out.println(getRank(5));
  }

  class RankNode {
    int data;

    RankNode left;
    RankNode right;
    int leftSize;

    public RankNode(int number) {
      data = number;
    }

    void add(RankNode node) {
      if (node.data < data) {
        leftSize++;
        if (left == null) {
          left = node;
        } else {
          left.add(node);
        }
      } else {
        if (node.data == data) {
          leftSize++;
        }

        if (right == null) {
          right = node;
        } else {
          right.add(node);
        }
      }
    }

    int getRank() {
      return leftSize;
    }
  }
}
