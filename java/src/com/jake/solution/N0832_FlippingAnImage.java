package com.jake.solution;

public class N0832_FlippingAnImage {

    // reverse first and than invert
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            reverseRow(row);
            invertRow(row);
        }
        return A;
    }

    private void reverseRow(int[] row) {
        for (int i = 0; i < row.length / 2; i++) {
            int left = row[i];
            int right = row[row.length - 1 - i];
            row[i] = right;
            row[row.length - 1 - i] = left;
        }
    }

    private void invertRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = Math.abs(row[i] - 1);
        }
    }

    // direct
    public int[][] flipAndInvertImage2(int[][] A) {
        int columnLength = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (columnLength + 1) / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][columnLength - 1 - j] ^ 1;
                A[i][columnLength - 1 - j] = tmp ^ 1;
            }
        }
        return A;
    }
}
