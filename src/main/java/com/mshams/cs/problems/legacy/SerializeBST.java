package com.mshams.cs.problems.legacy;

import com.mshams.cs.problems.legacy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeBST extends Problem {
  public String serialize(TreeNode root) {
    if (root == null) {
      return "N";
    }
    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int lastNotNull = -1;
    int i = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        lastNotNull = i;
      }
      i++;
      list.add(serializeToStr(node));
      if (node != null) {
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }
    return String.join(",", list.subList(0, lastNotNull + 1));
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] items = data.split(",");
    TreeNode root = getNode(items, 0);
    if (root == null) return root;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    deserialize(queue, items, 1);
    return root;
  }

  TreeNode getNode(String[] items, int index) {
    if (index >= items.length) return null;
    String val = items[index];
    if ("N".equals(val)) return null;
    return new TreeNode(Integer.valueOf(val));
  }

  private void deserialize(Queue<TreeNode> queue, String[] items, int index) {
    if (index >= items.length) {
      return;
    }

    if (queue.size() == 0) {
      return;
    }

    TreeNode next = queue.poll();

    TreeNode left = getNode(items, index);
    TreeNode right = getNode(items, index + 1);

    next.left = left;
    next.right = right;

    if (left != null) {
      queue.offer(left);
    }
    if (right != null) {
      queue.offer(right);
    }

    deserialize(queue, items, index + 2);
  }

  private String serializeToStr(TreeNode node) {
    if (node == null) return "N";
    return String.valueOf(node.val);
  }

  @Override
  void run() {
    TreeNode node = TreeNode.fromArray(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
    String s = serialize(node);
    print(s);
    TreeNode node2 = deserialize(s);
    print(serialize(node2));
  }
}
