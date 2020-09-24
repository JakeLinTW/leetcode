package com.jake.solution;

import java.util.Arrays;
import java.util.stream.Collectors;

public class N0088_MergeSortedArray {

    public static void main(String[] args) {
        int[] r = new int[] { 1, 2, 3, 0, 0, 0 };
        N0088_MergeSortedArray.merge(r, 3, new int[] { 2, 5, 6 }, 3);
        System.out.println(Arrays.stream(r).boxed().collect(Collectors.toList()));
    }

    // two pointer
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        m--;
        n--;
        while (i --> 0) {
            if (n < 0 || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }
}
