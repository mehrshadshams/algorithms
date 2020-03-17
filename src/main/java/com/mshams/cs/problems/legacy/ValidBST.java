package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.TreeNode;

public class ValidBST {
  public static void main(String[] args) {
    ValidBST validBST = new ValidBST();
    validBST.test();
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    Validity leftValid = isValidBST(root.left, Integer.MIN_VALUE, root.val - 1, false);
    Validity rightValid = isValidBST(root.right, root.val + 1, Integer.MAX_VALUE, true);

    return leftValid.valid && rightValid.valid;
  }

  private Validity isValidBST(TreeNode root, int min, int max, boolean right) {
    if (root == null) {
      return new Validity(true, right ? Integer.MAX_VALUE : Integer.MIN_VALUE);
    }

    boolean valid = root.val >= min && root.val <= max;

    if (valid) {
      int leftMin = Integer.MIN_VALUE;
      int leftMax = Integer.MAX_VALUE;
      int rightMin = Integer.MIN_VALUE;
      int rightMax = Integer.MAX_VALUE;

      if (right) {
        // right
        leftMax = root.val - 1;
        leftMin = min;
        rightMin = root.val + 1;
        rightMax = Integer.MAX_VALUE;
      } else {
        // left
        leftMax = root.val - 1;
        leftMin = Integer.MIN_VALUE;
        rightMax = max;
        rightMin = root.val + 1;
      }

      Validity leftValid = isValidBST(root.left, leftMin, leftMax, false);
      Validity rightValid = isValidBST(root.right, rightMin, rightMax, true);

      valid = leftValid.valid && rightValid.valid;
    }

    return new Validity(valid, root.val);
  }

  public void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);

    root.right = new TreeNode(5);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(6);

    System.out.println(isValidBST(root));
  }

  private class Validity {
    boolean valid;
    int value;

    Validity(boolean valid, int value) {
      this.valid = valid;
      this.value = value;
    }
  }
}
