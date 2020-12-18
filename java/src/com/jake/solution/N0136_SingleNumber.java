package com.jake.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N0136_SingleNumber {

    // using hash map
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // using hash set
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.remove(num)) {
                set.add(num);
            }
        }

        for (Integer s : set) {
            // finally contain one element
            return s;
        }
        return -1;
    }

    // using boolean array
    public int singleNumber3(int[] nums) {
        boolean[] arr = new boolean[60001];

        for (int num : nums) {
            arr[num + 30000] ^= true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                return i - 30000;
            }
        }

        return -1;
    }
    
    // using int array
    public int singleNumber4(int[] nums) {
        int[] arr = new int[60001];
        
        for (int num : nums) {
            arr[num + 30000] += 1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i - 30000;
            }
        }
        
        return -1;
    }

    // sort first
    public int singleNumber5(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    // TODO optimize
}
