package com.mshams.cs;

import com.mshams.cs.applications.QuickUnionUF;
import com.mshams.cs.applications.UF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnionUFTests {

    @Test
    void test_each_item_is_connected_to_self() {
        UF uf = new QuickUnionUF(10);

        Assertions.assertTrue(uf.connected(3, 3));
        Assertions.assertFalse(uf.connected(3, 4));
    }

    @Test
    void test_Unions_works() {
        UF uf = new QuickUnionUF(10);
        uf.union(4, 3);

        Assertions.assertTrue(uf.connected(4, 3));
        Assertions.assertTrue(uf.connected(3, 4));
    }

    @Test
    void test_Unions_works_multiple() {
        UF uf = new QuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);

        Assertions.assertTrue(uf.connected(3, 8));
        Assertions.assertTrue(uf.connected(4, 8));
    }
}
