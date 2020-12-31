package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0409_LongestPalindrome {

    // calculate char count with hash map
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        int result = 0;
        for (Integer c : count.values()) {
            if (result % 2 != 1 && c % 2 != 0) {
                result++;
            }
            result += (c / 2) * 2;
        }
        return result;
    }

    // calculate char count with array
    public int longestPalindrome2(String s) {
        int[] count = new int[52];
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count[c - 'A']++;
            } else {
                count[c - 'a' + 26]++;
            }
        }
        int result = 0;
        for (int c : count) {
            if (result % 2 != 1 && c % 2 != 0) {
                result++;
            }
            result += (c / 2) * 2;
        }
        return result;
    }
    
    // calculate char count with array 2
    public int longestPalindrome3(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int result = 0;
        for (int c : count) {
            if (result % 2 != 1 && c % 2 != 0) {
                result++;
            }
            result += (c / 2) * 2;
        }
        return result;
    }
}
