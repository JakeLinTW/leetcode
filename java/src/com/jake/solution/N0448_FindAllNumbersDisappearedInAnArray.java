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

    // do it without extra space and in O(n) runtime, use negative number tag index
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> r = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                r.add(i + 1);
            }
        }
        return r;
    }
}
