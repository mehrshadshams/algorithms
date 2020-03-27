package com.mshams.cs.problems.leetcode;

import com.mshams.cs.problems.domain.TreeNode;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class RecoverBST {
  TreeNode pred = null, x = null, y = null;

  public void recoverTree(TreeNode root) {
    find(root);
    swapValues(x, y);
  }

  void find(TreeNode n) {
    if (n == null) return;
    find(n.left);
    if (pred != null && n.val < pred.val) {
      y = n;
      if (x == null) x = pred;
      else return;
    }
    pred = n;
    find(n.right);
  }

  void swapValues(TreeNode a, TreeNode b) {
    int t = a.val;
    a.val = b.val;
    b.val = t;
  }
}
