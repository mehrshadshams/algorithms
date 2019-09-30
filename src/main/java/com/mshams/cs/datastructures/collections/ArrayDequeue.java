package com.mshams.cs.datastructures.collections;

import java.util.Iterator;

@SuppressWarnings("Duplicates")
public class ArrayDequeue<Item> implements Iterable<Item> {
    private Item[] array;
    private int head;
    private int tail;
    private int size;

    public ArrayDequeue() {
        array = (Item[]) new Object[1];
        head = -1;
        tail = 0;
    }

    public void addFirst(Item item) {
        if (size == array.length) {
            resize(array.length * 2);
        }

        if (head == -1) {
            head = 0;
            tail = 0;
        } else if (head == 0) {
            head = array.length - 1;
        } else {
            head--;
        }

        array[head] = item;

        size++;
    }

    public void addLast(Item item) {
        if (size == array.length) {
            resize(array.length * 2);
        }

        if (head == -1) {
            head = 0;
            tail = 0;
        } else if (tail == array.length - 1) {
            tail = 0;
        } else {
            tail++;
        }

        array[tail] = item;

        size++;
    }

    public Item deleteFirst() {
        if (size == 0)
            throw new IllegalStateException("Underflow");
        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        Item item = array[head];

        array[head] = null;

        if (head == array.length - 1) {
            head = 0;
        } else {
            head++;
        }

        size--;

        return item;
    }

    public Item deleteLast() {
        if (size == 0)
            throw new IllegalStateException("Underflow");
        if (size == array.length / 4) {
            resize(array.length / 2);
        }

        Item item = array[tail];
        array[tail] = null;

        if (tail == 0) {
            tail = array.length - 1;
        } else {
            tail--;
        }

        size--;

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeueIterator();
    }

    private void resize(int newSize) {
        Item[] arr = (Item[]) new Object[newSize];
        int i = (arr.length - size) / 2;
        int newHead = i;
        for (Item item : this) {
            arr[i++] = item;
        }
        array = arr;
        head = newHead;
        tail = i - 1;
    }

    private class DequeueIterator implements Iterator<Item> {
        private int index;
        private int count;

        DequeueIterator() {
            index = head > 0 ? head : size + head;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size();
        }

        @Override
        public Item next() {
            if (index == array.length)
                index = 0;
            Item item = array[index++];
            count++;
            return item;
        }
    }
}
