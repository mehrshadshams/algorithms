package com.mshams.cs;

import com.mshams.cs.problems.MaximizeExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximizeExpressionTest {
  @Test
  public void test1() {
    int[] arr = {3, 9, 10, 1, 30, 40};

    MaximizeExpression maximizeExpression = new MaximizeExpression();

    int max = maximizeExpression.maximize(arr);

    Assertions.assertEquals(46, max);
  }
}
