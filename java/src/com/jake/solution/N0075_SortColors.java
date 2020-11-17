package com.jake.solution;

import java.util.Arrays;

public class N0075_SortColors {

    // using java standard library
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // 2 way pass without sort algorithm
    public void sortColors2(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                white++;
            } else if (num == 2) {
                blue++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else if (blue > 0) {
                nums[i] = 2;
                blue--;
            }
        }
    }

    // brute force
    public void sortColors3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // selection sort
    public void sortColors4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }

    // insertion sort
    public void sortColors5(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            for (; j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }

    // TODO more sort algorithm
    
    // bubble sort
    public void sortColors6(int[] nums) {
    }
}
