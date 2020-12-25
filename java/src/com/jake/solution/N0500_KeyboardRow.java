package com.jake.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0500_KeyboardRow {

    // create mapping table
    public String[] findWords(String[] words) {

        boolean[] m1 = new boolean[26];
        String r1 = "qwertyuiop";
        for (char c : r1.toCharArray()) {
            m1[c - 'a'] = true;
        }
        boolean[] m2 = new boolean[26];
        String r2 = "asdfghjkl";
        for (char c : r2.toCharArray()) {
            m2[c - 'a'] = true;
        }

        boolean[] m3 = new boolean[26];
        String r3 = "zxcvbnm";
        for (char c : r3.toCharArray()) {
            m3[c - 'a'] = true;
        }

        List<String> result = new ArrayList<String>();
        for (String word : words) {
            String lw = word.toLowerCase();
            char c0 = lw.charAt(0);
            boolean[] check = null;
            if (r1.indexOf(c0) != -1) {
                check = m1;
            } else if (r2.indexOf(c0) != -1) {
                check = m2;
            } else {
                check = m3;
            }
            boolean isOneRow = true;
            for (char c : lw.toCharArray()) {
                if (!check[c - 'a']) {
                    isOneRow = false;
                    break;
                }
            }
            if (isOneRow) {
                result.add(word);
            }
        }
        return result.toArray(String[]::new);
    }

    // group by hash map
    public String[] findWords2(String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : "qwertyuiop".toCharArray()) {
            map.put(c, 1);
        }
        for (char c : "asdfghjkl".toCharArray()) {
            map.put(c, 2);
        }
        for (char c : "zxcvbnm".toCharArray()) {
            map.put(c, 3);
        }

        List<String> result = new ArrayList<String>();
        for (String word : words) {
            String lw = word.toLowerCase();
            int row = -1;
            boolean isOneRow = true;
            for (char c : lw.toCharArray()) {
                if (row == -1) {
                    row = map.get(c);
                } else if (map.get(c) != row) {
                    isOneRow = false;
                    break;
                }
            }
            if (isOneRow) {
                result.add(word);
            }
        }
        return result.toArray(String[]::new);
    }
}
