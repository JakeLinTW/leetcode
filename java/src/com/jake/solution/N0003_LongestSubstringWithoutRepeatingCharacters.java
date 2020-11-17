package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0003_LongestSubstringWithoutRepeatingCharacters {

    // using hash set
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

    // TODO better time complexity
}
