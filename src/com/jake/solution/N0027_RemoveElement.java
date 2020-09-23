package com.jake.solution;

public class N0027_RemoveElement {

    public static void main(String[] args) {
        int r = N0027_RemoveElement.removeElement(new int[] { 3, 2, 2, 3 }, 3);
        System.out.println(r); // 2

        r = N0027_RemoveElement.removeElement2(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2);
        System.out.println(r); // 5
    }

    // two pointer
    public static int removeElement(int[] nums, int val) {

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
    public static int removeElement2(int[] nums, int val) {

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
