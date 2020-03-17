package com.mshams.cs;

import com.mshams.cs.applications.Interval;
import com.mshams.cs.applications.IntervalSearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalSearchTests {
  @Test
  void test_interval_search() {
    IntervalSearchTree tree = createIntervalSearchTree();

    final Interval interval = tree.intersects(19, 20);

    Assertions.assertNotNull(interval);
  }

  private IntervalSearchTree createIntervalSearchTree() {
    IntervalSearchTree tree = new IntervalSearchTree();

    tree.put(16, 21);
    tree.put(8, 9);
    tree.put(25, 30);
    tree.put(5, 8);
    tree.put(17, 19);
    tree.put(26, 26);
    return tree;
  }
}
