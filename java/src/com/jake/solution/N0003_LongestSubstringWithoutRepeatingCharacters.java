package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0003_LongestSubstringWithoutRepeatingCharacters {

    // brute force, using hash set
    public int lengthOfLongestSubstring(String s) {
        int solve = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    solve = solve > set.size() ? solve : set.size();
                    set.clear();
                    break;
                }
            }
        }
        return solve > set.size() ? solve : set.size();
    }

    // using string builder
    public int lengthOfLongestSubstring2(String s) {
        StringBuilder sb = new StringBuilder();
        int solve = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            int index = sb.indexOf(temp);
            if (index >= 0) {
                solve = solve > sb.length() ? solve : sb.length();
                sb.delete(0, index + 1);
            }
            sb.append(temp);
        }
        return solve = solve > sb.length() ? solve : sb.length();
    }

    // using hash set optimize
    public int lengthOfLongestSubstring3(String s) {
        int solve = 0;
        Set<Character> set = new HashSet<Character>();
        int rm = 0;
        for (int add = 0; add < s.length(); add++) {
            if (!set.add(s.charAt(add))) {
                solve = solve > set.size() ? solve : set.size();
                set.remove(s.charAt(add));
                while (set.remove(s.charAt(rm++))) {
                }
                set.add(s.charAt(add));
            }
        }
        return solve > set.size() ? solve : set.size();
    }

    // two pointer
    public int lengthOfLongestSubstring4(String s) {
        int solve = 0;
        Set<Character> set = new HashSet<Character>();
        int fast = 0, slow = 0;
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast++));
            } else {
                set.remove(s.charAt(slow++));
            }
            solve = solve > set.size() ? solve : set.size();
        }
        return solve;
    }

    // TODO using hash map
    public int lengthOfLongestSubstring5(String s) {
        char[] chars = s.toCharArray();
        return 0;
    }
    
    // TODO using char array
    public int lengthOfLongestSubstring6(String s) {
        char[] chars = s.toCharArray();
        return 0;
    }
}
