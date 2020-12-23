package com.jake.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0350_IntersectionOfTwoArraysII {

    // using hash map to count each number
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                list.add(num);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
    
    // TODO optimize
}
