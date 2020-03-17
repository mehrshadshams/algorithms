package com.mshams.cs.applications;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LFUCache implements Cache {

  private final Cache cache;

  public LFUCache(int capacity) {
    cache = new LFUCacheDoubleLinkedList(capacity);
  }

  @Override
  public int get(int key) {
    return cache.get(key);
  }

  @Override
  public void put(int key, int value) {
    cache.put(key, value);
  }

  class LFUCacheDoubleLinkedList implements Cache {
    Map<Integer, ListNode> map;
    Map<Integer, ListNode> fMap;
    ListNode head, tail;
    int size, cap;

    public LFUCacheDoubleLinkedList(int capacity) {
      map = new HashMap<>();
      fMap = new HashMap<>();
      size = 0;
      cap = capacity;
    }

    public int get(int key) {
      if (cap < 1 || !map.containsKey(key)) return -1;
      ListNode node = map.get(key);
      int value = node.value;
      update(node);
      return value;
    }

    public void put(int key, int value) {
      if (cap < 1) return;
      ListNode node = map.get(key);
      if (node == null) {
        if (size < cap) {
          size++;
        } else {
          removeTail();
        }
        node = new ListNode(key, value);
        map.put(key, node);

        ListNode prevHead = fMap.get(1);
        fMap.put(1, node);
        if (prevHead != null) {
          node.prev = prevHead.prev;
          node.next = prevHead;
          if (node.prev == null) head = node;
          else node.prev.next = node;
          if (node.next == null) tail = node;
          else node.next.prev = node;
        } else {
          if (head == null) head = tail = node;
          else {
            tail.next = node;
            node.prev = tail;
            tail = node;
          }
        }
      } else {
        node.value = value;
        update(node);
      }
    }

    private void update(ListNode node) {
      int old = node.freq;
      int f = ++(node.freq);

      if (cap == 1) return;

      ListNode lowerFreqHead = fMap.get(old);
      ListNode currFreqPrevHead = fMap.get(f);
      fMap.put(f, node);

      if (lowerFreqHead == node) {
        lowerFreqHead = lowerFreqHead.next;
        if (lowerFreqHead == null || lowerFreqHead.freq != old) {
          fMap.remove(old);
        } else {
          fMap.put(old, lowerFreqHead);
        }
      }

      ListNode newPrev = currFreqPrevHead != null ? currFreqPrevHead.prev :
              (lowerFreqHead != null ? lowerFreqHead.prev : node.prev);
      ListNode newNext = currFreqPrevHead != null ? currFreqPrevHead : lowerFreqHead;

      if (node.prev != null) node.prev.next = node.next;
      else {
        return;
      }
      if (node.next != null) node.next.prev = node.prev;
      else {
        tail = tail.prev;
        tail.next = null;
      }

      if (newPrev == null) head = node;
      else newPrev.next = node;
      node.prev = newPrev;

      if (newNext == null) tail = node;
      else newNext.prev = node;
      node.next = newNext;
    }

    private void removeTail() {

      map.remove(tail.key);
      ListNode fHead = fMap.get(tail.freq);
      if (fHead == tail) {
        fMap.remove(tail.freq);
      }
      if (head == tail) head = tail = null;
      else {
        tail = tail.prev;
        tail.next = null;
      }
    }

    class ListNode {
      ListNode prev, next;
      int key, value, freq;

      ListNode(int k, int v) {
        key = k;
        value = v;
        freq = 1;
      }
    }
  }

  class LFUCachePriorityQueue implements Cache {
    private Map<Integer, Node> map;
    private PriorityQueue<Node> pq;
    private int cap;
    private int timer;

    LFUCachePriorityQueue(int capacity) {
      map = new HashMap<>();
      pq = new PriorityQueue<Node>(
              (a, b) -> (a.count == b.count ? (a.timer - b.timer) : (a.count - b.count)));
      cap = capacity;
      timer = 0;
    }

    private void remove(Node node) {
      map.remove(node.key);
      pq.remove(node);
    }

    private void add(Node node) {
      map.put(node.key, node);
      pq.offer(node);
    }

    public int get(int key) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        remove(node);
        add(new Node(node.key, node.val, node.count + 1, timer++));
        return node.val;
      } else return -1;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        remove(node);
        add(new Node(key, value, node.count + 1, timer++));
      } else {
        if (cap != 0) {
          if (map.size() == cap) remove(pq.peek());
          add(new Node(key, value, 1, timer++));
        }
      }
    }

    class Node {
      int key;
      int val;
      int count;
      int timer;

      public Node(int k, int v, int c, int t) {
        this.key = k;
        this.val = v;
        this.count = c;
        this.timer = t;
      }
    }
  }
}

