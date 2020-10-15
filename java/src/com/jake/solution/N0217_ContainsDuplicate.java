package com.jake.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N0217_ContainsDuplicate {
    public static void main(String[] args) {
        boolean r = N0217_ContainsDuplicate.containsDuplicate2(new int[] { 1, 2, 3, 1 });
        System.out.println(r); // true

        r = N0217_ContainsDuplicate.containsDuplicate2(new int[] { 1, 2, 3, 4 });
        System.out.println(r); // false

        r = N0217_ContainsDuplicate.containsDuplicate2(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 });
        System.out.println(r); // true
    }

    // hash set
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    // sort first
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
