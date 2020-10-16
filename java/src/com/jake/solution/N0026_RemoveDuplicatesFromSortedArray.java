package com.jake.solution;

public class N0026_RemoveDuplicatesFromSortedArray {

    // two pointer
    public int removeDuplicates(int[] nums) {

        int r = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[r] != nums[i]) {
                r++;
                nums[r] = nums[i];
            }
        }

        return ++r;
    }
}
