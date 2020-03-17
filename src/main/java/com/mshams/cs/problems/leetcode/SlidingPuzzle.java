package com.mshams.cs.problems.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-puzzle/
 * <p>
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * <p>
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * <p>
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * <p>
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 * <p>
 * Examples:
 * <p>
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 */
public class SlidingPuzzle {
  public int slidingPuzzle(int[][] board) {
    int m = board.length, n = board[0].length;

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] targetBoard = new int[m][n];
    int zeroRow = 0, zeroCol = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        targetBoard[i][j] = i * n + j + 1;
        if (board[i][j] == 0) {
          zeroRow = i;
          zeroCol = j;
        }
      }
    }

    targetBoard[m - 1][n - 1] = 0;
    String targetBoardString = Arrays.deepToString(targetBoard);

    Node initialState = new Node(board, zeroRow, zeroCol, 0);

    Set<String> seenBoards = new HashSet<>();
    seenBoards.add(initialState.boardString);

    Queue<Node> q = new LinkedList<>();

    q.add(initialState);

    while (!q.isEmpty()) {
      Node next = q.poll();

      if (targetBoardString.equals(next.boardString)) {
        return next.depth;
      }

      for (int[] d : directions) {
        int row2 = next.zeroRow + d[0];
        int col2 = next.zeroCol + d[1];
        if (row2 >= 0 && row2 < m && col2 >= 0 && col2 < n) {
          int[][] newBoard = new int[m][n];
          for (int i = 0; i < m; i++) {
            newBoard[i] = next.board[i].clone();
          }

          swap(newBoard, next.zeroRow, next.zeroCol, row2, col2);

          Node newState = new Node(newBoard, row2, col2, next.depth + 1);
          if (!seenBoards.contains(newState.boardString)) {
            q.add(newState);
          }
          seenBoards.add(newState.boardString);
        }
      }
    }

    return -1;
  }

  private void swap(int[][] board, int r0, int c0, int r1, int c1) {
    board[r0][c0] = board[r1][c1];
    board[r1][c1] = 0;
  }

  class Node {
    int[][] board;
    int zeroRow;
    int zeroCol;
    String boardString;
    int depth;

    Node(int[][] board, int row, int col, int depth) {
      this.board = board;
      this.zeroRow = row;
      this.zeroCol = col;
      this.boardString = Arrays.deepToString(board);
      this.depth = depth;
    }
  }
}
