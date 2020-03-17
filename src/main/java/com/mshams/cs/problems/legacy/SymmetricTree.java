package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.TreeNode;

public class SymmetricTree extends Problem {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left != null && right != null) {
      return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    return false;
  }

  @Override
  void run() {
    System.out.println(isSymmetric(TreeNode.fromArray(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    System.out.println(isSymmetric(TreeNode.fromArray(new Integer[]{1, 2, 2, null, 3, null, 3})));
  }
}
