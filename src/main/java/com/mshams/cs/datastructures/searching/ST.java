package com.mshams.cs.datastructures.searching;

import java.util.NoSuchElementException;

public interface ST<Key extends Comparable<Key>, Value> {
  /**
   * Returns the value associated with the given key in this symbol table.
   *
   * @param key the key
   * @return the value associated with the given key if the key is in this symbol table;
   * {@code null} if the key is not in this symbol table
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  Value get(Key key);

  /**
   * Inserts the specified key-value pair into the symbol table, overwriting the old
   * value with the new value if the symbol table already contains the specified key.
   * Deletes the specified key (and its associated value) from this symbol table
   * if the specified value is {@code null}.
   *
   * @param key the key
   * @param val the value
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  void put(Key key, Value val);

  /**
   * Removes the specified key and its associated value from this symbol table
   * (if the key is in this symbol table).
   *
   * @param key the key
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  void delete(Key key);

  /**
   * Returns true if this symbol table contain the given key.
   *
   * @param key the key
   * @return {@code true} if this symbol table contains {@code key} and
   * {@code false} otherwise
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  boolean contains(Key key);

  /**
   * Returns the number of key-value pairs in this symbol table.
   *
   * @return the number of key-value pairs in this symbol table
   */
  int size();

  /**
   * Returns true if this symbol table is empty.
   *
   * @return {@code true} if this symbol table is empty and {@code false} otherwise
   */
  boolean isEmpty();

  /**
   * Returns the smallest key in this symbol table.
   *
   * @return the smallest key in this symbol table
   */
  Key min();

  /**
   * Returns the largest key in this symbol table.
   *
   * @return the largest key in this symbol table
   * @throws NoSuchElementException if this symbol table is empty
   */
  Key max();

  /**
   * Returns the smallest key in this symbol table greater than or equal to {@code key}.
   *
   * @param key the key
   * @return the smallest key in this symbol table greater than or equal to {@code key}
   * @throws NoSuchElementException   if there is no such key
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  Key ceiling(Key key);

  /**
   * Returns the largest key in this symbol table less than or equal to {@code key}.
   *
   * @param key the key
   * @return the largest key in this symbol table less than or equal to {@code key}
   * @throws NoSuchElementException   if there is no such key
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  Key floor(Key key);

  int rank(Key key);

  Key select(int k);

  void deleteMin();

  void deleteMax();

  int size(Key lo, Key hi);
}
