package com.mshams.cs.datastructures.collections;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class RandomizedQueue<Item> {
    //private final LinkedList<Item> list;
    private int counter;
    private Item[] list;

    public RandomizedQueue() {
        //list = new LinkedList<>();
        list = (Item[]) new Object[10];
    }

    public void push(Item item) {
        // resize
        list[counter++] = item;
        // list.addLast(item);
    }

    public Item pop() {
        int r = new Random(System.currentTimeMillis()).nextInt(counter);
        Item item = list[r];
        ArrayUtils.swap(list, r, counter);
        list[counter--] = null;
        return item;
    }
}
