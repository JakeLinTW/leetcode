package com.jake.solution;

public class N0674_LongestContinuousIncreasingSubsequence {

    // compare each increasing length
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            result = Math.max(result, count);
        }
        return result;
    }

    // compare each increasing length, using temp position
    public int findLengthOfLCIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 1, temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                temp = i;
            }
            result = Math.max(result, i - temp + 1);
        }

        return result;
    }
}
