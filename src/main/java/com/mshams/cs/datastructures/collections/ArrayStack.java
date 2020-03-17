package com.mshams.cs.datastructures.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayStack<Item> implements Stack<Item> {
  private Object[] objects;
  private int current;

  public ArrayStack() {
    objects = new Object[10];
    current = 0;
  }

  @Override
  public void push(Item item) {
    if (item == null)
      throw new IllegalArgumentException();
    if (current == objects.length) {
      resize(objects.length * 2);
    }

    objects[current++] = item;
  }

  @Override
  public Item pop() {
    if (isEmpty())
      throw new NoSuchElementException();
    Item value = (Item) objects[current - 1];
    objects[current] = null;
    current--;
    if (current > 0 && current == objects.length / 4) {
      resize(objects.length / 2);
    }
    return value;
  }

  @Override
  public Item peek() {
    if (isEmpty())
      throw new NoSuchElementException();
    return (Item) objects[current - 1];
  }

  @Override
  public boolean isEmpty() {
    return current == 0;
  }

  @Override
  public int size() {
    return current;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayStackIterator();
  }

  private void resize(int newSize) {
    Object[] temp = new Object[newSize];
    for (int i = 0; i < current; i++) {
      temp[i] = objects[i];
    }
    objects = temp;
  }

  private class ArrayStackIterator implements Iterator<Item> {
    private int pointer = current;

    @Override
    public boolean hasNext() {
      return pointer >= 0;
    }

    @Override
    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      return (Item) objects[pointer--];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
