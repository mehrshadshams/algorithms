package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static com.mshams.cs.problems.legacy.Utils.array;

public class ShortestDistanceFromBuildings extends Problem {

  public int shortestDistance(int[][] grid) {
    int minDistance = Integer.MAX_VALUE;
    int m = grid.length;
    int n = grid[0].length;

    int[][] total = new int[m][n];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          minDistance = bfs(grid, total, i, j);
        }
      }
    }
    return minDistance;
  }

  private int bfs(int[][] grid, int[][] total, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] visited = new boolean[m][n];

    int[] deltaX = {-1, 1, 0, 0};
    int[] deltaY = {0, 0, -1, 1};

    int dist = -1;
    Queue<Pos> q = new LinkedList<>();
    q.offer(new Pos(i, j, dist));
    while (!q.isEmpty()) {
      Pos pos = q.poll();
      int x = pos.x;
      int y = pos.y;
      if (!visited[x][y]) {
        visited[x][y] = true;

        for (int d = 0; d < deltaX.length; d++) {
          int x2 = x + deltaX[d];
          int y2 = y + deltaY[d];
          if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && !visited[x2][y2]
                  && grid[x2][y2] == 0) {
            Pos newPos = new Pos(x2, y2, pos.dist + 1);
            q.offer(newPos);
            total[x2][y2] += newPos.dist - 1;

            if (dist < 0 || dist > total[x2][y2])
              dist = total[x2][y2];
          }
        }

      }
    }

    return dist;
  }

  @Override
  void run() {
    int[][] grid = new int[][]{array(1, 0, 2, 0, 1), array(0, 0, 0, 0, 0), array(0, 0, 1, 0, 0)};
    print(shortestDistance(grid));
  }

  class Pos {
    int x;
    int y;
    int dist;

    public Pos(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }
}
