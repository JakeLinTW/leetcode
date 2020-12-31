package com.jake.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0438_FindAllAnagramsInAString {

    // compare two array
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        if (p.length() > s.length()) {
            return ans;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (Arrays.compare(sCount, pCount) == 0) {
                ans.add(i);
            }
            if (i + p.length() != s.length()) {
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + p.length()) - 'a']++;
            }
        }
        return ans;
    }

    // TODO optimize
}
