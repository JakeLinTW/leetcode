package com.jake.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class N0229_MajorityElementII {

    // list, map, set ... whatever you can use
    public List<Integer> majorityElement(int[] nums) {
        int t = nums.length / 3;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> temp = new HashSet<Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);

            } else {
                map.put(num, 1);
            }
            int count = map.get(num);
            if (count > t) {
                temp.add(num);
            }
        }

        return new ArrayList<Integer>(temp);
    }

    // sort first
    public List<Integer> majorityElement2(int[] nums) {
        int t = nums.length / 3;

        Arrays.sort(nums);
        List<Integer> r = new ArrayList<Integer>();
        int count = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[temp]) {
                temp = i;
                count = 0;
            }
            count++;
            if (count > t && !r.contains(nums[i])) {
                r.add(nums[i]);
            }
        }

        return r;
    }

    // at most two answer
    public List<Integer> majorityElement3(int[] nums) {
        int a1 = 0, a2 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == a1) {
                count1++;
            } else if (num == a2) {
                count2++;
            } else if (count1 == 0) {
                a1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                a2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (a1 == num) {
                count1++;
            } else if (a2 == num) {
                count2++;
            }
        }

        List<Integer> r = new ArrayList<Integer>();
        int t = nums.length / 3;
        if (count1 > t) {
            r.add(a1);
        }
        if (count2 > t) {
            r.add(a2);
        }
        return r;
    }

    // at most two answer with 2d array
    public List<Integer> majorityElement4(int[] nums) {
        int[][] temp = new int[2][2];

        for (int num : nums) {
            if (num == temp[0][0]) {
                temp[0][1] += 1;
            } else if (num == temp[1][0]) {
                temp[1][1] += 1;
            } else if (temp[0][1] == 0) {
                temp[0][0] = num;
                temp[0][1] = 1;
            } else if (temp[1][1] == 0) {
                temp[1][0] = num;
                temp[1][1] = 1;
            } else {
                temp[0][1] -= 1;
                temp[1][1] -= 1;
            }
        }

        temp[0][1] = 0;
        temp[1][1] = 0;
        for (int num : nums) {
            if (num == temp[0][0]) {
                temp[0][1] += 1;
            } else if (num == temp[1][0]) {
                temp[1][1] += 1;
            }
        }

        List<Integer> r = new ArrayList<Integer>();
        int t = nums.length / 3;
        if (temp[0][1] > t) {
            r.add(temp[0][0]);
        }
        if (temp[1][1] > t) {
            r.add(temp[1][0]);
        }
        return r;
    }
}
