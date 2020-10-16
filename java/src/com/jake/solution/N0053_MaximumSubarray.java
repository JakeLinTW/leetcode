package com.jake.solution;

public class N0053_MaximumSubarray {

    // dynamic programming
    public int maxSubArray(int[] nums) {

        int max = nums[0], temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (temp < 0)
                temp = 0;

            temp += nums[i];

            if (max < temp)
                max = temp;

        }

        return max;
    }

    // divide and conquer
    public int maxSubArray2(int[] nums) {
        return findMax(nums, 0, nums.length - 1);
    }

    private int findMax(int[] nums, int l, int r) {

        if (l < r) {
            int m = (l + r) / 2;

            int leftMax = findMax(nums, l, m);
            int rightMax = findMax(nums, m + 1, r);
            int middleMax = findMax(nums, l, m, r);

            return Math.max(middleMax, Math.max(leftMax, rightMax));
        } else {
            return nums[l];
        }
    }

    private int findMax(int[] nums, int l, int m, int r) {
        int leftMax = nums[m];
        int leftSum = nums[m];
        int rightMax = nums[m + 1];
        int rightSum = nums[m + 1];

        // 1. get left max
        for (int i = m - 1; i >= l; i--) {
            leftSum += nums[i];
            if (leftSum > leftMax) {
                leftMax = leftSum;
            }
        }

        // 2. get right max
        for (int i = m + 2; i <= r; i++) {
            rightSum += nums[i];
            if (rightSum > rightMax) {
                rightMax = rightSum;
            }
        }

        return leftMax + rightMax;
    }
}
