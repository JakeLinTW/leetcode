package com.jake.solution;

public class N0088_MergeSortedArray {

    // two pointer
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        m--;
        n--;
        while (i-- > 0) {
            if (n < 0 || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }
}
