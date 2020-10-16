package com.jake.solution;

import java.util.ArrayList;
import java.util.List;

public class N0118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<Integer>();
            List<Integer> prevList = null;
            if (i > 0) {
                prevList = result.get(i - 1);
            }
            int row = i + 1;
            for (int j = 0; j < row; j++) {
                if (j == 0 || j == row - 1) {
                    rowList.add(1);
                } else if (prevList != null) {
                    rowList.add(prevList.get(j) + prevList.get(j - 1));
                }
            }
            result.add(rowList);
        }

        return result;
    }

    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<Integer>();
            List<Integer> prevList = result.get(i - 1);

            rowList.add(1);

            for (int j = 1; j < i; j++) {
                rowList.add(prevList.get(j) + prevList.get(j - 1));
            }

            rowList.add(1);
            result.add(rowList);
        }

        return result;
    }
}
