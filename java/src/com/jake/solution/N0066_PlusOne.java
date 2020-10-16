package com.jake.solution;

public class N0066_PlusOne {

    public int[] plusOne(int[] digits) {
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
