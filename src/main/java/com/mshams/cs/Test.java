package com.mshams.cs;

import java.util.Collections;
import java.util.TreeMap;

public class Test {
  public int findBlackPixel(char[][] picture, int N) {
    int m = picture.length, n = picture[0].length;
    int[] row = new int[m];
    int[] col = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 'B') {
          row[i]++;
          col[j]++;
        }
      }
    }

    int total = 0;
    for (int i = 0; i < m; i++) {
      if (row[i] == N) {
        int temp = 0;
        for (int j = 0; j < n; j++) {
          if (picture[i][j] == 'B' && col[j] == N) {
            temp += 1;
          }
        }
        if (temp == N) {
          total += temp;
        }
      }
    }

    

    return total;
  }

  public static void main(String[] args) {
    char[][] m = new char[][]{
            {'W', 'B', 'W', 'B', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'B', 'W'},
            {'W', 'W', 'B', 'W', 'B', 'W'}
    };

    Test test = new Test();
    System.out.println(test.findBlackPixel(m, 3));
  }
}
