package com.mshams.cs.problems;

import com.mshams.cs.helpers.FileHelpers;
import org.junit.jupiter.api.Test;

public class MinesweeperTests {
    private static char[][] getBoard(String filename) {
        String content = FileHelpers.asString("problems/" + filename);
        String[] lines = content.split(System.lineSeparator());
        final int col = lines[0].split("\\s+").length;
        final int row = lines.length;

        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String[] values = lines[i].split("\\s+");
            for (int j = 0; j < col; j++) {
                board[i][j] = values[j].charAt(0);
            }
        }

        return board;
    }

    @Test
    void test1() {
        char[][] board = getBoard("mine1.txt");

        Minesweeper solution = new Minesweeper();
    }
}
