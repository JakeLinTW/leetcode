package com.jake.solution;

import java.util.ArrayList;
import java.util.List;

public class N0119_PascalsTriangleII {

    public static void main(String[] args) {
        List<Integer> r = N0119_PascalsTriangleII.getRow(5);
        System.out.println(r);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }

        for (int row = 1; row <= rowIndex; row++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i <= row; i++) {
                if (i == 0 || i == row) {
                    temp.add(1);
                } else {
                    temp.add(result.get(i) + result.get(i - 1));
                }
            }
            result = temp;
        }

        return result;
    }
}
