package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.TreeNode;

/**
 * https://leetcode.com/explore/featured/card/google/67/sql-2/473/
 */
public class LongestUnivaluePath extends Problem {
  public int longestUnivaluePath(TreeNode root) {
    return longestUnivaluePath(root, null, 0);
  }

  private int longestUnivaluePath(TreeNode node, TreeNode parent, int max) {
    if (node == null) {
      return max;
    }

    int currentMax = max;

    if (parent == null) {
      currentMax = 1;
    } else if (node.val == parent.val) {
      currentMax = max + 1;
    } else {
      currentMax = 1;
    }

    int max2 = Math.max(longestUnivaluePath(node.left, node, currentMax), longestUnivaluePath(node.right, node, currentMax));

    return Math.max(max2, currentMax);
  }

  @Override
  void run() {
    Integer[] values = new Integer[]{1, 4, 5, 4, 4, 5};
    // values = new Integer[]{5,4,5,1,1,null,5}
    final TreeNode root = TreeNode.fromArray(values);
    System.out.println(longestUnivaluePath(root));
  }
}
