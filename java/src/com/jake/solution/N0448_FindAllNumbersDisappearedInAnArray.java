package com.jake.solution;

import java.util.ArrayList;
import java.util.List;

public class N0448_FindAllNumbersDisappearedInAnArray {

    // use another space
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<Integer>();
        int size = nums.length;
        int[] count = new int[size];
        for (int num : nums) {
            count[num - 1] += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                r.add(i + 1);
            }
        }
        return r;
    }
}
