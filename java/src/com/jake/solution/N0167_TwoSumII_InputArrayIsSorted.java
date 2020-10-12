package com.jake.solution;

public class N0167_TwoSumII_InputArrayIsSorted {

    public static void main(String[] args) {
        int[] r = N0167_TwoSumII_InputArrayIsSorted.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(r[0] + "," + r[1]); // 1, 2

        r = N0167_TwoSumII_InputArrayIsSorted.twoSum(new int[] { 2, 3, 4 }, 6);
        System.out.println(r[0] + "," + r[1]); // 1, 3

        r = N0167_TwoSumII_InputArrayIsSorted.twoSum(new int[] { -1, 0 }, -1);
        System.out.println(r[0] + "," + r[1]); // 1, 2
    }

    // two pointer
    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }
        return new int[0];
    }
}
