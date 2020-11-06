package com.jake.solution;

public class N0896_MonotonicArray {

    // count all step
    public boolean isMonotonic(int[] A) {
        int count = 0;
        int eqCount = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                count++;
            } else if (A[i] < A[i - 1]) {
                count--;
            } else {
                eqCount++;
            }
        }
        return Math.abs(count) + eqCount == A.length - 1;
    }

    // using increasing and decreasing flag
    public boolean isMonotonic2(int[] A) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                isIncreasing = true;
            } else if (A[i] < A[i - 1]) {
                isDecreasing = true;
            }
        }
        return !(isIncreasing && isDecreasing);
    }

    // using increasing and decreasing flag ( different init value )
    public boolean isMonotonic3(int[] A) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                isDecreasing = false;
            } else if (A[i] < A[i - 1]) {
                isIncreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

    // using compare
    public boolean isMonotonic4(int[] A) {
        int temp = 0;
        for (int i = 1; i < A.length; i++) {
            int c = Integer.compare(A[i], A[i - 1]);
            if (c != 0) {
                if (c != temp && temp != 0) {
                    return false;
                }
                temp = c;
            }
        }
        return true;
    }
}
