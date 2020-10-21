package com.jake.solution;

import java.util.Arrays;

public class N0561_ArrayPartitionI {

    // sort first and sum even index value
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int r = 0;
        for (int i = 0; i < nums.length; i += 2) {
            r += nums[i];
        }
        return r;
    }

    // integer range: [-10000, 10000] and calculate sum
    public int arrayPairSum2(int[] nums) {
        int[] counter = new int[20001];
        for (int num : nums) {
            counter[num + 10000] += 1;
        }
        int sum = 0;
        boolean isOdd = true;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                continue;
            }
            int num = i - 10000;
            int count = counter[i];
            if (isOdd) {
                sum += num * ((count + 1) / 2);
            } else {
                sum += num * (count / 2);
            }

            if (count % 2 == 0) {
                isOdd ^= false;
            } else {
                isOdd ^= true;
            }
        }
        return sum;
    }

    // integer range: [-10000, 10000] and check pair numbers per loop
    public int arrayPairSum3(int[] nums) {
        int sumCount = nums.length / 2;

        int[] counter = new int[20001];
        for (int num : nums) {
            counter[num + 10000] += 1;
        }

        int sum = 0;
        int i = 0;
        while (sumCount-- > 0) {
            while (counter[i] == 0) {
                i++;
            }
            sum += i - 10000;
            counter[i]--;
            while (counter[i] == 0) {
                i++;
            }
            counter[i]--;
        }
        return sum;
    }
}
