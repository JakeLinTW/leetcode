package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0888_FairCandySwap {

    // collect candy bar and mapping it
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        Set<Integer> candyBarA = new HashSet<Integer>();
        for (int candy : A) {
            sumA += candy;
            candyBarA.add(candy);
        }
        int sumB = 0;
        for (int candy : B) {
            sumB += candy;
        }

        int exchange = (sumA - sumB) / 2;
        for (int candy : B) {
            if (candyBarA.contains(exchange + candy)) {
                return new int[] { exchange + candy, candy };
            }
        }
        return new int[0];
    }

    // collect candy bar and mapping it ( using boolean array )
    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = 0;
        boolean[] candyBarA = new boolean[100001];
        for (int candy : A) {
            sumA += candy;
            candyBarA[candy] = true;
        }
        int sumB = 0;
        for (int candy : B) {
            sumB += candy;
        }

        int[] result = new int[2];
        int exchange = (sumA - sumB) / 2;
        for (int candy : B) {
            int target = candy + exchange;
            if (target >= 0 && target <= 100000 && candyBarA[target]) {
                result[0] = target;
                result[1] = candy;
                break;
            }
        }
        return result;
    }
}
