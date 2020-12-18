package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0290_WordPattern {

    // using two hash map
    public boolean wordPattern(String pattern, String s) {
        char[] cArr = pattern.toCharArray();
        String[] sArr = s.split(" ");

        if (cArr.length != sArr.length) {
            return false;
        }

        Map<Character, String> cMap = new HashMap<Character, String>();
        Map<String, Character> sMap = new HashMap<String, Character>();
        for (int i = 0; i < cArr.length; i++) {
            if (!cMap.containsKey(cArr[i])) {
                cMap.put(cArr[i], sArr[i]);
            } else if (!cMap.get(cArr[i]).equals(sArr[i])) {
                return false;
            }
            
            if (!sMap.containsKey(sArr[i])) {
                sMap.put(sArr[i], cArr[i]);
            } else if (!sMap.get(sArr[i]).equals(cArr[i])) {
                return false;
            }
        }

        return true;
    }
    
    // TODO optimize
}
