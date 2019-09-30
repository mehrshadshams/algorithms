package com.mshams.cs;

import com.google.common.collect.Lists;
import com.mshams.cs.datastructures.collections.ArrayDequeue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayDequeueTests {
    @Test
    void test_add_last_works() {
        ArrayDequeue<Integer> dequeue = new ArrayDequeue<>();
        for (int i = 0; i < 5; i++) {
            dequeue.addLast(i);
        }

        List<Integer> list = Lists.newArrayList(dequeue.iterator());

        Assertions.assertEquals(5, list.size());
        Assertions.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, list.toArray(new Integer[0]));
    }

    @Test
    void test_add_first_works() {
        ArrayDequeue<Integer> dequeue = new ArrayDequeue<>();
        for (int i = 0; i < 5; i++) {
            dequeue.addFirst(i);
        }

        List<Integer> list = Lists.newArrayList(dequeue.iterator());

        Assertions.assertEquals(5, list.size());
        Assertions.assertArrayEquals(new Integer[]{4, 3, 2, 1, 0}, list.toArray(new Integer[0]));
    }

    @Test
    void test_add_works() {
        ArrayDequeue<Integer> dequeue = addAlternate(10);

        List<Integer> list = Lists.newArrayList(dequeue.iterator());

        Assertions.assertEquals(10, list.size());
        Assertions.assertArrayEquals(new Integer[]{8, 6, 4, 2, 0, 1, 3, 5, 7, 9}, list.toArray(new Integer[0]));
    }

    @Test
    void test_delete_works() {
        final int size = 10;

        ArrayDequeue<Integer> dequeue = addAlternate(size);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                list.add(dequeue.deleteFirst());
            } else {
                list.add(dequeue.deleteLast());
            }
        }

        Assertions.assertTrue(dequeue.isEmpty());
        Assertions.assertEquals(10, list.size());
        Assertions.assertArrayEquals(new Integer[]{8, 9, 6, 7, 4, 5, 2, 3, 0, 1}, list.toArray(new Integer[0]));
    }

    @Test
    void test_delete_first_works() {
        ArrayDequeue<Integer> dequeue = addAlternate(10);

        int first = dequeue.deleteFirst();

        Assertions.assertEquals(9, dequeue.size());
        Assertions.assertEquals(8, first);
    }

    @Test
    void test_delete_last_works() {
        ArrayDequeue<Integer> dequeue = addAlternate(10);

        int last = dequeue.deleteLast();

        Assertions.assertEquals(9, dequeue.size());
        Assertions.assertEquals(9, last);
    }

    private ArrayDequeue<Integer> addAlternate(int size) {
        ArrayDequeue<Integer> dequeue = new ArrayDequeue<>();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                dequeue.addFirst(i);
            } else {
                dequeue.addLast(i);
            }
        }
        return dequeue;
    }
}
