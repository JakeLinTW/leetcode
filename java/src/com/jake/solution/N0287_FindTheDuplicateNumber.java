package com.jake.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N0287_FindTheDuplicateNumber {

    // using hash set
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // sort first
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // using int array
    public int findDuplicate3(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int num : nums) {
            if (arr[num]) {
                return num;
            }
            arr[num] = true;
        }
        return -1;
    }

    // brute force
    public int findDuplicate4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // O(1) space complexity and O(N) time complexity
    public int findDuplicate5(int[] nums) {
        for (int num : nums) {
            int i = Math.abs(num);
            if (nums[i] < 0) {
                return i;
            } else {
                nums[i] *= -1;
            }
        }
        return -1;
    }

    // two pointer
    public int findDuplicate6(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
