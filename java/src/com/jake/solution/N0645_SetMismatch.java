package com.jake.solution;

import java.util.ArrayList;
import java.util.List;

public class N0645_SetMismatch {

    // TODO optimize
    public int[] findErrorNums(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] check = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            check[nums[i]] += 1;
            if (check[nums[i]] != 1) {
                ans.add(nums[i]);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (check[i] == 0) {
                ans.add(i);
            }
        }
        return ans.stream().distinct().mapToInt(i -> i).toArray();
    }
}
