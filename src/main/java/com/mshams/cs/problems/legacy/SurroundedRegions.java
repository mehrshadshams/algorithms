package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.array;
import static com.mshams.cs.problems.legacy.Utils.printArray;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class SurroundedRegions extends Problem {
  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return;
    }
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') {
        dfs(board, i, 0);
      }
      if (board[i][n - 1] == 'O') {
        dfs(board, i, n - 1);
      }
    }

    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O') {
        dfs(board, 0, j);
      }
      if (board[m - 1][j] == 'O') {
        dfs(board, m - 1, j);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '*') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  void dfs(char[][] board, int i, int j) {
    int m = board.length;
    int n = board[0].length;

    if (i < 0 || i >= m || j < 0 || j >= n) {
      return;
    }

    if (board[i][j] == 'O') {
      board[i][j] = '*';
    }

    if (i > 1 && board[i - 1][j] == 'O') {
      dfs(board, i - 1, j);
    }
    if (i < m - 2 && board[i + 1][j] == 'O') {
      dfs(board, i + 1, j);
    }
    if (j > 1 && board[i][j - 1] == 'O') {
      dfs(board, i, j - 1);
    }
    if (j < n - 2 && board[i][j + 1] == 'O') {
      dfs(board, i, j + 1);
    }
  }


  @Override
  void run() {
//        char[][] map = new char[][]{
//                array('O','O','O','O','X','X'),
//                array('O','O','O','O','O','O'),
//                array('O','X','O','X','O','O'),
//                array('O','X','O','O','X','O'),
//                array('O','X','O','X','O','O'),
//                array('O','X','O','O','O','O')
//        };

//        char[][] map = new char[][] {
//         array('O','X','X','O','X'),
//         array('X','X','X','X','O'),
//         array('X','X','X','O','X'),
//         array('O','X','O','O','O'),
//         array('X','X','O','X','O')
//        };

    char[][] map = new char[][]{
            array('X', 'X', 'X', 'X'),
            array('X', 'O', 'O', 'X'),
            array('X', 'X', 'O', 'X'),
            array('X', 'O', 'X', 'X')
    };

//        map = new char[][] {
//             array('O','O','O','O','X','X'),
//             array('O','O','O','O','O','O'),
//             array('O','X','O','X','O','O'),
//             array('O','X','O','O','X','O'),
//             array('O','X','O','X','O','O'),
//             array('O','X','O','O','O','O')
//                            };

    map = new char[][]{
            array('O', 'X', 'O', 'O', 'O', 'X'),
            array('O', 'O', 'X', 'X', 'X', 'O'),
            array('X', 'X', 'X', 'X', 'X', 'O'),
            array('O', 'O', 'O', 'O', 'X', 'X'),
            array('X', 'X', 'O', 'O', 'X', 'O'),
            array('O', 'O', 'X', 'X', 'X', 'X')
    };

    printArray(map);

    solve(map);

    printArray(map);

//        [["O","X","X","O","X"],
//         ["X","X","X","X","O"],
//         ["X","X","X","O","X"],
//         ["O","X","O","O","O"],
//         ["X","X","O","X","O"]]
//
//        [["O","X","X","O","X"],
//         ["X","X","X","X","O"],
//         ["X","X","X","X","X"],
//         ["O","X","O","O","O"],
//         ["X","X","O","X","O"]]
//
//        [["O","X","X","O","X"],
//         ["X","X","X","X","O"],
//         ["X","X","X","O","X"],
//         ["O","X","O","O","O"],
//         ["X","X","O","X","O"]]
  }
}
