package com.jake.solution;

public class N0204_CountPrimes {

    // sieve of eratosthenes
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];

        int count = 0;
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                count++;
                int j = i + i;
                while (j < isNotPrime.length) {
                    isNotPrime[j] = true;
                    j += i;
                }
            }
        }
        return count;
    }

    // TODO optimize
}
