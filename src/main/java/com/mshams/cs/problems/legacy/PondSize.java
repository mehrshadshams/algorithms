package com.mshams.cs.problems.legacy;

import java.util.ArrayList;
import java.util.List;

import static com.mshams.cs.problems.legacy.Utils.array;

public class PondSize extends Problem {
  public List<Integer> pondSize(int[][] array) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        if (array[i][j] == 0) {
          list.add(getPondSize(array, i, j));
        }
      }
    }
    return list;
  }

  private int getPondSize(int[][] array, int x, int y) {
    if (x < 0 || x >= array.length || y < 0 || y >= array[0].length ||
            array[x][y] != 0) {
      return 0;
    }

    int size = 0;
    if (array[x][y] == 0) {
      size += 1;
    }

    array[x][y] = -1;

    size += getPondSize(array, x + 1, y);
    size += getPondSize(array, x - 1, y);
    size += getPondSize(array, x, y + 1);
    size += getPondSize(array, x, y - 1);

    size += getPondSize(array, x + 1, y - 1);
    size += getPondSize(array, x + 1, y + 1);
    size += getPondSize(array, x - 1, y - 1);
    size += getPondSize(array, x - 1, y + 1);

    return size;
  }

  @Override
  void run() {
    int[][] pond = new int[][]{
            array(0, 2, 1, 0),
            array(0, 1, 0, 1),
            array(1, 1, 0, 1),
            array(0, 1, 0, 1)
    };
    System.out.println(pondSize(pond));
  }
}
