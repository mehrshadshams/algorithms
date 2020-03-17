package com.mshams.cs.problems.leetcode;

import com.mshams.cs.problems.Extensions;
import com.mshams.cs.problems.domain.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class BstFromPreorder {
  public static void main(String[] args) {
    BstFromPreorder sol = new BstFromPreorder();
    TreeNode n = sol.bstFromPreorder(Extensions.array(4, 10, 7, 9, 11));

    System.out.println(n);
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder == null || preorder.length == 0) return null;
    TreeNode root = new TreeNode(preorder[0]);
    Stack<Insertion> stack = new Stack<>();
    stack.push(new Insertion(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    for (int i = 1; i < preorder.length; i++) {
      int x = preorder[i];
      TreeNode n = new TreeNode(x);

      Insertion y = stack.peek();
      int min = y.min;
      int max = y.max;

      if (x < y.node.val) {
        y.node.left = n;
        stack.push(new Insertion(n, Math.max(min, x), Math.min(max, y.node.val)));
      } else {
        while (!stack.isEmpty() && !y.canAddRight(x)) {
          y = stack.pop();
        }

        y.node.right = n;
        stack.push(new Insertion(n, x, Math.max(max, x)));
      }
    }
    return root;
  }

//    private TreeNode bst(int[] list, TreeNode p, int max, int min, int j) {
//        if (j >= list.length) return null;
//        int x = list[j];
//        TreeNode n = new TreeNode(x);
//        if (n.val < p.val) {
//            p.left = n;
//            n = bst(list, n, p.val, min, j + 1);
//        }
//        if (n.val > p.val && n.val < max) {
//            p.right = n;
//            n = bst(list, n, max, n.val, j + 1);
//        }
//        return n;
//    }

  private class Insertion {
    TreeNode node;
    Integer min;
    Integer max;

    Insertion(TreeNode n, Integer min, Integer max) {
      this.node = n;
      this.min = min;
      this.max = max;
    }

    boolean canAddRight(int val) {
      return val >= min && val < max;
    }

    @Override
    public String toString() {
      return "node=" + node.val + ",min=" + min + ",max=" + max;
    }
  }

  private class Traversal {
    TreeNode n;
    int x;

    Traversal(TreeNode n, int x) {
      this.n = n;
      this.x = x;
    }
  }
}