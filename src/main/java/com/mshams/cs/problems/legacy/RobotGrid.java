package com.mshams.cs.problems.legacy;

import java.util.*;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printArray;

public class RobotGrid extends Problem {
  public List<Point> findPath(int[][] maze) {
    List<Point> path = new ArrayList<>();
    Set<Point> failedPoints = new HashSet<>();

    if (findPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }

    return new ArrayList<>();
  }

  private boolean findPath(int[][] maze, int r, int c, List<Point> path, Set<Point> failed) {
    if (r < 0 || c < 0 || maze[r][c] == 1) return false;

    Point point = new Point(r, c);

    if (failed.contains(point)) return false;

    boolean isAtOrigin = (r == 0 && c == 0);

    boolean p = isAtOrigin || findPath(maze, r - 1, c, path, failed) || findPath(maze, r, c - 1, path, failed);
    if (p) {
      path.add(point);
    } else {
      failed.add(point);
    }

    return p;
  }

  @Override
  void run() {
    int[][] maze = new int[][]{
            array(0, 0, 0, 0, 0),
            array(0, 1, 1, 0, 0),
            array(0, 0, 1, 0, 0),
            array(0, 0, 1, 1, 0),
            array(0, 0, 0, 0, 0),
    };

    final Random randomGen = new Random(0);
    maze = new int[100][100];
    for (int i = 1; i < 1000; i++) {
      int random = randomGen.nextInt(100 * 100);
      if (random != 0 && random != 100 * 100) {
        int r = random / 100;
        int c = random % 100;
        maze[r][c] = 1;
      }
    }

    List<Point> path = findPath(maze);
    printArray(path);
  }

  private class Point {
    private int i;
    private int j;

    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Point point = (Point) o;
      return i == point.i && j == point.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }

    @Override
    public String toString() {
      return "(" + i + "," + j + ")";
    }
  }
}
