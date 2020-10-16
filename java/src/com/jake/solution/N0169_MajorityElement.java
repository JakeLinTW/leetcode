package com.jake.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class N0169_MajorityElement {
    
    // hash map
    public int majorityElement(int[] nums) {
        int r = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                r = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return r;
    }

    // brute force
    public int majorityElement2(int[] nums) {

        int majorityCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > majorityCount) {
                return nums[i];
            }
        }

        return -1;
    }

    // find sorted half
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // randomization
    public int majorityElement4(int[] nums) {
        Random random = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int i = random.nextInt(nums.length);
            int r = nums[i];
            int count = 0;
            for (int num : nums) {
                if (r == num) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return r;
            }
        }
    }

    // divide and conquer
    public int majorityElement5(int[] nums) {
        return findMajorityElement(nums, 0, nums.length - 1);
    }

    private int findMajorityElement(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int midIndex = (right + left) / 2;
        int leftMajority = findMajorityElement(nums, left, midIndex);
        int rightMajority = findMajorityElement(nums, midIndex + 1, right);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = countMajortiy(nums, leftMajority);
        int rightCount = countMajortiy(nums, rightMajority);

        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    private int countMajortiy(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (target == num) {
                count++;
            }
        }
        return count;
    }

    // boyer-moore voting algorithm
    public int majorityElement6(int[] nums) {
        int r = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                r = num;
            }
            if (r == num) {
                count++;
            } else {
                count--;
            }
        }
        return r;
    }

}
