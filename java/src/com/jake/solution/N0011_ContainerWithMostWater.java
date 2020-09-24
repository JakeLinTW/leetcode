package com.jake.solution;

public class N0011_ContainerWithMostWater {

    public static void main(String[] args) {
        int r = N0011_ContainerWithMostWater.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(r); // 49

        r = N0011_ContainerWithMostWater.maxArea2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(r); // 49
    }

    // nested loop
    public static int maxArea(int[] height) {

        int r = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int h1 = height[i];
                int h2 = height[j];
                int n1 = Math.min(h1, h2);
                int n2 = Math.abs(j - i);
                r = n1 * n2 > r ? n1 * n2 : r;
            }
        }

        return r;
    }

    // two pointer, one pass
    public static int maxArea2(int[] height) {

        int r = 0;
        int p1 = 0;
        int p2 = height.length - 1;
        while (p1 < p2) {
            int n1 = height[p1];
            int n2 = height[p2];
            if (n1 > n2) {
                r = n2 * (p2 - p1) > r ? n2 * (p2 - p1) : r;
                p2--;
            } else {
                r = n1 * (p2 - p1) > r ? n1 * (p2 - p1) : r;
                p1++;
            }
        }

        return r;
    }
}
