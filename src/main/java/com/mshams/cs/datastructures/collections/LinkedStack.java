package com.mshams.cs.datastructures.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Stack<Item> {

    private Node top;
    private int size;

    @Override
    public void push(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldTop = top;
        top = new Node(item);
        top.next = oldTop;
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = top.value;
        Node next = top.next;
        top.next = null;
        top = next;
        size--;
        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new IllegalArgumentException();
            Item item = current.value;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        private final Item value;
        private Node next;

        Node(Item value) {
            this.value = value;
        }
    }
}
