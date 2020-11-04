package com.jake.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0830_PositionsOfLargeGroups {

    // two pointer
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[start]) {
                if (i - 1 - start >= 2) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(start);
                    list.add(i - 1);
                    result.add(list);
                }
                start = i;
            } else if (i == chars.length - 1) {
                if (i - start >= 2) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(start);
                    list.add(i);
                    result.add(list);
                }
            }
        }

        return result;
    }

    // two pointer optimize
    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0, j = 0; i < s.length(); i = j) {
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                result.add(Arrays.asList(i, j - 1));
            }
        }

        return result;
    }
}
