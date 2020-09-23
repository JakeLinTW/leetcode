package com.jake.solution;

import java.util.Arrays;
import java.util.stream.Collectors;

public class N0066_PlusOne {

    public static void main(String[] args) {
        int[] r = N0066_PlusOne.plusOne(new int[] { 1, 2, 3 });
        System.out.println(Arrays.stream(r).boxed().collect(Collectors.toList())); // 1,2,4

        r = N0066_PlusOne.plusOne(new int[] { 4, 3, 2, 1 });
        System.out.println(Arrays.stream(r).boxed().collect(Collectors.toList())); // 4,3,2,2

        r = N0066_PlusOne.plusOne(new int[] { 0 });
        System.out.println(Arrays.stream(r).boxed().collect(Collectors.toList())); // 1

        r = N0066_PlusOne.plusOne(new int[] { 9 });
        System.out.println(Arrays.stream(r).boxed().collect(Collectors.toList())); // 10
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length;
        while (i-- > 0) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // no carry
                return digits;
            }
        }

        // carry 1
        int[] r = new int[digits.length + 1];
        r[0] = 1;
        return r;
    }
}
