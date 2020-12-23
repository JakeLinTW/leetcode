package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0202_HappyNumber {

    // get each number by divide 10's remainder
    public boolean isHappy(int n) {
        Set<Integer> checked = new HashSet<Integer>();

        while (n != 1 && !checked.contains(n)) {
            checked.add(n);
            int temp = 0;
            while (n != 0) {
                int i = n % 10;
                temp += (i * i);
                n /= 10;
            }
            n = temp;
        }

        return n == 1;
    }

    // TODO optimize
}
