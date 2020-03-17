package com.mshams.cs.problems.legacy;

public class PaintFill extends Problem {
  public boolean fill(Color[][] screen, int r, int c, Color color) {
    if (screen[r][c] == color) return false;

    fill(screen, r, c, screen[r][c], color);

    return true;
  }

  void fill(Color[][] screen, int r, int c, Color orig, Color color) {
    if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length
            || (screen[r][c] != orig || screen[r][c] == color)) {
      return;
    }

    screen[r][c] = color;

    fill(screen, r + 1, c, orig, color);
    fill(screen, r - 1, c, orig, color);
    fill(screen, r, c + 1, orig, color);
    fill(screen, r, c - 1, orig, color);
  }

  void print(Color[][] screen) {
    for (int i = 0; i < screen.length; i++) {
      for (int j = 0; j < screen[0].length; j++) {
        System.out.print(screen[i][j].toString().substring(0, 1) + " ");
      }
      System.out.println();
    }
  }

  @Override
  void run() {
  }

  enum Color {Black, White, Red, Yellow, Green}
}
