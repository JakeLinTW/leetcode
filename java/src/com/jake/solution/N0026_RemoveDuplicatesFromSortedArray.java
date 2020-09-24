package com.jake.solution;

public class N0026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int r = N0026_RemoveDuplicatesFromSortedArray.removeDuplicates(new int[] { 1, 1, 2 });
        System.out.println(r); // 2

        r = N0026_RemoveDuplicatesFromSortedArray.removeDuplicates(new int[] { 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
        System.out.println(r); // 5
    }

    // two pointer
    public static int removeDuplicates(int[] nums) {

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
