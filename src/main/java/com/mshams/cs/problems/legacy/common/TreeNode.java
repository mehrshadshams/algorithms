package com.mshams.cs.problems.legacy.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public static TreeNode fromArray(Integer[] arr) {
    TreeNode root = new TreeNode(arr[0]);
    List<TreeNode> nodes = new ArrayList<>();
    nodes.add(root);
    for (int i = 1; i < arr.length; i++) {
      Integer value = arr[i];
      TreeNode parent = nodes.get((i - 1) / 2);
      if (value != null) {
        TreeNode newNode = new TreeNode(value);
        nodes.add(newNode);
        if (i % 2 == 1) {
          parent.left = newNode;
        } else {
          parent.right = newNode;
        }
      }
    }
    return root;
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }
}
