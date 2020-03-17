package com.mshams.cs.problems.legacy;

import com.google.common.collect.BiMap;

import java.util.*;

public class AStar {
  private final int goalRow;
  private final int goalCol;

  // @formatter:off
  private Integer[][] maze = {
          {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
          {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
          {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
          {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
          {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
          {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
          {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
          {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
          {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
          {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
  };
  // @formatter:on

  private Integer[][] heuristic = new Integer[maze.length][maze.length];

  public AStar(int goalRow, int goalCol) {
    this.goalRow = goalRow;
    this.goalCol = goalCol;

    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze.length; j++) {
        heuristic[i][j] = Math.abs(goalRow - i) + Math.abs(goalCol - j);
      }
    }
  }

  private static <T> void fill2d(T[][] arr, T value) {
    for (T[] t : arr) {
      Arrays.fill(t, value);
    }
  }

  public static void main(String[] args) {
    AStar a = new AStar(7, 5);
    a.findPath();
  }

  public void findPath() {
    print(maze, true);
    print(heuristic, false);

    PriorityQueue<Action> actions = new PriorityQueue<>();

    int[][] visited = new int[maze.length][maze.length];
    visited[0][0] = 1;

    int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    String[] deltaNames = {"^", "<", "v", ">"};

    String[][] path = new String[maze.length][maze.length];
    fill2d(path, ".");

    Integer[][] expand = new Integer[maze.length][maze.length];

    fill2d(expand, -1);

    int x = 0;
    int y = 0;
    int g = 0;
    int h = heuristic[x][y];
    int f = g + h;
    actions.add(new Action(f, g, h, x, y, ""));

    int count = 0;

    maze[0][0] = 1;
    int cost = 1;

    boolean found = false;
    while (!found) {
      Action next = actions.poll();
      if (next == null) {
        break;
      }

      if (next.x == goalRow && next.y == goalCol) {
        found = true;
      } else {
        expand[next.x][next.y] = count;
        path[next.x][next.y] = next.direction;
        count += 1;

        for (int i = 0; i < delta.length; i++) {
          int[] d = delta[i];
          int x2 = next.x + d[0];
          int y2 = next.y + d[1];

          if (x2 >= 0 && y2 >= 0 && x2 < maze.length && y2 < maze.length) {
            if (maze[x2][y2] != 0 && visited[x2][y2] != 1) {
                int g2 = next.f + cost;
              int h2 = heuristic[x2][y2];
              int f2 = cost + h2;
              actions.add(new Action(f2, g2, h2, x2, y2, deltaNames[i]));
              visited[x2][y2] = 1;
            }
          }
        }
      }
    }

    print(expand, true);
    print(path, true);


  }

  private <T> void print(T[][] arr, boolean showGoal) {

    System.out.println("\n====================================\n");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (showGoal && i == goalRow && j == goalCol) {
          System.out.print("*" + "\t");
        } else {
          System.out.print(arr[i][j] + "\t");
        }
      }
      System.out.println();
    }
    System.out.println("\n====================================\n");
  }

  private class Action implements Comparable<Action> {
    private final int g;
    private final int h;
    private int f;
    private int x;
    private int y;
    private String direction;

    public Action(int f, int g, int h, int x, int y, String direction) {
      this.f = f;
      this.g = g;
      this.h = h;
      this.x = x;
      this.y = y;
      this.direction = direction;
    }

    @Override
    public int compareTo(Action o) {
      return Integer.compare(f, o.f);
    }
  }
}
