package com.jake.solution;

public class N0867_TransposeMatrix {

    public int[][] transpose(int[][] A) {
        int rowLength = A.length;
        int columnLength = A[0].length;

        int[][] result = new int[columnLength][rowLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
