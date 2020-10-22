package com.jake.solution;

import java.util.Arrays;

public class N0628_MaximumProductOfThreeNumbers {

    // sort first
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        if (nums[last] <= 0 || nums[1] >= 0 || nums[last - 1] * nums[last - 2] > nums[0] * nums[1]) {
            return nums[last] * nums[last - 1] * nums[last - 2];
        } else {
            return nums[last] * nums[0] * nums[1];
        }
    }

    // sort first and compare two result
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int j = nums.length - 2;
        int k = nums.length - 3;
        return Math.max(nums[0] * nums[1] * nums[i], nums[i] * nums[j] * nums[k]);
    }

    // find top 3 and last 2 number
    public int maximumProduct3(int[] nums) {
        int l1 = Integer.MAX_VALUE, l2 = Integer.MAX_VALUE, t1 = Integer.MIN_VALUE, t2 = Integer.MIN_VALUE, t3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > t1) {
                t3 = t2;
                t2 = t1;
                t1 = num;
            } else if (num > t2) {
                t3 = t2;
                t2 = num;
            } else if (num > t3) {
                t3 = num;
            }
            if (num < l1) {
                l2 = l1;
                l1 = num;
            } else if (num < l2) {
                l2 = num;
            }
        }

        return Math.max(l1 * l2 * t1, t1 * t2 * t3);
    }
}
