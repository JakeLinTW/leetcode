package com.jake.solution;

public class N0724_FindPivotIndex {

    // sum first
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - left - nums[i] == left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
