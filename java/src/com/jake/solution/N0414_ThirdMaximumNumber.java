package com.jake.solution;

import java.util.Arrays;

public class N0414_ThirdMaximumNumber {

    public static void main(String[] args) {
        int r = new N0414_ThirdMaximumNumber().thirdMax(new int[] { 2, 2, 3, 1 });
        System.out.println(r);
    }

    // collect top three number
    public int thirdMax(int[] nums) {
        Integer one = null, two = null, three = null;
        for (Integer num : nums) {
            if (num.equals(one) || num.equals(two) || num.equals(three)) {
                continue;
            }
            if (one == null || num > one) {
                three = two;
                two = one;
                one = num;
            } else if (two == null || num > two) {
                three = two;
                two = num;
            } else if (three == null || num > three) {
                three = num;
            }
        }

        return three == null ? one : three;
    }

    // use long value
    public int thirdMax2(int[] nums) {
        long one = Long.MIN_VALUE, two = Long.MIN_VALUE, three = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == one || num == two || num == three) {
                continue;
            }
            if (num > one) {
                three = two;
                two = one;
                one = num;
            } else if (num > two) {
                three = two;
                two = num;
            } else if (num > three) {
                three = num;
            }
        }

        return (int) (three == Long.MIN_VALUE ? one : three);
    }

    // sort first
    public int thirdMax3(int[] nums) {
        Arrays.sort(nums);

        long[] top = new long[] { Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE };

        int l = nums.length;
        while (l-- > 0) {
            if (nums[l] > top[0]) {
                top[0] = nums[l];
            } else if (nums[l] > top[1] && nums[l] < top[0]) {
                top[1] = nums[l];
            } else if (nums[l] < top[1]) {
                top[2] = nums[l];
                break;
            }
        }
        return (int) (top[2] == Long.MIN_VALUE ? top[0] : top[2]);
    }

    // sort first and keep max value
    public int thirdMax4(int[] nums) {
        Arrays.sort(nums);

        int max = nums[nums.length - 1];
        int count = 1;
        int l = nums.length;
        while (l-- > 0) {
            if (nums[l] != max) {
                count++;
                max = nums[l];
            }
            if (count == 3) {
                return max;
            }
        }
        return nums[nums.length - 1];
    }
}
