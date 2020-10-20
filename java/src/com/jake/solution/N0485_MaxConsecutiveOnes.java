package com.jake.solution;

public class N0485_MaxConsecutiveOnes {

    // compare count value
    public int findMaxConsecutiveOnes(int[] nums) {

        int r = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > r) {
                r = count;
            }
        }

        return r;
    }

    // compare count value when num != 0 
    public int findMaxConsecutiveOnes2(int[] nums) {

        int r = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > r) {
                    r = count;
                }
                if (r >= nums.length / 2) {
                    return r;
                }
                count = 0;
            }
        }
        return Math.max(r, count);
    }
}
