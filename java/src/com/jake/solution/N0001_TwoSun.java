package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0001_TwoSun {

    public static void main(String[] args) {
        int[] r = N0001_TwoSun.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(r[0] + "," + r[1]); // 0, 1

        r = N0001_TwoSun.twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println(r[0] + "," + r[1]); // 1, 2

        r = N0001_TwoSun.twoSum(new int[] { 3, 3 }, 6);
        System.out.println(r[0] + "," + r[1]); // 0, 1
    }

    // hash map collect mapping number
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
