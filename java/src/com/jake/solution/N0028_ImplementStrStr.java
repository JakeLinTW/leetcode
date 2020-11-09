package com.jake.solution;

public class N0028_ImplementStrStr {

    // using java standard library
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // brute force
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else if (j + 1 == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
