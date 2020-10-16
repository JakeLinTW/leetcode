package com.jake.solution;

public class N0035_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) // simple check insert position
                return i;
        }

        return nums.length;
    }

    // binary search
    public int searchInsert2(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (r - l) / 2 + l; // equals '(r + l) / 2', prevent integer overflow
            if (target > nums[m]) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
