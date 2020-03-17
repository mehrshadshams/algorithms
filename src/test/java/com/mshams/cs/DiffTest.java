package com.mshams.cs;

import com.mshams.cs.problems.Diff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiffTest {
  @Test
  public void test1() {
    Diff diffUtil = new Diff();

    String diff = diffUtil.diff("XMJYAUZ", "AXMJAATZ");

    Assertions.assertEquals(" +A X M J -Y A -U +A +T Z", diff);
  }
}
