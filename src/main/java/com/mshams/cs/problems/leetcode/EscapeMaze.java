package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.*;

/**
 * https://leetcode.com/problems/escape-a-large-maze/
 * <p>
 * In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
 * <p>
 * We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
 * <p>
 * Return true if and only if it is possible to reach the target square through a sequence of moves.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * Output: false
 * Explanation:
 * The target square is inaccessible starting from the source square, because we can't walk outside the grid.
 * Example 2:
 * <p>
 * Input: blocked = [], source = [0,0], target = [999999,999999]
 * Output: true
 * Explanation:
 * Because there are no blocked cells, it's possible to reach the target square.
 */
@Complexity(ComplexityLevel.HARD)
public class EscapeMaze {
  static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int size = 1_000_000;

  public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    Set<Long> blockedSet = new HashSet<>();
    for (int[] b : blocked) {
      blockedSet.add(hash(b[0], b[1]));
    }
    return !(isBlocked(blockedSet, source, target) || isBlocked(blockedSet, target, source));
  }

  private boolean isBlocked(Set<Long> blocks, int[] source, int[] target) {
    Queue<Position> pq = new LinkedList<>();
    int sx = source[0], sy = source[1];
    int tx = target[0], ty = target[1];
    pq.add(new Position(sx, sy));
    Set<Long> visited = new HashSet<>();

    int n = blocks.size();
    int area = n * n / 2;

    while (!pq.isEmpty()) {
      Position next = pq.poll();
      if (next.x == tx && next.y == ty || visited.size() > area) {
        return false;
      }

      visited.add(hash(next.x, next.y));

      for (int[] d : directions) {
        int dx = d[0], dy = d[1];
        int x2 = next.x + dx, y2 = next.y + dy;
        if (x2 >= 0 && x2 < size && y2 >= 0 && y2 < size && !blocks.contains(hash(x2, y2)) &&
                !visited.contains(hash(x2, y2))) {
          Position p2 = new Position(x2, y2);
          pq.add(p2);
        }
      }
    }

    return true;
  }

  private long hash(int x, int y) {
    return x + 1000000 * y;
  }

  private class Position {
    private int x;
    private int y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (this == obj) return true;
      if (!(obj instanceof Position)) return false;
      Position p = (Position) obj;
      return x == p.x && y == p.y;
    }
  }
}
