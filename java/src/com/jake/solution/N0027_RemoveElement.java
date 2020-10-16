package com.jake.solution;

public class N0027_RemoveElement {

    // two pointer
    public int removeElement(int[] nums, int val) {

        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[r] = nums[i];
                r++;
            }
        }
        return r;
    }

    // two pointer, change the order of elements
    public int removeElement2(int[] nums, int val) {

        int i = 0;
        int j = nums.length;

        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }

        return j;
    }
}
