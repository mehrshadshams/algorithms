package com.mshams.cs.problems.leetcode;

import com.mshams.cs.problems.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
// * https://leetcode.com/problems/two-sum-bsts/
 * <p>
 * Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Each tree has at most 5000 nodes.
 * -10^9 <= target, node.val <= 10^9
 */
public class TwoSumBST {
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root1);
    while (!q.isEmpty()) {
      TreeNode next = q.poll();
      if (find(root2, target - next.val)) return true;
      if (next.left != null)
        q.add(next.left);
      if (next.right != null)
        q.add(next.right);
    }
    return false;
  }

  public boolean find(TreeNode node, int value) {
    while (node != null) {
      if (node.val == value) return true;
      if (value < node.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }
    return false;
  }
}
