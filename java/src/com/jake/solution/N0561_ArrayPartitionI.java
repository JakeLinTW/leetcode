package com.jake.solution;

import java.util.Arrays;

public class N0561_ArrayPartitionI {

    // sort first and sum even index value
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int r = 0;
        for (int i = 0; i < nums.length; i += 2) {
            r += nums[i];
        }
        return r;
    }
}
