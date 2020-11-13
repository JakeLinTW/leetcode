package com.jake.solution;

public class N0209_MinimumSizeSubarraySum {

    // two pointer
    public int minSubArrayLen(int s, int[] nums) {
        int solve = 0;
        int length = 0, sum = 0, left = 0, right = 0;
        while (right < nums.length || left < nums.length) {
            if (sum < s && right < nums.length) {
                sum += nums[right];
                length++;
                right++;
            } else if ((sum >= s && left < nums.length) || right >= nums.length) {
                sum -= nums[left];
                length--;
                left++;
            }
            if (sum >= s) {
                if (solve > length || solve == 0)
                    solve = length;
            }
        }
        return solve;
    }

    // two pointer optimize
    public int minSubArrayLen2(int s, int[] nums) {
        int solve = Integer.MAX_VALUE, sum = 0, left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= s) {
                if (solve > right - left)
                    solve = right - left;
                sum -= nums[left];
                left++;
            }
        }
        return solve == Integer.MAX_VALUE ? 0 : solve;
    }

    // once move two pointer
    public int minSubArrayLen3(int s, int[] nums) {
        int sum = 0, left = 0, right = 0;
        while (right < nums.length && sum < s) {
            sum += nums[right];
            right++;
        }

        if (sum < s) {
            return 0;
        }

        while (left < nums.length && sum - nums[left] >= s) {
            sum -= nums[left];
            left++;
        }

        while (right < nums.length) {
            sum += nums[right] - nums[left];
            right++;
            left++;
            while (sum - nums[left] >= s) {
                sum -= nums[left];
                left++;
            }
        }

        return right - left;
    }

    // collect each sum
    public int minSubArrayLen4(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        int solve = Integer.MAX_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < sums.length; i++) {
            int target = s + sums[i - 1]; // exclude lower sum

            for (int j = i; j < sums.length; j++) {
                if (sums[j] >= target) {
                    solve = solve >= j - i + 1 ? j - i + 1 : solve;
                    break;
                }
            }
        }

        return solve == Integer.MAX_VALUE ? 0 : solve;
    }

    // collect each sum and using binary search
    public int minSubArrayLen5(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        int solve = Integer.MAX_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < sums.length; i++) {
            int target = s + sums[i - 1]; // exclude lower sum

            int left = i;
            int right = sums.length - 1;
            while (left < right) {
                int mid = (right + left) / 2;
                if (target > sums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (sums[left] >= target) {
                solve = solve >= left - i + 1 ? left - i + 1 : solve;
            }
        }

        return solve == Integer.MAX_VALUE ? 0 : solve;
    }
}
