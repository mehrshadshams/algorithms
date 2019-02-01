package com.mshams.cs.algs4;

public interface Stack<Item> extends Iterable<Item> {
    void push(Item item);

    Item pop();

    Item peek();

    boolean isEmpty();

    int size();
}
