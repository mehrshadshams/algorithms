package com.mshams.cs.algs4;

import com.mshams.cs.algs4.problems.Remove;
import org.junit.jupiter.api.Test;

public class RemoveTests {
    @Test
    void test1() {
        Remove remove = new Remove();

        remove.withoutString("This is a FISH", "IS");
    }
}
