package com.mshams.cs.algs4.applications;

import java.util.LinkedList;

import com.mshams.cs.algs4.searching.RedBlackBST;
import com.mshams.cs.algs4.searching.ST;

public class LRUCache<Item extends Comparable<Item>> {
    private final ST<Item, Integer> st;
    private final LinkedList<Item> list;

    public LRUCache() {
        st = new RedBlackBST<>();
        list = new LinkedList<>();
    }

    public void put(Item key) {
        list.addLast(key);
        st.put(key, list.size() - 1);
    }

    public Item get(Item key) {
        if (!st.contains(key)) throw new IllegalArgumentException();
        int location = st.get(key);
        final Item value = list.remove(location);
        list.addFirst(value);
        return value;
    }

    public Item remove() {
        if (list.size() == 0) throw new IllegalArgumentException();
        Item item = list.removeLast();
        st.delete(item);
        return item;
    }
}
