package com.jake.solution;

public class N0566_ReshapeTheMatrix {

    // another two pointer
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length;
        int oc = nums[0].length;
        if (or * oc != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < or; i++) {
            for (int j = 0; j < oc; j++) {
                result[p1][p2] = nums[i][j];
                if (p2 < c - 1) {
                    p2++;
                } else {
                    p1++;
                    p2 = 0;
                }
            }
        }
        return result;
    }

    // calculate position, hint: M[n*i+j]=M[i][j]
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int or = nums.length;
        int oc = nums[0].length;
        if (or * oc != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < or; i++) {
            for (int j = 0; j < oc; j++) {
                int pos = i * oc + j;
                int p1 = pos / c;
                int p2 = pos % c;
                result[p1][p2] = nums[i][j];
            }
        }
        return result;
    }
}
