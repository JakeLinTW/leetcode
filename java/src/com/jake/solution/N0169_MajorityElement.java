package com.jake.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class N0169_MajorityElement {

    public static void main(String[] args) {
        int r = N0169_MajorityElement.majorityElement6(new int[] { 3, 2, 3 });
        System.out.println(r); // 3

        r = N0169_MajorityElement.majorityElement6(new int[] { 2, 2, 1, 1, 1, 2, 2 });
        System.out.println(r); // 2

        r = N0169_MajorityElement.majorityElement6(new int[] { 10, 9, 9, 9, 10 });
        System.out.println(r); // 9
    }

    // hash map
    public static int majorityElement(int[] nums) {
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
    public static int majorityElement2(int[] nums) {

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
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // randomization
    public static int majorityElement4(int[] nums) {
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
    public static int majorityElement5(int[] nums) {
        return 0;
    }

    // boyer-moore voting algorithm
    public static int majorityElement6(int[] nums) {
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
