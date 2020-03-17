package com.mshams.cs.problems.legacy;

import java.util.LinkedList;
import java.util.List;

public class DesignHitCounters extends Problem {
  private List<Node> nodes = new LinkedList<>();

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    Node lastNode = nodes.size() > 0 ? nodes.get(nodes.size() - 1) : null;
    if (lastNode == null) {
      nodes.add(new Node(timestamp, 1));
    } else {
      if (lastNode.timestamp == timestamp) {
        lastNode.hits += 1;
      } else {
        Node first = find(timestamp - 300);
        nodes.add(new Node(timestamp, lastNode.hits + 1 - first.hits));
      }
    }
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    Node current = find(timestamp);
    return current.hits;
  }

  private Node find(int ts) {
    if (ts <= 0 || nodes.size() == 0) {
      return new Node(ts, 0);
    }
    Node node = nodes.get(0);
    for (int i = 1; i < nodes.size(); i++) {
      Node current = nodes.get(i);
      if (current.timestamp > ts) {
        break;
      }
      node = current;
    }
    return node;
  }

  @Override
  void run() {
    DesignHitCounters hitCounters = new DesignHitCounters();
    hitCounters.hit(1);
    hitCounters.hit(2);
    hitCounters.hit(3);
    print(hitCounters.getHits(4));
    hitCounters.hit(300);
    print(hitCounters.getHits(300));
    print(hitCounters.getHits(301));
  }

  class Node {
    int timestamp;
    int hits;

    Node(int ts, int h) {
      this.timestamp = ts;
      this.hits = h;
    }
  }
}
