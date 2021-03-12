package com.jake.solution;

public class N0424_LongestRepeatingCharacterReplacement {

    // brute force
    public int characterReplacement(String s, int k) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int skip = k;
            char temp = s.charAt(i);
            int j = i;
            for (; j < s.length(); j++) {
                if (temp != s.charAt(j)) {
                    if (skip > 0) {
                        skip--;
                    } else {
                        break;
                    }
                }
            }
            result = j - i + skip > result ? j - i + skip : result;
        }
        return result > s.length() ? s.length() : result;
    }

    // TODO optimize
}
