package com.jake.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N0242_ValidAnagram {

    // count char with hash map
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0, max = sArr.length; i < max; i++) {
            char sKey = sArr[i];
            char tKey = tArr[i];
            if (!count.containsKey(sKey)) {
                count.put(sKey, 1);
            } else {
                count.put(sKey, count.get(sKey) + 1);
            }
            if (!count.containsKey(tKey)) {
                count.put(tKey, -1);
            } else {
                count.put(tKey, count.get(tKey) - 1);
            }
        }

        for (Integer i : count.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    // count char with array
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] count = new int[256];
        for (int i = 0, max = sArr.length; i < max; i++) {
            count[sArr[i]] += 1;
            count[tArr[i]] -= 1;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    
    // count char with array optimize
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] count = new int[26]; // contains only lowercase alphabets
        for (int i = 0, max = sArr.length; i < max; i++) {
            count[sArr[i] - 'a'] += 1;
            count[tArr[i] - 'a'] -= 1;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    
    // sort char array
    public boolean isAnagram4(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
