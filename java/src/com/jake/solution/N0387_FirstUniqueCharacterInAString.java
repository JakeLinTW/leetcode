package com.jake.solution;

public class N0387_FirstUniqueCharacterInAString {

    // use count array
    public int firstUniqChar(String s) {
        char[] cArr = s.toCharArray();
        int[] count = new int[26];
        for (char c : cArr) {
            count[c - 'a']++;
        }
        for (int i = 0, max = cArr.length; i < max; i++) {
            if (count[cArr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // use java library
    public int firstUniqChar2(String s) {
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    // use java library optimize
    public int firstUniqChar3(String s) {
        int idx = Integer.MAX_VALUE;
        for (int i = 'a', max = 'z'; i <= max; i++) {
            int l = s.indexOf((char) i);
            int r = s.lastIndexOf((char) i);
            if (l != -1 && l == r) {
                idx = Math.min(idx, l);
            }
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }

    // use java library optimize
    public int firstUniqChar4(String s) {
        int idx = Integer.MAX_VALUE;
        for (int i = 'a', max = 'z'; i <= max; i++) {
            int l = s.indexOf(i);
            int r = s.lastIndexOf(i);
            if (l == r && l != -1) {
                idx = Math.min(idx, l);
            }
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}
