package com.jake.solution;

public class N0643_MaximumAverageSubarrayI {

    // plus one minus one
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int j = 0; j < k; j++) {
            temp += nums[j];
        }
        max = temp;
        int offset = k - 1;
        for (int i = 1; i < nums.length - offset; i++) {
            temp += -nums[i - 1] + nums[i + offset];
            if (temp > max) {
                max = temp;
            }
        }
        return (double) max / k;
    }
}
