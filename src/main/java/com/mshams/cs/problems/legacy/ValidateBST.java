package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.TreeNode;

@SuppressWarnings("Duplicates")
public class ValidateBST extends Problem {
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    boolean valid = isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return valid;
  }

  private boolean isValid(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;
    boolean valid = node.val > min && node.val < max;
    if (valid) {
      int max2 = min == Integer.MIN_VALUE ? node.val : Math.max(node.val, min);

      valid &= isValid(node.left, min, max2);
    }
    if (valid) {
      int min2 = max == Integer.MAX_VALUE ? node.val : Math.min(max, node.val);
      valid &= isValid(node.right, min2, max);
    }
    return valid;
  }

  @Override
  void run() {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//
//        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(20);
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    System.out.println(isValidBST(root));
  }
}
