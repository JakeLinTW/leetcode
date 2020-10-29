package com.jake.solution;

public class N0661_ImageSmoother {

    // list all
    public int[][] imageSmoother(int[][] M) {
        int[][] r = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = M[i][j];
                int count = 1;

                boolean hasLeft = j - 1 >= 0;
                boolean hasTop = i - 1 >= 0;
                boolean hasRight = j + 1 < M[0].length;
                boolean hasBottom = i + 1 < M.length;

                if (hasLeft) {
                    sum += M[i][j - 1];
                    count++;
                }
                if (hasTop) {
                    sum += M[i - 1][j];
                    count++;
                }
                if (hasRight) {
                    sum += M[i][j + 1];
                    count++;
                }
                if (hasBottom) {
                    sum += M[i + 1][j];
                    count++;
                }
                if (hasTop && hasLeft) {
                    sum += M[i - 1][j - 1];
                    count++;
                }
                if (hasTop && hasRight) {
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (hasBottom && hasLeft) {
                    sum += M[i + 1][j - 1];
                    count++;
                }
                if (hasBottom && hasRight) {
                    sum += M[i + 1][j + 1];
                    count++;
                }

                r[i][j] = sum / count;
            }
        }
        return r;
    }

    // loop around
    public int[][] imageSmoother2(int[][] M) {
        int[][] r = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0;
                int count = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int rowIndex = i + k;
                        int colIndex = j + l;

                        if (rowIndex >= 0 && rowIndex < M.length && colIndex >= 0 && colIndex < M[0].length) {
                            sum += M[rowIndex][colIndex];
                            count++;
                        }
                    }
                }

                r[i][j] = sum / count;
            }
        }
        return r;
    }
    
    
}
