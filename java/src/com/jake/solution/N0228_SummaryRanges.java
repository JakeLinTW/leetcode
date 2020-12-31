package com.jake.solution;

import java.util.ArrayList;
import java.util.List;

public class N0228_SummaryRanges {

    // two pointer
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        int p1 = 0;
        for (int p2 = 1; p2 < nums.length; p2++) {
            if (nums[p1] == (nums[p2] - (p2 - p1))) {
                continue;
            }
            if (p2 - 1 - p1 == 0) {
                result.add(nums[p1] + "");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[p1]);
                sb.append("->");
                sb.append(nums[p2 - 1]);
                result.add(sb.toString());
            }
            p1 = p2;
        }

        if (p1 == nums.length - 1) {
            result.add(nums[p1] + "");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[p1]);
            sb.append("->");
            sb.append(nums[nums.length - 1]);
            result.add(sb.toString());
        }
        return result;
    }

    // two pointer optimize
    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<String>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (right + 1 != nums.length && nums[right + 1] == nums[left] + right - left + 1) {
                right++;
            }
            StringBuilder sb = new StringBuilder();
            if (right == left) {
                sb.append(nums[left]);
            } else {
                sb.append(nums[left]).append("->").append(nums[right]);
            }
            result.add(sb.toString());
            left = ++right;
        }
        return result;
    }
}
