package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0697_DegreeOfAnArray {

    // brute force
    public int findShortestSubArray(int[] nums) {
        int length = 0;
        int count = 0;
        Set<Integer> checked = new HashSet<Integer>(); // without this will time limit exceeded
        for (int i = 0; i < nums.length; i++) {
            if (checked.contains(nums[i])) {
                continue;
            }
            checked.add(nums[i]);
            int tempCount = 1;
            int tempLength = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    tempCount++;
                    tempLength = j - i + 1;
                }
            }

            if (tempCount > count || (tempCount == count && tempLength < length)) {
                count = tempCount;
                length = tempLength;
            }
        }
        return length;
    }

    // count number first
    public int findShortestSubArray2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        // find max number
        int maxNumber = 0;
        for (int num : nums) {
            maxNumber = Math.max(maxNumber, num);
        }

        int[] count = new int[maxNumber + 1];
        int[] start = new int[maxNumber + 1];
        int[] end = new int[maxNumber + 1];

        // find count, start position and end position
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
            if (start[nums[i]] == 0) {
                start[nums[i]] = i + 1;
            }
            end[nums[i]] = i + 1;
            maxCount = Math.max(maxCount, count[nums[i]]);
        }

        int solve = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                int degree = end[i] - start[i] + 1;
                solve = solve != 0 ? Math.min(degree, solve) : degree;
            }
        }
        return solve;
    }
}
