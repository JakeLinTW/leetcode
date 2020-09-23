package com.jake.solution;

public class N0035_SearchInsertPosition {

    public static void main(String[] args) {
        int r = N0035_SearchInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 5);
        System.out.println(r); // 2

        r = N0035_SearchInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 2);
        System.out.println(r); // 1

        r = N0035_SearchInsertPosition.searchInsert2(new int[] { 1, 3, 5, 6 }, 7);
        System.out.println(r); // 4

        r = N0035_SearchInsertPosition.searchInsert2(new int[] { 1, 3, 5, 6 }, 0);
        System.out.println(r); // 0
    }

    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) // simple check insert position
                return i;
        }

        return nums.length;
    }

    // binary search
    public static int searchInsert2(int[] nums, int target) {

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
