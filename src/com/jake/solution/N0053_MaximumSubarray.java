package com.jake.solution;

public class N0053_MaximumSubarray {

    public static void main(String[] args) {
        int r = N0053_MaximumSubarray.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(r); // 6

        r = N0053_MaximumSubarray.maxSubArray(new int[] { 1 });
        System.out.println(r); // 1

        r = N0053_MaximumSubarray.maxSubArray2(new int[] { 0 });
        System.out.println(r); // 0

        r = N0053_MaximumSubarray.maxSubArray2(new int[] { -1 });
        System.out.println(r); // -1

        r = N0053_MaximumSubarray.maxSubArray2(new int[] { -2147483647 });
        System.out.println(r); // -2147483647
    }

    // dynamic programming
    public static int maxSubArray(int[] nums) {

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
    public static int maxSubArray2(int[] nums) {
        return findMax(nums, 0, nums.length - 1);
    }

    private static int findMax(int[] nums, int l, int r) {

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

    private static int findMax(int[] nums, int l, int m, int r) {
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
