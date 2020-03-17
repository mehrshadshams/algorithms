package com.mshams.cs.problems.leetcode;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class VerifyPreorderSerialization {
  public boolean isValidSerialization(String preorder) {
    String[] items = preorder.split(",");
    int slots = 1;
    for (String node : items) {
      --slots;
      if (slots < 0) return false;
      if (!node.equals("#")) slots += 2;
    }
    return slots == 0;
  }
}
