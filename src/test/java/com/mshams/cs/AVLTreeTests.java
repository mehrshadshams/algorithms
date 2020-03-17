package com.mshams.cs;

import com.mshams.cs.datastructures.searching.AVLTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AVLTreeTests {
  @Test
  void test_create_right_unbalanced() {
    AVLTree<Integer, Integer> avl = new AVLTree<>();

    avl.put(1, 1);
    avl.put(2, 2);
    avl.put(3, 3);

    Assertions.assertEquals(3, avl.size());
    Assertions.assertEquals(1, avl.height());
  }

  @Test
  void test_create_left_unbalanced() {
    AVLTree<Integer, Integer> avl = new AVLTree<>();

    avl.put(3, 3);
    avl.put(2, 2);
    avl.put(1, 1);

    Assertions.assertEquals(3, avl.size());
    Assertions.assertEquals(1, avl.height());
  }

  @Test
  void test_create_left_right_unbalanced() {
    AVLTree<Integer, Integer> avl = new AVLTree<>();

    avl.put(3, 3);
    avl.put(1, 1);
    avl.put(2, 2);

    Assertions.assertEquals(3, avl.size());
    Assertions.assertEquals(1, avl.height());
  }

  @Test
  void test_create_right_left_unbalanced() {
    AVLTree<Integer, Integer> avl = new AVLTree<>();

    avl.put(1, 1);
    avl.put(3, 3);
    avl.put(2, 2);

    Assertions.assertEquals(3, avl.size());
    Assertions.assertEquals(1, avl.height());
  }
}
