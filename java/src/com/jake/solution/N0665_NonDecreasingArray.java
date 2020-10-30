package com.jake.solution;

import java.util.Arrays;

public class N0665_NonDecreasingArray {

    // check both way, two pass
    public boolean checkPossibility(int[] nums) {
        return checkForward(nums) || checkReverse(nums);
    }

    private boolean checkForward(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count >= 2 || (i - 1 >= 0 && nums[i - 1] > nums[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkReverse(int[] nums) {
        int i = nums.length;
        int count = 0;
        while (i-- > 1) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count >= 2 || (i + 1 < nums.length && nums[i + 1] < nums[i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    // brute force
    public boolean checkPossibility2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            nums[i] = i > 0 ? nums[i - 1] : Integer.MIN_VALUE;
            if (isIncrease(nums)) {
                return true;
            }
            nums[i] = temp;
        }
        return false;
    }

    private boolean isIncrease(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // brute force, but reduce the problem
    public boolean checkPossibility3(int[] nums) {

        int i = 0;
        while (i < nums.length - 2 && nums[i] <= nums[i + 1] && nums[i + 1] <= nums[i + 2]) {
            i++;
        }

        int j = nums.length - 1;
        while (j > 1 && nums[j] >= nums[j - 1] && nums[j - 1] >= nums[j - 2]) {
            j--;
        }

        if (j - i + 1 <= 2) {
            return true;
        } else if (j - i + 1 >= 5) {
            return false;
        }

        return bruteForceSolve(Arrays.copyOfRange(nums, i, j + 1));
    }

    private boolean bruteForceSolve(int[] nums) {
        return checkPossibility2(nums);
    }

    // one pass
    public boolean checkPossibility4(int[] nums) {

        boolean hasChange = false;
        int temp = Integer.MIN_VALUE; // index - 2
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (hasChange) {
                    return false;
                }

                if (nums[i] < temp) {
                    nums[i] = nums[i - 1];
                }
                hasChange = true;
            } else {
                temp = nums[i - 1];
            }
        }
        return true;
    }

    // check problem index
    public boolean checkPossibility5(int[] nums) {
        int p = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (p != -1) {
                    return false;
                }
                p = i;
            }
        }

        return p <= 1 || p == nums.length - 1 || nums[p + 1] >= nums[p - 1] || nums[p] >= nums[p - 2];
    }
}
