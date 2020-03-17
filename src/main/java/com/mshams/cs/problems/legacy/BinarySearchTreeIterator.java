package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreeIterator extends Problem {

  @Override
  void run() {
    TreeNode node = TreeNode.fromArray(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
    BSTIterator it = new BSTIterator(node);
    while (it.hasNext()) {
      print(it.next().val);
    }
  }

  class BSTIterator implements Iterator<TreeNode> {

    private final TreeNode root;
    private Stack<TreeNode> stack = new Stack<>();

    BSTIterator(TreeNode root) {
      this.root = root;
      initalize(root);
    }

    @Override
    public boolean hasNext() {
      return stack.size() > 0;
    }

    @Override
    public TreeNode next() {
      TreeNode node = stack.pop();
      if (node.left == null && node.right == null) {
        return node;
      } else if (node.right != null) {
        initalize(node.right);
        return node;
      } else {
        return node;
      }
    }

    private void initalize(TreeNode node) {
      if (node == null) return;
      stack.push(node);
      initalize(node.left);
    }
  }
}
