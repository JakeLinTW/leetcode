package com.jake.solution;

public class N0036_ValidSudoku {

    // using boolean array
    public boolean isValidSudoku(char[][] board) {
        boolean[] row = null;
        boolean[] column = null;
        boolean[] subBox = null;
        for (int i = 0; i < 9; i++) {
            row = new boolean[10];
            column = new boolean[10];
            subBox = new boolean[10];
            for (int j = 0; j < 9; j++) {
                // check column
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (column[num]) {
                        return false;
                    }
                    column[num] = true;
                }

                // check row
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if (row[num]) {
                        return false;
                    }
                    row[num] = true;
                }

                // check sub box
                int boxRow = 3 * (i % 3) + j / 3;
                int boxColumn = 3 * (i / 3) + j % 3;
                if (board[boxRow][boxColumn] != '.') {
                    int num = board[boxRow][boxColumn] - '0';
                    if (subBox[num]) {
                        return false;
                    }
                    subBox[num] = true;
                }
            }
        }
        return true;
    }

    // using boolean array optimize
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] subBox = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = i / 3 * 3 + j / 3;
                    int idx = board[i][j] - '1';

                    if (row[j][idx] || column[i][idx] || subBox[k][idx]) {
                        return false;
                    }
                    row[j][idx] = column[i][idx] = subBox[k][idx] = true;
                }
            }
        }
        return true;
    }
}
