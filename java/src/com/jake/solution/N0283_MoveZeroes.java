package com.jake.solution;

import java.util.stream.IntStream;

public class N0283_MoveZeroes {

    // nested loop
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = i; j < nums.length - count; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - count] = 0;
                i--;
            }
        }
    }

    // control insert index
    public void moveZeroes2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        int l = nums.length;
        while (l-- > i) {
            nums[l] = 0;
        }
    }
}
