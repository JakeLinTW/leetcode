package com.jake.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N0349_IntersectionOfTwoArrays {

    // using hash set to mapping num1 and num2
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums1) {
            set.add(num);
        }

        return Arrays.stream(nums2).filter(i -> set.remove(i)).toArray();
    }
    
    // TODO optimize
}
