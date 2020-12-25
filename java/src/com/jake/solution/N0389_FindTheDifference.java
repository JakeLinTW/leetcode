package com.jake.solution;

import java.util.Arrays;

public class N0389_FindTheDifference {

    // sort first
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (sArr[i] != tArr[i]) {
                return tArr[i];
            }
        }
        return tArr[length];
    }

    // use char array
    public char findTheDifference2(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            count[sArr[i] - 'a']++;
        }
        for (int i = 0; i < tArr.length; i++) {
            count[tArr[i] - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return 0;
    }

    // use xor with char array
    public char findTheDifference3(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int num = 0;
        int length = sArr.length;
        for (int i = 0; i < sArr.length; i++) {
            num ^= sArr[i];
            num ^= tArr[i];
        }
        return (char) (num ^= tArr[length]);
    }

    // use xor with byte array
    public char findTheDifference4(String s, String t) {
        byte[] sArr = s.getBytes();
        byte[] tArr = t.getBytes();
        int num = 0;
        int length = sArr.length;
        for (int i = 0; i < sArr.length; i++) {
            num ^= sArr[i];
            num ^= tArr[i];
        }
        return (char) (num ^= tArr[length]);
    }
}
