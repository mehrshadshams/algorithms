package com.mshams.cs;

import com.mshams.cs.problems.Remove;
import org.junit.jupiter.api.Test;

public class RemoveTests {
    @Test
    void test1() {
        Remove remove = new Remove();

        remove.withoutString("This is a FISH", "IS");
    }
}
