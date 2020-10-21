package com.jake.solution;

public class N0605_CanPlaceFlowers {

    // handle first two and last two element
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int start = 1;
        int end = flowerbed.length - 1;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0)
                count++;
        } else if (flowerbed.length == 2) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0)
                count++;
        } else {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                count++;
                start++;
            }
            if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                count++;
                end--;
            }
        }
        for (int i = start; i < end; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                i++;
            }
        }
        return n <= count;
    }

    // optimized if else
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                i++;
            }
        }
        return n <= count;
    }
    
    // optimized end point
    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                i++;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }
}
