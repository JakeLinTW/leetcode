package com.jake.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0015_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> r = twoSum(nums, i);
            if (!r.isEmpty()) {
                result.addAll(r);
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;

        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int left = target + 1;
        int right = nums.length - 1;
        int sum = -nums[target];
        while (left < right) {
            if (nums[left] + nums[right] > sum) {
                right--;
            } else if (nums[left] + nums[right] < sum) {
                left++;
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(nums[target]);
                result.add(list);

                while (left < right && nums[left + 1] == nums[left])
                    left++;
                while (left < right && nums[right - 1] == nums[right])
                    right--;
                left++;
                right--;
            }
        }
        return result;
    }
    
    // TODO optimize
}